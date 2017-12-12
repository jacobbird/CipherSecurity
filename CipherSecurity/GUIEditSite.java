/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.CipherSecurity;

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
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class GUIEditSite implements IGUIClass
{
    StackPane entryPane;
    Scene scene;
    Text title;
    
    Label entryUNLabel = new Label("User Name: ");
    TextField entryUserName = new TextField();
    Label entryPWLabel = new Label("Password: ");
    PasswordField entryPassword = new PasswordField();
    //Label entryPWLabel2 = new Label("Password: ");
    Label entryPWLabel2 = new Label("Other Info: ");
    PasswordField entryPassword2 = new PasswordField();
    //Button go = new Button("go!");
    Button go = new Button("Set");
    public GUIEditSite(){
        entryPane = new StackPane();
        scene = new Scene(entryPane, 400, 500);
        title = new Text();
    
    }
    @Override
    public ArrayList<Object> GUICode(Object[] args) {
        
        ArrayList<Object> pressables = new ArrayList<Object>();
        String font = "Times New Roman";
        
        // Banner Pane
        BorderPane settingsOpenPane = new BorderPane();
       
        
        // Banner
        Label windowLabel = new Label();
        windowLabel.setText("Edit");

        Font lblFont = new Font(font, 32.00);
        windowLabel.setFont(lblFont);
        
        windowLabel.setTextFill(Color.WHITE);
        settingsOpenPane.setLeft(windowLabel);
        settingsOpenPane.setBackground(new Background(new BackgroundFill(
                Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        settingsOpenPane.setPadding(new Insets(10, 10, 10, 10));
        
        
        
        
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
        
        // Set Banner
        
        UserNamePassword siteUNP = (UserNamePassword)args[0];
        String siteName = siteUNP.getSiteName();
        
        title.setText("");
        title.setText(siteName);
        title.setFont(new Font(font, 24));
       
        entryHBoxTitle.getChildren().add(title);
        
        
        entryHBox.getChildren().addAll(entryVBox2, entryVBox3);
        entryHBox2.getChildren().addAll(entryVBox4, entryVBox5);
        entryHBox3.getChildren().addAll(entryVBox6, entryVBox7);
        entryBox.getChildren().addAll(entryHBoxTitle, entryHBox, entryHBox2, entryHBox3, entryHBox4);
        entryPane.getChildren().add(entryBox);

        entryUNLabel.setMinWidth(70);
        entryVBox2.getChildren().add(entryUNLabel);
        entryVBox2.setAlignment(Pos.CENTER_RIGHT);
        
        
        entryVBox3.getChildren().add(entryUserName);
        
    
        entryPWLabel.setMinWidth(70);
        entryVBox4.getChildren().add(entryPWLabel);
        entryVBox4.setAlignment(Pos.CENTER_RIGHT);
        
        
        entryVBox5.getChildren().add(entryPassword);
        
        
        entryPWLabel.setMinWidth(70);
        entryVBox6.getChildren().add(entryPWLabel2);
        entryVBox6.setAlignment(Pos.CENTER_RIGHT);
        
        
        entryVBox7.getChildren().add(entryPassword2);
        
        
        entryHBox4.getChildren().add(go);
        
        go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
                @Override
                public void handle(MouseEvent event) {
                    siteUNP.setUserName(entryUserName.getText());
                    siteUNP.setPassword(entryPassword.getText());
                    GUISitePage.editList(siteUNP, siteName);
                    GUISitePage sitePage = (GUISitePage)args[3];
                    sitePage.GUICode(args);
                    sitePage.show((Stage)args[1]);
                    
                    

                    }
            });
        
        
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
        
        BackgroundImage myBI= new BackgroundImage(new javafx.scene.image.Image(getClass().getResource("Background.jpg").toExternalForm()),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
        
        
        entryPane.setStyle("-fx-background-color: lightblue");
        
        // Other color
        // #f0f8ff
        // lightblue
        
        // BG as Image
        //entryPane.setBackground(new Background(myBI));
        
        
        
        return pressables;
        
    }

    @Override
    public void show(Stage s) {
        //s.setTitle("Cipher Security: Password Saver");
        s.setTitle("PassSafe: Password Saver (Edit Site)");
        s.setScene(scene);
        s.show();
    }
    
}
