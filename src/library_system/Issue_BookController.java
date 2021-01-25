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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class Issue_BookController implements Initializable 
{
    
   @FXML
   private Label FullIName;
   public void setFullName(String _NAme)
   {
       FullIName.setText(_NAme);
   }
    @FXML
   private Label Course;
   public void setICourse(String _Course)
   {
       Course.setText(_Course);
   }
    
   @FXML
   private AnchorPane rootPane; 

   @FXML
   private Button Back;
   
   @FXML
   private Button Logout;
   
   @FXML
   private Button Return_Book;
   
   @FXML
   private void _Return_Book() throws IOException
   {
      // AnchorPane pane = FXMLLoader.load(getClass().getResource("Return_Book.fxml"));
            //rootPane.getChildren().setAll(pane);
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Return_Book.fxml"));
           Parent root = loader.load();
           Return_BookController student = loader.getController();
           student.setRName(FullIName.getText());
           student.setRCourse(Course.getText());
           Return_Book.getScene().setRoot(root);
            
   }
    
   @FXML
   private void _Back() throws IOException
   {
      // AnchorPane pane = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
           // rootPane.getChildren().setAll(pane);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1.fxml"));
           Parent root = loader.load();
           Screen1Controller student = loader.getController();
           student.setName(FullIName.getText());
           student.setCourse(Course.getText());
           Back.getScene().setRoot(root);
   }
   
   @FXML
   private void _Logout() throws IOException
   {
          ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to logout?", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootPane.getChildren().setAll(pane);
       }
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
