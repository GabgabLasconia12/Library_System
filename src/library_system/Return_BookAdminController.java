/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Return_BookAdminController implements Initializable
{

    @FXML
    private Button Return;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private TextField BookTitle;
    
    @FXML
    private TextField StudentId;
    
    @FXML
    private TextField Name;
    
   @FXML
   public void returnBook()
   {
       
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
