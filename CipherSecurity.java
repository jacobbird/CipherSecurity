/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class CipherSecurity extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        label.setText("Cipher Security");
        
        
        Button openBtn = new Button();
        openBtn.setText("Open");
        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Open");
            }
        });
        
        Button settingsBtn = new Button();
        settingsBtn.setText("Settings");
        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Settings");
            }
        });
        
//        StackPane root = new StackPane();
//        root.getChildren().add(label);
//        root.getChildren().add(btn);
        
        BorderPane borderRoot = new BorderPane();
        
        GridPane resultsPane = new GridPane();
        VBox siteVBox = new VBox();
        ScrollPane siteScrPane = new ScrollPane();
        BorderPane settingsOpenPane = new BorderPane();
        
        borderRoot.setCenter(resultsPane);
        borderRoot.setLeft(siteScrPane);
        borderRoot.setTop(settingsOpenPane);
        borderRoot.setPadding(new Insets(0, 10, 0, 10));
        
        settingsOpenPane.setLeft(openBtn);
        settingsOpenPane.setRight(settingsBtn);
        settingsOpenPane.setPadding(new Insets(10, 10, 10, 10));
        
        siteVBox.setPadding(new Insets(10, 10, 10, 10));
        
        siteScrPane.setContent(siteVBox);
        
        resultsPane.setHgap(10);
        resultsPane.setVgap(10);
        resultsPane.setPadding(new Insets(20, 20, 20, 20));

        Text usrNameTitle = new Text("User Name:");
        usrNameTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        resultsPane.add(usrNameTitle, 1, 0); 

        Text usrNameText = new Text("");
        usrNameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        resultsPane.add(usrNameText, 2, 0);
        
        Text passwordTitle = new Text("Password:");
        passwordTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        resultsPane.add(passwordTitle, 1, 1); 

        Text passwordText = new Text("");
        passwordText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        resultsPane.add(passwordText, 2, 1);
        
        FileContentConverter testContent = new FileContentConverter("testFile");
        List<UserNamePassword> siteList= testContent.getSites();        
        Iterator siteListIter = siteList.iterator();
        
        List<Button> siteBtns = new ArrayList<Button>();
        
        int i = 0;
        while(siteListIter.hasNext()){
            Button siteBtn = new Button();
            
            UserNamePassword usrNamePass = (UserNamePassword)siteListIter.next();
            siteBtn.setText(usrNamePass.getSiteName());
            
            
            siteBtn.setOnAction(new EventHandler<ActionEvent>() {
            
                @Override
                public void handle(ActionEvent event) {
                    usrNameText.setText(usrNamePass.getUserName());
                    passwordText.setText(usrNamePass.getPassword());
                }
            });
            
            siteBtns.add(siteBtn);
            
            siteVBox.getChildren().add(siteBtns.get(i));
            
            i++;
        }
        
        //Button[] btnArr = (Button[])siteBtns.toArray();
        
        Scene scene = new Scene(borderRoot, 300, 250);
        
        primaryStage.setTitle("Cipher Security: Passwords Saver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
