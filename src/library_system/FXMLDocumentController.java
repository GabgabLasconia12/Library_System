  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Gab
 */
// Login
public class FXMLDocumentController implements Initializable {

    public String []  Student;
   
   @FXML
   public TextField Id;
   @FXML
   public PasswordField Password;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
     Button btn;
   
    @FXML
    //alt+A
    private void ShorcutToAdmin() 
    {
        KeyCombination Combination = new KeyCodeCombination(KeyCode.A, KeyCodeCombination.ALT_DOWN);
        rootPane.setOnKeyPressed(event ->{
            if(Combination.match(event))
                {
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
                    rootPane.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        
        });
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException 
    {
      
      
        try 
        {
            
            File read = new File("Students Account//"+Id.getText()+".txt");
            Scanner Reader = new Scanner(read);
            Student = Reader.nextLine().split("-");
            Student_Fullname st = new Student_Fullname();
             
            
                   
               if(Id.getText().equals(Student[0]))
        {
         
             File file = new File("Students loggedIn");
             file.mkdir();
             FileWriter wf = new FileWriter("Students loggedIn/"+Student[3]+".txt");
             wf.write(Student[3]+", "+Student[2]);
             wf.close();
          System.out.println("login complete");
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1.fxml"));
           Parent root = loader.load();
           Screen1Controller student = loader.getController();
           student.setName(Student[3]+", "+Student[2]);
           student.setCourse(Student[1]);
           btn.getScene().setRoot(root);
           
           
             
        }
            
        }
        catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
       System.out.println("Invalid");
             Alert dg = new Alert(Alert.AlertType.ERROR, "Wrong password or Id Number");
        
         Optional<ButtonType> result = dg.showAndWait();
        }
    
          
    
}
}