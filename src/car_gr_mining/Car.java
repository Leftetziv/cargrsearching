/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_gr_mining;

/**
 *
 * @author Leyteris
 */
public class Car {
    String url,id,title,date,description,seller,specialties,kteo,last_change;
    int price,milage,cc,owners,views,hp;
    
    public void print_car() {
        System.out.println("URL: "+url);
        System.out.println("ID: "+id);
        System.out.println("Title: "+title);
        System.out.println("Manufacture date: "+date);
        System.out.println("Description: "+description);
        System.out.println("Seller: "+seller);
        System.out.println("Extras: "+specialties);
        System.out.println("KTEO: "+kteo);
        System.out.println("Last modifified:"+last_change);
        System.out.println("Price: "+price);
        System.out.println("Milage: "+milage);
        System.out.println("Displacement: "+cc);
        System.out.println("Previous Owners: "+owners);
        System.out.println("Views: "+views);
        System.out.println("HP:"+hp);
    }
    
}
