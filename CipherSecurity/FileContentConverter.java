/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.CipherSecurity;

import CipherSecurity.Methods.RSA;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Jacob
 */
public class FileContentConverter {

    public List<UserNamePassword> sites = new ArrayList<UserNamePassword>();

    public FileContentConverter(String fileName) throws FileNotFoundException {
        
        String path = "./" + GUILogin.getUserNameString() + ".txt";
        File file = new File(path);
        
        boolean exists = file.exists();
        
        if(exists){
            Scanner fileRead = new Scanner(file);
        while (fileRead.hasNext()) {
            UserNamePassword entry = new UserNamePassword();

            String line = fileRead.nextLine();
            if (line.contains(",")) {
                String sub = line.substring(line.indexOf(',') + 1);
                System.out.println(sub);
                if (sub.contains(",")) {
                    String[] a = line.split(",");
                    entry.setSiteName(GUILogin.dec.convert(a[0], 'd'));
                    entry.setUserName(GUILogin.dec.convert(a[1], 'd'));
                    entry.setPassword(GUILogin.dec.convert(a[2], 'd'));
                    this.sites.add(entry);

                } else {
                    System.out.println("Nooooooooooooooo");
                }
            }
        }
        }

    }

    public List<UserNamePassword> getSites() {
        return this.sites;
    }

    public void addSite(UserNamePassword unp) {
        this.sites.add(unp);

    }
    
    public void clearList() {
        this.sites.clear();
    }
}
