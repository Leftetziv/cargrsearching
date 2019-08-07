/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car.gr.mining;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author Leyteris
 */
public class CarGrMining {
    
    static String first_page="https://www.car.gr/classifieds/cars/?sort=dm&price=%3C10000&mileage=%3E1000&mileage=%3C125000&engine_size=%3C1900&offer_type=sale&make=192&model=347&rg=3&significant_damage=f"; 
    
    static int webpages_number=0;  //arithmos selidon 
    static ArrayList<String> webpages_links = new ArrayList<String>();  //lista me ta links ton selidon
    static ArrayList<String> carpages_links = new ArrayList<String>();  //lista me ta links ton autokiniton
    static ArrayList<Car> cars = new ArrayList<Car>();
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        String source_firstpage=fetch_page(first_page+"&pg=1");
        //System.out.println(source);
        
        setWebpages_number(source_firstpage);
        setWebpages_links();
        setCarpages_links();
        setCars();
        /*        
        for (String s:webpages_links) {
            System.out.println(s);
        }
        System.out.println("");
        System.out.println("Number of cars: "+carpages_links.size());
        for (String s:carpages_links) {
            System.out.println(s);
        }*/  
    }
    
    public static String fetch_page(String webpage) throws MalformedURLException, IOException {      
        String source = Jsoup.connect(webpage).get().html();      
        return source;
    }
    
    public static void setWebpages_number (String source) {
        Document doc = Jsoup.parse(source);
        
        Element s=doc.getElementsByClass("pagination pull-right").first();
        String webpage_number=s.child((s.childNodeSize()-3)/2-1).child(0).text();    
        if ("«".equals(webpage_number)) {
            webpages_number=1;
        } else {
            webpages_number=Integer.parseInt(webpage_number);
        }
        System.out.println("Number of webpages: "+webpages_number);
        System.out.println("");
    }
    
    public static void setWebpages_links () {
        for (int i=1;i<=webpages_number;i++) {
            webpages_links.add(first_page+"&pg="+i);
        }          
    }
    
    public static void setCarpages_links () throws IOException {                
        for (String page:webpages_links) {
            String source = fetch_page(page);
            Document doc = Jsoup.parse(source);                         
            Element s=doc.getElementsByClass("clsfd_list list-group list ").first();           
            Elements links = s.select("a[href]");
            for (Element link : links) {
                carpages_links.add(link.attr("href"));
                //System.out.println(link.attr("href"));               
            }
        }       
    }
    
    public static void setCars() throws IOException {
        /*for (String s:carpages_links) {
            Car car=new Car();
            Car_mining_functions func=new Car_mining_functions();
            String source=fetch_page("https://www.car.gr"+s);
            Document doc = Jsoup.parse(source);
            car.title=func.getCarTitle(doc);
            car.cc=func.getCarCc(doc);
            car.date=func.getCarDate(doc);
            car.description=func.getCarDescription(doc);
            car.hp=func.getCarHp(doc);
            car.id=func.getCarId(doc);
            car.kteo=func.getCarKteo(doc);
            car.last_change=func.getCarLast_change(doc);
            car.milage=func.getCarMilage(doc);
            car.owners=func.getCarOwners(doc);
            car.price=func.getCarPrice(doc);
            car.seller=func.getCarSeller(doc);
            car.specialties=func.getCarSpecialties(doc);          
            car.url=s;
            car.views=func.getCarViews(doc);
            cars.add(car);
        }*/
        Car car=new Car();
        Car_mining_functions func=new Car_mining_functions();
        String source=fetch_page("https://www.car.gr"+carpages_links.get(0));
        Document doc = Jsoup.parse(source);
        car.title=func.getCarTitle(doc);
        car.cc=func.getCarCc(doc);
        car.date=func.getCarDate(doc);
        car.description=func.getCarDescription(doc);
        car.hp=func.getCarHp(doc);
        car.id=func.getCarId(doc);
        car.kteo=func.getCarKteo(doc);
        car.last_change=func.getCarLast_change(doc);
        car.milage=func.getCarMilage(doc);
        car.owners=func.getCarOwners(doc);
        car.price=func.getCarPrice(doc);
        car.seller=func.getCarSeller(doc);
        car.specialties=func.getCarSpecialties(doc);       
        //car.url=s;
        car.views=func.getCarViews(doc);
        
    }
}
