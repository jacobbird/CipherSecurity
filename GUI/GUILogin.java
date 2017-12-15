/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.GUI;

import CipherSecurity.Methods.RSA;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class GUILogin implements IGUIClass{

    StackPane entryPane;
    Scene scene;
    
    // To access Outside of Login Class
    static String entryUserNameString;
    String entryPasswordString;
    static RSA dec = new RSA();
    
    public GUILogin(){
        entryPane = new StackPane();
        scene = new Scene(entryPane, 400, 500);
    
    }
    
    // Gets for RSA Stuff
    public static String getUserNameString()
    {

        return GUILogin.entryUserNameString;
    }
    public String getPasswordString()
    {
        return this.entryPasswordString;
    }

    
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        
        ArrayList<Object> pressables = new ArrayList<Object>();
        
        // Create Boxes
        VBox entryBox = new VBox();
        HBox entryHBox = new HBox();
        HBox entryHBox2 = new HBox();
        HBox entryHBox3 = new HBox();
        VBox entryVBox2 = new VBox();
        entryVBox2.prefWidth(40);
        VBox entryVBox3 = new VBox();
        entryVBox3.prefWidth(40);
        VBox entryVBox4 = new VBox();
        entryVBox2.prefWidth(40);
        VBox entryVBox5 = new VBox();
        entryVBox3.prefWidth(40);
        VBox entryVBox6 = new VBox();
        VBox entryVBox7 = new VBox();
        
        entryHBox.getChildren().addAll(entryVBox2, entryVBox3);
        entryHBox2.getChildren().addAll(entryVBox4, entryVBox5);
        entryBox.getChildren().addAll(entryHBox, entryHBox2, entryHBox3);
        entryPane.getChildren().add(entryBox);
        
        // Create Textfields and Associated Labels and Allign
        Label entryUNLabel = new Label("User Name: ");
        entryUNLabel.setMinWidth(70);
        entryVBox2.getChildren().add(entryUNLabel);
        entryVBox2.setAlignment(Pos.CENTER_RIGHT);
        
        TextField entryUserName = new TextField();
       
        entryVBox3.getChildren().add(entryUserName);
        
        Label entryPWLabel = new Label("Password: ");
        entryPWLabel.setMinWidth(70);
        entryVBox4.getChildren().add(entryPWLabel);
        entryVBox4.setAlignment(Pos.CENTER_RIGHT);
        

        PasswordField entryPassword = new PasswordField();
        entryVBox5.getChildren().add(entryPassword);
        
        Button go = new Button("Login");  // Login
        
        go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    
                    // Set the Username and Password
                    // Always enter a username, otherwise error
                    entryUserNameString = entryUserName.getText();  // Set Username
                    entryPasswordString = entryPassword.getText();

                    args[0] = getUserNameString();

                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    }
            });
        
        entryVBox7.getChildren().add(go);
        pressables.add(go);
        entryVBox7.setPadding(new Insets(2,2,2,2));
        

        Button newFile = new Button("New User"); // New User
        
        newFile.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    GUINewUser newUser = (GUINewUser)args[6];
                    newUser.GUICode(args);
                    newUser.show((Stage)args[1]);
                    System.out.println(args);
                    }
            });
        
        entryVBox6.getChildren().add(newFile);
        pressables.add(newFile);
        entryVBox6.setPadding(new Insets(2,2,2,2));
        entryHBox3.getChildren().addAll(entryVBox6,entryVBox7);
        
        entryBox.setAlignment(Pos.CENTER);
        entryHBox.setPadding(new Insets(5,5,5,5));
        entryHBox.setAlignment(Pos.CENTER);
        entryHBox2.setPadding(new Insets(5,5,5,5));
        entryHBox2.setAlignment(Pos.CENTER);
        entryHBox3.setAlignment(Pos.BASELINE_CENTER);
        
        
        
        entryBox.setAlignment(Pos.CENTER);
        entryHBox.setPadding(new Insets(5,5,5,5));
        entryHBox.setAlignment(Pos.CENTER);
        entryHBox2.setPadding(new Insets(5,5,5,5));
        entryHBox2.setAlignment(Pos.CENTER);
        entryHBox3.setAlignment(Pos.BASELINE_CENTER);
        
        
        BackgroundImage myBI= new BackgroundImage(new javafx.scene.image.Image(getClass().getResource("Background.jpg").toExternalForm()),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);

        entryPane.setBackground(new Background(myBI));
        
        return pressables;
        
    }
    

    @Override
    public void show(Stage s) {
        s.setTitle("PassSafe: Password Saver");
        s.setScene(scene);
        s.show();
    }
    
}
