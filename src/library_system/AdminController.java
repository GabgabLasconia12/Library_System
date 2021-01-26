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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class AdminController implements Initializable {

   @FXML
   private Button Books_button;
  
   @FXML
   private Button Button_Register;
   
   @FXML
   private Button View_IssuedBook;
   
   @FXML
   private Button Logout;
   
   @FXML
   private AnchorPane rootPane;
   
   @FXML
   private void Admin_logout() throws IOException
   {
       System.out.println("Logout");
       ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to logout", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootPane.getChildren().setAll(pane);
       }
      
       
   }
   
   @FXML
   private void book() throws IOException
   {
      AnchorPane pane = FXMLLoader.load(getClass().getResource("Books.fxml"));
       rootPane.getChildren().setAll(pane);
       
   }
   
   @FXML
   private void studentRegisterform(ActionEvent event) throws IOException
   {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student_Register.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1)); 
            stage.show();
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
   }
   
   @FXML
   private void viewIssuedBook() throws IOException
   {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("View_issuedBook.fxml"));
       rootPane.getChildren().setAll(pane);
   }
   

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
