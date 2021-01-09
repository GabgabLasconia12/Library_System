/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Add_Book_FormController implements Initializable {

  
    //tang ina mo
    @FXML
    private Button btnAdd_Book;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private ComboBox Category;
    
    @FXML
    private void Awit()
    {
        System.out.print("Awit");
    }

    
    @FXML
    private void Cancel()
    {
        ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to Cancel?", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
          Stage stage = (Stage) btnCancel.getScene().getWindow();
          stage.close();
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
          ObservableList<String> BookCategories = FXCollections.observableArrayList("Fiction", "non-fiction",
                  "Fantasy", "History", "Educational");
          Category.setItems(BookCategories);
          
          
    }    
    
}
