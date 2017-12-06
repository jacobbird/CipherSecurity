/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Shows Username and Password for Site
package CipherSecurity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class GUIUnamePassPage implements IGUIClass {

    BorderPane borderRoot;
    Scene scene;
    
    public GUIUnamePassPage(){
         borderRoot = new BorderPane();
         scene = new Scene(borderRoot, 400, 500);
    }
    
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        ArrayList<Object> pressables = new ArrayList<Object>();
        
        Label label = new Label();
        label.setText("Cipher Security");
        
        Button editBtn = new Button();
        editBtn.setText("Edit");
        
        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    GUIEditSite editPage = (GUIEditSite)args[5];
                    editPage.GUICode(args);
                    editPage.show((Stage)args[1]);
                    }
            });
        
        Button deleteBtn = new Button();
        deleteBtn.setText("Delete");
        
        deleteBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    }
            });
        
        Button backBtn = new Button();
        backBtn.setText("Back");
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                GUISitePage siteDisplay = (GUISitePage)args[3];
                siteDisplay.show((Stage)args[1]);
                System.out.println("back");
            }
        });
        
//        StackPane root = new StackPane();
//        root.getChildren().add(label);
//        root.getChildren().add(btn);
        
        GridPane resultsPane = new GridPane();
        VBox siteVBox = new VBox();
        ScrollPane siteScrPane = new ScrollPane();
        BorderPane settingsOpenPane = new BorderPane();
        BorderPane editNew = new BorderPane();
        HBox editNewHor = new HBox();
        
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
        
        //borderRoot.setCenter(resultsPane);
        borderRoot.setCenter(resultsPane);
        //borderRoot.setLeft(siteScrPane);
        //borderRoot.setTop(settingsOpenPane);
        borderRoot.setBottom(editNew);
        borderRoot.setPadding(new Insets(0, 10, 0, 10));
        
        String font = "Times New Roman";
        
        Font lblFont = new Font(font, 32.00);
        label.setFont(lblFont);
        
        label.setTextFill(Color.WHITE);
        settingsOpenPane.setLeft(label);
        settingsOpenPane.setBackground(new Background(new BackgroundFill(
                Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        //settingsOpenPane.setRight(settingsBtn);
        settingsOpenPane.setPadding(new Insets(10, 10, 10, 10));
        
        editNew.setRight(editNewHor);
        editNewHor.getChildren().add(backBtn);
        editNewHor.getChildren().add(deleteBtn);
        editNewHor.getChildren().add(editBtn);
        
        
        editNewHor.setPadding(new Insets(10,10,10,10));
        editNewHor.setSpacing(10.00);
        
        siteVBox.setPadding(new Insets(10, 10, 10, 10));
        
        siteScrPane.setContent(siteVBox);
        
        resultsPane.setHgap(10);
        resultsPane.setVgap(10);
        resultsPane.setPadding(new Insets(20, 20, 20, 20));

        Text usrNameTitle = new Text("User Name:");
        usrNameTitle.setFont(Font.font(font, FontWeight.BOLD, 20));
        resultsPane.add(usrNameTitle, 1, 0); 

        Text usrNameText = new Text("");
        usrNameText.setFont(Font.font(font, FontWeight.BOLD, 20));
        resultsPane.add(usrNameText, 2, 0);
        
        Text passwordTitle = new Text("Password:");
        passwordTitle.setFont(Font.font(font, FontWeight.BOLD, 20));
        resultsPane.add(passwordTitle, 1, 1); 

        Text passwordText = new Text("");
        passwordText.setFont(Font.font(font, FontWeight.BOLD, 20));
        resultsPane.add(passwordText, 2, 1);
        
        UserNamePassword usrNamePass = (UserNamePassword)args[0];
        
        usrNameText.setText(usrNamePass.getUserName());
        passwordText.setText(usrNamePass.getPassword());

        //Button[] btnArr = (Button[])siteBtns.toArray();
        pressables.add(backBtn);
        pressables.add(editBtn);
        
        return pressables;
    }

    @Override
    public void show(Stage s) {
        s.setTitle("Cipher Security: Password Saver");
        s.setScene(scene);
        s.show();
    }
    
}
