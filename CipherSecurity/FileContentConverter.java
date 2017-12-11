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

    private List<UserNamePassword> sites = new ArrayList<UserNamePassword>();

    public FileContentConverter(String fileName) throws FileNotFoundException {
        //Testing code
        RSA dec = new RSA();
        String path = "src/CipherSecurity/LockedUpSaves.txt";
        File file = new File(path);

        Scanner fileRead = new Scanner(file);
        while (fileRead.hasNext()) {
            UserNamePassword entry = new UserNamePassword();

            String line = fileRead.nextLine();
            if (line.contains(",")) {
                String sub = line.substring(line.indexOf(',') + 1);
                System.out.println(sub);
                if (sub.contains(",")) {
                    String[] a = line.split(",");
                    entry.setSiteName(dec.convert(a[0], 'd'));
                    entry.setUserName(dec.convert(a[1], 'd'));
                    entry.setPassword(dec.convert(a[2], 'd'));
                    this.sites.add(entry);

                } else {
                    System.out.println("Nooooooooooooooo");
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

}
