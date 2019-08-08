/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_gr_mining;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Leyteris
 */
public class Car_mining_functions {
    
    public String getCarId(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {
            if (e.text().equals("Νούμερο αγγελίας:")) {
                //System.out.println(e.parent().child(1).text());
                System.out.println(e.parent().child(1).text());
                return e.parent().child(1).text();
            }
            //System.out.println(e.text());
        }
        //System.out.println(e.get(1).parent().child(1).text());
        
        return null;
    }
    public String getCarTitle(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Μάρκα/Μοντέλο:")) {   
                System.out.println(e.parent().child(1).text());
                return e.parent().child(1).text();
            }           
        } 
        return null;
    }
    public String getCarDate(Document doc) {
       Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().matches("Χρονολογία")) {   
                System.out.println(e.parent().child(1).text());
                return e.parent().child(1).text();
            }           
        } 
        
        return null;
    }
    
    public String getCarDescription(Document doc) {
        //todo elegxos an yparxei perigrafi
        String desc=doc.getElementById("desc_message").text();
        System.out.println(desc);
        
        return null;
    }
    public String getCarSeller(Document doc) {
        Elements e = doc.getElementsByClass("p_l");
        String seller=e.text();
        System.out.println(seller);
               
        return seller;
    }
    public String getCarSpecialties(Document doc) {
        Elements e = doc.getElementsByClass("extras-container");
        String extras = e.text();
        System.out.println(extras);
        
        return extras;
    }
    public String getCarKteo(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Κτεο εως:")) {   
                System.out.println(e.parent().child(1).text());
                return e.parent().child(1).text();
            }           
        } 
        
        return null;
    }
    public int getCarPrice(Document doc) {      
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Τιμή:")) {   
                String result="";
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(e.parent().child(1).text());
                while (m.find()) {
                    result+=m.group();                   
                }
                //System.out.println(result);
                System.out.println(Integer.parseInt(result));
                return Integer.parseInt(result);
            }           
        }         

        return 0;
    }
    public int getCarMilage(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Χιλιόμετρα:")) {   
                String result="";
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(e.parent().child(1).text());
                while (m.find()) {
                    result+=m.group();                   
                }
                //System.out.println(result);
                System.out.println(Integer.parseInt(result));
                return Integer.parseInt(result);
            }           
        }         
             
        return 0;
    }
    public int getCarCc(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Κυβικά:")) {   
                String result="";
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(e.parent().child(1).text());
                while (m.find()) {
                    result+=m.group();                   
                }
                //System.out.println(result);
                System.out.println(Integer.parseInt(result));
                return Integer.parseInt(result);
            }           
        }   
               
        return 0;
    }
    public int getCarOwners(Document doc) {       
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Προηγούμενοι κάτοχοι:")) {   
                String result="";
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(e.parent().child(1).text());
                while (m.find()) {
                    result+=m.group();                   
                }
                //System.out.println(result);
                System.out.println(Integer.parseInt(result));
                return Integer.parseInt(result);
            }           
        }   
        
        return 0;
    }
    public String getCarLast_change(Document doc) {
        LocalDateTime myDateObj = LocalDateTime.now(); 
        LocalDateTime after = myDateObj.minusHours(9);
        System.out.println("Before formatting: " + after); 
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 

        String formattedDate = after.format(myFormatObj); 
        System.out.println("After formatting: " + formattedDate);
        
        String s="1 ώρα";
        
        
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Τελευταία αλλαγή:")) {   
                String dat=e.parent().child(1).text();
                if (s.matches(".*(μήνες και πάνω)")) {
                    //System.out.println("2 mines match");
                    //split
                } else {
                    if (s.matches(".*(μέρες|μέρα)")) {
                        //System.out.println("meres match");
                    } else {
                        //System.out.println("ores match");
                    }
                }
                
                return dat;
            }           
        } 
        
        return null;
    }
    public int getCarViews(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Εμφανίσεις αγγελίας:")) {                  
                System.out.println(e.parent().child(1).text());
                return Integer.parseInt(e.parent().child(1).text());
            }           
        }   

        return 0;
    }
    public int getCarHp(Document doc) {
        Elements elements=doc.getElementsByClass("half-width-inside");
        
        for (Element e:elements) {           
            if (e.text().equals("Ίπποι:")) {   
                String result="";
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(e.parent().child(1).text());
                while (m.find()) {
                    result+=m.group();                   
                }
                //System.out.println(result);
                System.out.println(Integer.parseInt(result));
                return Integer.parseInt(result);
            }           
        }   
               
        return 0;
    }
}
   
    