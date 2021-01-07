/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Screen1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane rootPane1;
    @FXML
    private Button btn1;
    @FXML
    private void logout() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
          rootPane1.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
