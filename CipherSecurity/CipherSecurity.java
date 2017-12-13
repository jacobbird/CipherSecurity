/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.CipherSecurity;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class CipherSecurity extends Application {
    
    @Override
    public void start(Stage primaryStage) {
          
        Object[] nullArray = new Object[0];
        
        GUILogin login = new GUILogin();
        GUINewUser newUser = new GUINewUser();
        GUISitePage siteDisplay = new GUISitePage();
        GUIUnamePassPage GUIUNPP = new GUIUnamePassPage();
        GUIEditSite editSite = new GUIEditSite();
        GUINewSite newSite = new GUINewSite();
        
        Object[] uNPPageArgs = new Object[50];
        UserNamePassword usrNamePass = new UserNamePassword();
        uNPPageArgs[0] = usrNamePass;
        uNPPageArgs[1] = primaryStage;
        uNPPageArgs[2] = GUIUNPP;
        uNPPageArgs[3] = siteDisplay;
        uNPPageArgs[4] = login;
        uNPPageArgs[5] = editSite;
        uNPPageArgs[6] = newUser;
        uNPPageArgs[7] = newSite;
        
        
        login.GUICode(uNPPageArgs);
        login.show(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
