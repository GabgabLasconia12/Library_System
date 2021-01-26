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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static library_system.Return_BookController.Books;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class View_issuedBookController extends BookData implements Initializable {

   
    
    @FXML
    private TableView <Book_Issued>ViewIssuedBook;
     @FXML
    private TableColumn<Book_Issued, String> Book_Name;
    
    @FXML
    private TableColumn <Book_Issued, String> StudentName;
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button ReturnBook;
    
    @FXML
    private Button btnLogout;
   
    @FXML
    private void ReturnBook()
    {
        
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
    
    @FXML
    private void Back() throws IOException
    {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        Book_Name.setCellValueFactory(new PropertyValueFactory<>("BookName_"));
        StudentName.setCellValueFactory(new PropertyValueFactory<> ("Name_"));
          ViewIssuedBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        try {
            ViewIssuedBook.setItems(getBooks());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View_issuedBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
     public ObservableList<Book_Issued> getBooks() throws FileNotFoundException
   
    {
         LinkedList<String> Books = new LinkedList<String>();
       File folder = new File("Borrowed_books");
       File [] ListOfBook = folder.listFiles();
       ObservableList<Book_Issued> observableList = FXCollections.observableArrayList();
       for(int i = 0; i<ListOfBook.length; i++)
       {
           Books.add(ListOfBook[i].getName());
       } 
       
      for(int k = 0; k<Books.size(); k++)
      {
           File BookInfo = new File("Borrowed_books//"+Books.get(k));
           Scanner Reader = new Scanner(BookInfo);
           String []  Book = Reader.nextLine().split("-");
           
               String NAme = Books.get(k).substring(0, Books.get(k).lastIndexOf("."));
               Reader.close();
               observableList.addAll(new Book_Issued(Book[0], NAme));
           
         
      }
     
         
                 return observableList;   
         
    }
    @FXML
     public void ReturnButton()
     {

       
        ObservableList<Book_Issued> selectedRows, AllBooks;
     
        
           
             ObservableList<Book_Issued> Books;
             Books = ViewIssuedBook.getSelectionModel().getSelectedItems();
             String Data= Books.get(0).getName_()+".txt";
    
             
         AllBooks = ViewIssuedBook.getItems();
         
         selectedRows = ViewIssuedBook.getSelectionModel().getSelectedItems();
         
         
         
         for(Book_Issued BookI: selectedRows)
         {
             
             AllBooks.remove(BookI);
         }
         
         
          LinkedList<String> BookTitle = new LinkedList<String>();
         File folder = new File("Borrowed_books");
         File [] ListOfBook = folder.listFiles();
         
         
      String FileTodelete = "";
         for(int i = 0; i<ListOfBook.length; i++)
          {
           BookTitle.add(ListOfBook[i].getName());
           if(Data.equalsIgnoreCase(ListOfBook[i].getName()))
           {
               FileTodelete = ListOfBook[i].getAbsolutePath();
           }
          } 
         if(BookTitle.contains(Data))
         {
           
             try
             {
                  Files.deleteIfExists(Paths.get("Borrowed_books//"+Data));
                Path path = Paths.get("FileTodelete");
                Files.delete(path);
                 
             }
             catch(Exception e)
             {
                e.printStackTrace();
             }
                
         }
         
       
  
     }
    
    
}
