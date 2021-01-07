/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

/**
 *
 * @author Gab
 */
public class FXMLDocumentController implements Initializable {

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
       // Screen1Controller scc = new Screen1Controller();
        String id = "2000123";
        String pass = "try123";
        String name = "Ira";
            
        
       if(Id.getText().equals(id) && Password.getText().equals(pass))
        {
            System.out.println("login complete");
           AnchorPane pane = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
          rootPane.getChildren().setAll(pane);
             
         
            
        }
        else
        {
            System.out.println("Invalid");
             Alert dg = new Alert(Alert.AlertType.ERROR, "Wrong password or Id Number");
        
         Optional<ButtonType> result = dg.showAndWait();
        }
       
       
    }
    
}
