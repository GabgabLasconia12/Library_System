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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gab
 */
//USER  
public class Screen1Controller implements Initializable {

   
    @FXML
    private AnchorPane rootPane1;
    
    @FXML
    private Button Logout;
    
    @FXML
    private Button Return_Book;
    
    @FXML
    private Button Issue_Book;
    
    @FXML
    private void _Issue_Book() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Issue_Book.fxml"));
          rootPane1.getChildren().setAll(pane);
    }
            
    @FXML
    private void _Return_Book() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Return_Book.fxml"));
          rootPane1.getChildren().setAll(pane);
    }
    
    @FXML
    private void _Logout() throws IOException
    {
        ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to logout", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootPane1.getChildren().setAll(pane);
       }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
