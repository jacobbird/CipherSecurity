/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.CipherSecurity;

import CipherSecurity.Methods.RSA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
public class GUISitePage implements IGUIClass {

    BorderPane borderRoot;
    Scene scene;
    public static List<UserNamePassword> siteList = new ArrayList<UserNamePassword>();
    public static FileContentConverter testContent = null;

    public GUISitePage() {
        borderRoot = new BorderPane();
        scene = new Scene(borderRoot, 400, 500);
    }

    @Override
    public final ArrayList<Object> GUICode(Object[] args) {
        ArrayList<Object> pressables = new ArrayList<Object>();

        // Find out the Username System
        System.out.println("Incoming Profile Username(from Login/Textfield): " + args[0]);

        Label label = new Label();
        //label.setText("Cipher Security");
        label.setText("Stored Sites");
        String font = "Times New Roman";

        Button editBtn = new Button();
        editBtn.setText("Edit");
        editBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                System.out.println("Edit");
            }
        });

        Button newBtn = new Button();
        newBtn.setText("New");
        newBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Outgoing Profile Username (to New Site): " + args[0]);

                GUINewSite GUINSPage = (GUINewSite) args[7];
                GUINSPage.GUICode(args);
                GUINSPage.show((Stage) args[1]);

                System.out.println("New");
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

        //borderRoot.setCenter(resultsPane);
        borderRoot.setCenter(siteVBox);
        //borderRoot.setLeft(siteScrPane);
        borderRoot.setTop(settingsOpenPane);
        borderRoot.setBottom(editNew);
        borderRoot.setPadding(new Insets(0, 10, 0, 10));

        // Top Blue Section
        Font lblFont = new Font(font, 32.00);
        label.setFont(lblFont);

        label.setTextFill(Color.WHITE);
        settingsOpenPane.setLeft(label);
        settingsOpenPane.setBackground(new Background(new BackgroundFill(
                Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        //settingsOpenPane.setRight(settingsBtn);
        settingsOpenPane.setPadding(new Insets(10, 10, 10, 10));

        // END TOP PANE
        editNew.setRight(editNewHor);
        //editNewHor.getChildren().add(editBtn);

        Button backBtn = new Button();
        backBtn.setText("Back");

        backBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                GUILogin editPage = (GUILogin) args[4];
                editPage.GUICode(args);
                editPage.show((Stage) args[1]);
            }
        });

        editNewHor.getChildren().add(backBtn);
        editNewHor.getChildren().add(newBtn);

        editNewHor.setPadding(new Insets(10, 10, 10, 10));
        editNewHor.setSpacing(10.00);

        siteVBox.setPadding(new Insets(10, 10, 10, 10));

        //siteScrPane.setContent(siteVBox);
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

        Text passwordText = new Text("");   // Additional Information
        passwordText.setFont(Font.font(font, FontWeight.BOLD, 20));
        resultsPane.add(passwordText, 2, 1);

        // Site Load and Display
        try {
            testContent = new FileContentConverter("testFile");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUISitePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        //------------------------------------------------------------------------------------------------------------------------------------------
        siteList = testContent.getSites();
        Iterator siteListIter = siteList.iterator();

        pressables.add(siteVBox);
        pressables.add(newBtn);
        pressables.add(siteList);
        pressables.add(backBtn);

        List<Text> siteTxts = new ArrayList<Text>();

        int i = 0;
        while (siteListIter.hasNext()) {
            Text siteTxt = new Text();

            // usrNamePass is iterator through Converted File
            UserNamePassword usrNamePass = (UserNamePassword) siteListIter.next();
            // New
            siteTxt.setFont(new Font(font, 24.00));
            //siteTxt.setFill(Color.STEELBLUE);       // Font Color
            // End New
            siteTxt.setText(usrNamePass.getSiteName());

            siteTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("Outgoing Profile Username (to SiteData pre-FileIterator): " + args[0]);

                    args[0] = usrNamePass;    // Setting args[0] to Converted File Iterator
                    System.out.println("Outgoing Profile Username (to SiteData post-FileIterator): " + usrNamePass);

                    GUIUnamePassPage GUPPage = (GUIUnamePassPage) args[2];
                    GUPPage.GUICode(args);
                    GUPPage.show((Stage) args[1]);
                }
            });

            siteTxts.add(siteTxt);

            siteVBox.getChildren().add(siteTxts.get(i));

            i++;
        }

        BackgroundImage myBI = new BackgroundImage(new javafx.scene.image.Image(getClass().getResource("Background.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        borderRoot.setStyle("-fx-background-color: white");

        // Other Colors
        // #f0f8ff          Super Light Blue
        // lightblue
        // #fffff0          Ivory
        // #ffefd5          Beige-ish
        // #fff5ee          Seashell (Light, light, brown)
        // #fffaf0          More brown white
        // #fffaf0          Floral White (Good)
        // Set BG to Image
        //borderRoot.setBackground(new Background(myBI));
        //Button[] btnArr = (Button[])siteBtns.toArray();
        return pressables;
    }

    public static void editList(UserNamePassword yes, String sitename) throws IOException {
        //RSA dec = new RSA();
        String path = "./" + GUILogin.getUserNameString() + ".txt";
        File file = new File(path);
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write((""));
        writer.close();
        for (UserNamePassword current : siteList) {
            if (current.getSiteName().equals(sitename)) {
                current.setUserName(yes.getUserName());
                current.setPassword(yes.getPassword());
            }

            try {

                writer = new BufferedWriter(new FileWriter(file, true));

                String sName = (GUILogin.dec.convert(current.getSiteName(), 'e'));
                String uName = (GUILogin.dec.convert(current.getUserName(), 'e'));
                String pWord = (GUILogin.dec.convert(current.getPassword(), 'e'));

                writer.write(String.format("%s,%s,%s", sName, uName, pWord));
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                System.out.println("Can't write, too full");
            }

        }

    }
public static void deleteThis(UserNamePassword yes, String sitename) throws IOException {
        //RSA dec = new RSA();
        String path = "./" + GUILogin.getUserNameString() + ".txt";
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write((""));
        writer.close();
        for (UserNamePassword current : siteList) {
            if (current.getSiteName().equals(sitename)) {
                current.setSiteName("");
                current.setUserName("");
                current.setPassword("");
            }

            try {

                writer = new BufferedWriter(new FileWriter(file, true));

                String sName = (GUILogin.dec.convert(current.getSiteName(), 'e'));
                String uName = (GUILogin.dec.convert(current.getUserName(), 'e'));
                String pWord = (GUILogin.dec.convert(current.getPassword(), 'e'));

                if (!(current.getSiteName().equals(""))) {
                writer.write(String.format("%s,%s,%s", sName, uName, pWord));
                writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Can't write, too full");
            }

        }

    }

public static void addNew(UserNamePassword yes) throws IOException {
        //RSA dec = new RSA();
        String path = "./" + GUILogin.getUserNameString() + ".txt";
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write((""));
        writer.close();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        siteList.add(yes);
        System.out.println(yes.getSiteName());
        for (UserNamePassword current : siteList) {
            try {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                writer = new BufferedWriter(new FileWriter(file, true));

                String sName = (GUILogin.dec.convert(current.getSiteName(), 'e'));
                String uName = (GUILogin.dec.convert(current.getUserName(), 'e'));
                String pWord = (GUILogin.dec.convert(current.getPassword(), 'e'));

                if (!(current.getSiteName().equals(""))) {
                writer.write(String.format("%s,%s,%s", sName, uName, pWord));
                writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Can't write, too full");
            }

        }

    }

    @Override
    public final void show(Stage s) {
        //s.setTitle("Cipher Security: Password Saver");
        s.setTitle("PassSafe: Password Saver");
        s.setScene(scene);
        s.show();

    }
}
