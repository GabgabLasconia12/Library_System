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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Admin_LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button Admin_loginButton;
    
    @FXML
    private Button Back;
    
    @FXML
    private TextField Admin_Password;
    
    @FXML
    private void Admin_Login() throws IOException
    {
        String Pass_admin = "Admin123";
        
        if(Admin_Password.getText().equals(Pass_admin))
        {
            System.out.println("Correct");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        else
        {
            System.out.println("Invalid");
             Alert dg = new Alert(Alert.AlertType.ERROR, "Wrong password");
        
         Optional<ButtonType> result = dg.showAndWait();
        }
    }
    
    @FXML
    private void Back() throws IOException
    {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
