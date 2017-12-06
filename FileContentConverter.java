/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob
 */
public class FileContentConverter {
    private List<UserNamePassword> sites = new ArrayList<UserNamePassword>();
    
    public FileContentConverter(String fileName){
        //Testing code
       String site1 = "Google";
       String site2 = "Yahoo";
       String site3 = "Yelp";
       String site4 = "Bing";
       
       UserNamePassword one = new UserNamePassword(site1,site1,site1);
       UserNamePassword two = new UserNamePassword(site2,site2,site2);
       UserNamePassword three = new UserNamePassword(site3,site3,site3);
       UserNamePassword four = new UserNamePassword(site4,site4,site4);
       
       this.sites.add(one);
       this.sites.add(two);
       this.sites.add(three);
       this.sites.add(four);
    }
    
    public List<UserNamePassword> getSites(){
       /*
        Code goes here to retireve the site information from the file.
        */ 
       // Encryption happens
       return this.sites;
    }
    
    public void addSite(UserNamePassword unp){this.sites.add(unp);
    
    
    }
    
}
