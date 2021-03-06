/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.GUI;

import java.io.File;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class GUINewUser implements IGUIClass{

    StackPane entryPane;
    Scene scene;
    
    public GUINewUser(){
        entryPane = new StackPane();
        scene = new Scene(entryPane, 400, 500);
    
    }
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        
        ArrayList<Object> pressables = new ArrayList<Object>();
        
        // Create Boxes
        VBox entryBox = new VBox();
        HBox entryHBoxTitle = new HBox();
        HBox entryHBox = new HBox();
        HBox entryHBox2 = new HBox();
        HBox entryHBox3 = new HBox();
        HBox entryHBox4 = new HBox();
        VBox entryVBox2 = new VBox();
        entryVBox2.prefWidth(40);
        VBox entryVBox3 = new VBox();
        entryVBox3.prefWidth(40);
        VBox entryVBox4 = new VBox();
        entryVBox4.prefWidth(40);
        VBox entryVBox5 = new VBox();
        entryVBox5.prefWidth(40);
        VBox entryVBox6 = new VBox();
        entryVBox6.prefWidth(40);
        VBox entryVBox7 = new VBox();
        entryVBox7.prefWidth(40);
        
        String font = "Times New Roman";
        
        Text title = new Text("New User");
        title.setFont(new Font(font, 24));
       
        entryHBoxTitle.getChildren().add(title);
        entryHBox.getChildren().addAll(entryVBox2, entryVBox3);
        entryHBox2.getChildren().addAll(entryVBox4, entryVBox5);
        entryHBox3.getChildren().addAll(entryVBox6, entryVBox7);
        entryBox.getChildren().addAll(entryHBoxTitle, entryHBox, entryHBox2, entryHBox3, entryHBox4);
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
        
        // For Password Verification
        // Passwords must match
        Label entryPWLabel2 = new Label("Verify PW: ");
        entryPWLabel.setMinWidth(70);
        entryVBox6.getChildren().add(entryPWLabel2);
        entryVBox6.setAlignment(Pos.CENTER_RIGHT);
        
        PasswordField entryPassword2 = new PasswordField();
        entryVBox7.getChildren().add(entryPassword2);
        
        // Added Back Button to New User
        Button backBtn = new Button();
        backBtn.setText("Back");

        backBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                GUILogin loginPage = (GUILogin) args[4];
                loginPage.GUICode(args);
                loginPage.show((Stage) args[1]);
            }
        });
        
        entryHBox4.getChildren().add(backBtn);
        // End Back Button
        
        Button go = new Button("Create");  // New User "Profile"

        go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    
                    // Create Empty File
                    // *Doesn't actually (Not until a site is added)*
                    String path = "./" + GUILogin.getUserNameString() + ".txt";
                    File file = new File(path);
                    
                    // Return to Login Page
                    GUILogin loginPage = (GUILogin) args[4];
                    loginPage.GUICode(args);
                    loginPage.show((Stage) args[1]);
                    
                    /*
                    // Auto Login
                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    */
                    
                    }
            });
        
        entryHBox4.getChildren().add(go);
        pressables.add(go);
       
        
        entryBox.setAlignment(Pos.CENTER);
        entryHBoxTitle.setAlignment(Pos.CENTER);
        entryHBox.setPadding(new Insets(5,5,5,5));
        entryHBox.setAlignment(Pos.CENTER);
        entryHBox2.setPadding(new Insets(5,5,5,5));
        entryHBox2.setAlignment(Pos.CENTER);
        entryHBox3.setPadding(new Insets(5,5,5,5));
        entryHBox3.setAlignment(Pos.CENTER);
        entryHBox4.setPadding(new Insets(5,5,5,5));
        entryHBox4.setAlignment(Pos.CENTER);
        
        
        // Load Background Image
        BackgroundImage myBI= new BackgroundImage(new javafx.scene.image.Image(getClass().getResource("Background.jpg").toExternalForm()),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);

        // Set Image to Background (No re-sizeability)
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
