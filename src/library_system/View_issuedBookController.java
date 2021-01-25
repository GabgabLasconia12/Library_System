/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static library_system.Return_BookController.Books;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class View_issuedBookController implements Initializable {

    @FXML
    private TableColumn<Issued_Book, String> Book_Name;
    
    @FXML
    private TableColumn <Issued_Book, String> StudentName;
    
    @FXML
    private TableView <Issued_Book>ViewIssuedBook;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnLogout;
   
    @FXML
    private void Logout() throws IOException
    {
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
    private void Back() throws IOException
    {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            Book_Name.setCellValueFactory(new PropertyValueFactory<> ("_BookName"));
            StudentName.setCellValueFactory(new PropertyValueFactory<> ("StudentName"));
        try {
            ViewIssuedBook.setItems(getBook());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View_issuedBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public ObservableList<Issued_Book> getBook() throws FileNotFoundException
   
    {
        
   ObservableList<Issued_Book> observableList = FXCollections.observableArrayList();
   observableList.add(new Issued_Book("das", "dasdas"));
   return observableList;
    }
    
}
