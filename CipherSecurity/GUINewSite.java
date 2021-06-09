/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.CipherSecurity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
public class GUINewSite implements IGUIClass{

    StackPane entryPane;
    Scene scene;
    
    public GUINewSite(){
        entryPane = new StackPane();
        scene = new Scene(entryPane, 400, 500);
    
    }
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        
        ArrayList<Object> pressables = new ArrayList<Object>();
        
        
        VBox entryBox = new VBox();
        HBox entryHBoxTitle = new HBox();
        HBox entryHBox = new HBox();
        HBox entryHBox2 = new HBox();
        HBox entryHBox3 = new HBox();
        HBox entryHBox4 = new HBox();
        HBox entryHBox5 = new HBox();
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
        VBox entryVBox8 = new VBox();
        entryVBox8.prefWidth(40);
        VBox entryVBox9 = new VBox();
        entryVBox9.prefWidth(40);
        
        String font = "Times New Roman";
        
        Text title = new Text("New Site");
        title.setFont(new Font(font, 24));
       
        entryHBoxTitle.getChildren().add(title);
        entryHBox.getChildren().addAll(entryVBox2, entryVBox3);
        entryHBox2.getChildren().addAll(entryVBox4, entryVBox5);
        entryHBox3.getChildren().addAll(entryVBox6, entryVBox7);
        entryHBox4.getChildren().addAll(entryVBox8, entryVBox9);
        entryBox.getChildren().addAll(entryHBoxTitle, entryHBox, entryHBox2, entryHBox3, entryHBox4, entryHBox5);
        entryPane.getChildren().add(entryBox);
        
        Label entrySiteName = new Label("Site Name: ");
        entrySiteName.setMinWidth(70);
        entryVBox2.getChildren().add(entrySiteName);
        entryVBox2.setAlignment(Pos.CENTER_RIGHT);
        
        TextField entrySiteNameT = new TextField();
        entryVBox3.getChildren().add(entrySiteNameT);
        
        Label entryUNLabel = new Label("User Name: ");
        entryUNLabel.setMinWidth(70);
        entryVBox4.getChildren().add(entryUNLabel);
        entryVBox4.setAlignment(Pos.CENTER_RIGHT);
        
        TextField entryUserName = new TextField();
        entryVBox5.getChildren().add(entryUserName);
        
        Label entryPWLabel = new Label("Password: ");
        entryPWLabel.setMinWidth(70);
        entryVBox6.getChildren().add(entryPWLabel);
        entryVBox6.setAlignment(Pos.CENTER_RIGHT);
        
        PasswordField entryPassword = new PasswordField();
        entryVBox7.getChildren().add(entryPassword);
        
        Label entryPWLabel2 = new Label("Other Info: ");
        entryPWLabel2.setMinWidth(70);
        entryVBox8.getChildren().add(entryPWLabel2);
        entryVBox8.setAlignment(Pos.CENTER_RIGHT);
        
        TextField entryPassword2 = new TextField();
        entryVBox9.getChildren().add(entryPassword2);
        
        Button go = new Button("Create");  // Create new Site
        
        go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    
                        UserNamePassword unp = new UserNamePassword();
                        unp.setSiteName(entrySiteNameT.getText());
                        unp.setUserName(entryUserName.getText());
                        unp.setPassword(entryPassword.getText());
                        System.out.println(unp.getSiteName());
                        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                        try {
                            GUISitePage.addNew(unp);
                        } catch (IOException ex) {
                            Logger.getLogger(GUINewSite.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    }
            });
        
        entryHBox5.getChildren().add(go);
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
        entryHBox5.setPadding(new Insets(5,5,5,5));
        entryHBox5.setAlignment(Pos.CENTER);
       


        entryPane.setStyle("-fx-background-color: lightblue");  // lightblue
        
        // Other Color
        // #f0f8ff

        return pressables;
        
    }

    @Override
    public void show(Stage s) {
        s.setTitle("PassSafe: Password Saver (Add New Site)");
        s.setScene(scene);
        s.show();
    }
    
}
