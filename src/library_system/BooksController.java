/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.awt.print.Book;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static library_system.Return_BookController.Books;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class BooksController implements Initializable {

   
     static  LinkedList<String> Books = new LinkedList<String>();
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView  <StackOfBook>tableBook;
   
    @FXML 
    private TableColumn <StackOfBook, String>Book_Name;
    
    
    
    @FXML 
    private Button Add_Book;
    
    @FXML 
    private Button Back;
    
    @FXML
    private Button btnLogout;
    
    @FXML
    private void _addBookForm(ActionEvent event) throws IOException
    {
    
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add_Book_Form.fxml"));
            Parent root1 = (Parent) fxmlLoader.load(); 
            Stage stage = new Stage();
            stage.setScene(new Scene(root1)); 
            stage.show();
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       
            
    }
    
    @FXML
    private void Back() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
       rootPane.getChildren().setAll(pane);
    }
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      Book_Name.setCellValueFactory(new PropertyValueFactory<> ("BookName"));
        
         try {
             tableBook.setItems(getBooks());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
  
     public ObservableList<StackOfBook> getBooks() throws FileNotFoundException
   
    {
        
          LinkedList<String> Books = new LinkedList<String>();
       File folder = new File("Book List");
       File [] ListOfBook = folder.listFiles();
       ObservableList<StackOfBook> observableList = FXCollections.observableArrayList();
       for(int i = 0; i<ListOfBook.length; i++)
       {
           Books.add(ListOfBook[i].getName());
       }  
      
      
       for(int j = 0; j<Books.size();j++)
           {
               
            observableList.addAll(new StackOfBook(Books.get(j).substring(0, Books.get(j).lastIndexOf("."))));
          
            
           }
        
                 return observableList;   
          
          
          

       
    
    }
  
    
            
    
}
