/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity;

import Methods.RSA;
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
    String entryUserNameString;
    String entryPasswordString;
    
    public GUILogin(){
        entryPane = new StackPane();
        scene = new Scene(entryPane, 400, 500);
    
    }
    
    // Gets for RSA Stuff
    public String getUserNameString()
    {
        // Won't do what you think
        // Will be null until User presses Login
        // Will register String change once backed out
        return this.entryUserNameString;
    }
    public String getPasswordString()
    {
        return this.entryPasswordString;
    }
    // End Gets for RSA Stuff
    
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        
        ArrayList<Object> pressables = new ArrayList<Object>();
        
        
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
        
        //Button go = new Button("go!");  // Login
        Button go = new Button("Login");  // Login
        
        go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    // Set the Username and Password
                    entryUserNameString = entryUserName.getText();  // Set Username
                    entryPasswordString = entryPassword.getText();
                    System.out.println("Incoming Profile Username(Textfield): " + getUserNameString());
                    //System.out.println(getPasswordString());
                    
                    args[0] = getUserNameString();
                    
                    System.out.println("Outgoing Profile Username(to SitePage): " + args[0]);
                    //System.out.println(args[1]);
                    //System.out.println(args[2]);
                    //System.out.println(args[3]);
                    
                    RSA user = new RSA();
                    user.convert("Hello", 'e');
                    
                    //System.out.println(entryUserName.getText());  // Returns Username Entry
                    //System.out.println(entryPassword.getText());  // Returns Password Entry
                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    }
            });
        
        entryVBox7.getChildren().add(go);
        pressables.add(go);
        entryVBox7.setPadding(new Insets(2,2,2,2));
        
        //Button newFile = new Button("new"); // New User
        Button newFile = new Button("New User"); // New User
        
        newFile.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    GUINewUser newUser = (GUINewUser)args[6];
                    newUser.GUICode(args);
                    newUser.show((Stage)args[1]);
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
        
        /*StackPane entryPane = new StackPane();
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
        
        Button go = new Button("go!");
        entryVBox7.getChildren().add(go);
        entryVBox7.setPadding(new Insets(2,2,2,2));
        Button newFile = new Button("new");
        entryVBox6.getChildren().add(newFile);
        entryVBox6.setPadding(new Insets(2,2,2,2));
        entryHBox3.getChildren().addAll(entryVBox6,entryVBox7);*/
        
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
        //s.setTitle("Cipher Security: Password Saver");
        s.setTitle("PassSafe: Password Saver");
        s.setScene(scene);
        s.show();
    }
    
}
