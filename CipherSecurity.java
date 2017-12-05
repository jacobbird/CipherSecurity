/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity;

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
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
        
        Object[] uNPPageArgs = new Object[50];
        UserNamePassword usrNamePass = new UserNamePassword();
        uNPPageArgs[0] = usrNamePass;
        uNPPageArgs[1] = primaryStage;
        uNPPageArgs[2] = GUIUNPP;
        uNPPageArgs[3] = siteDisplay;
        uNPPageArgs[4] = login;
        uNPPageArgs[5] = editSite;
        uNPPageArgs[6] = newUser;
        
        /*Button go = (Button)login.GUICode(uNPPageArgs).get(0);
        Button go2 = (Button)newUser.GUICode(uNPPageArgs).get(0);
        Button newUserBtn = (Button)login.GUICode(uNPPageArgs).get(1);
        Button Backtologin = (Button)siteDisplay.GUICode(uNPPageArgs).get(3);
        Button editSiteBtn = (Button)GUIUNPP.GUICode(uNPPageArgs).get(1);
        Button goEdit = (Button)editSite.GUICode(uNPPageArgs).get(0);
        
        goEdit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                siteDisplay.show(primaryStage);
                System.out.println("go!");
            }
        });
        
        editSiteBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                editSite.show(primaryStage);
                System.out.println("go!");
            }
        });
        
        go.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                siteDisplay.show(primaryStage);
                System.out.println("go!");
            }
        });
        
        go2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                siteDisplay.show(primaryStage);
                System.out.println("go!");
            }
        });
        
        newUserBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                newUser.show(primaryStage);
                System.out.println("go!");
            }
        });
        
        Backtologin.setOnAction(new EventHandler<ActionEvent>(){
           
            @Override
            public void handle(ActionEvent event){
                login.show(primaryStage);
            }
        }); */ 
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
