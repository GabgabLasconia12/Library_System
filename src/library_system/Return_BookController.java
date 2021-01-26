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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Return_BookController  implements Initializable 
{
  public static LinkedList<String> Books = new LinkedList<String> ();
 
    
  
    @FXML
    private Button back;
    
    @FXML
    private TableView <ReturnBook>tableView;
    
    @FXML
    private TableColumn <ReturnBook, String>BookName;
    
    @FXML
    private TableColumn <ReturnBook, String> DateToReturn;
    
    @FXML
    private Label FullName;
    public void setRName(String name)
    {
        FullName.setText(name);
    }
    @FXML
   private Label Name;
    
    
    @FXML
    private Label Course;
    public void setRCourse(String _Course)
    {
        Course.setText(_Course);
    }
    @FXML
    private Button Logout;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button Issue_Book;
    
    @FXML
    private void _Issue_Book() throws IOException
    {
       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Issue_Book.fxml"));
           Parent root = loader.load();
           Issue_BookController student = loader.getController();
           student.setFullName(FullName.getText());
           student.setICourse(Course.getText());
           Issue_Book.getScene().setRoot(root);
    }
    
    @FXML
    private void _Back() throws IOException
    {
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1.fxml"));
           Parent root = loader.load();
           Screen1Controller student = loader.getController();
           student.setName(FullName.getText());
           student.setCourse(Course.getText());
           back.getScene().setRoot(root);
          
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
           LinkedList<String> StudentsLog = new LinkedList<String>();
           File folderLog = new File("Students loggedIn");
            File [] ListOfStLog = folderLog.listFiles();
            for(int k = 0; k<ListOfStLog.length; k++)
              {
            StudentsLog.add(ListOfStLog[k].getName());
            }
         
          File Todelte = new File("/Users/Gab/Desktop/try/Library_System/Students loggedIn/"+StudentsLog.get(0));
               Todelte.delete();
         System.out.println(StudentsLog);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootPane.getChildren().setAll(pane);
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       

            BookName.setCellValueFactory(new PropertyValueFactory<> ("Book_Name"));
            DateToReturn.setCellValueFactory(new PropertyValueFactory<>("TimeToReturn"));
          
       
      try {
          tableView.setItems(getBook());
          
          
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Return_BookController.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    
        }

    
            
 
   
    public ObservableList<ReturnBook> getBook() throws FileNotFoundException
   
    {
      LinkedList<String> StudentsLog = new LinkedList<String>();
      LinkedList<String> Students = new LinkedList<String>();
       File folder = new File("Borrowed_books");
       File folderLog = new File("Students loggedIn");
       File [] ListOfStLog = folderLog.listFiles();
       File [] ListOfSt = folder.listFiles();
       ObservableList<ReturnBook> observableList = FXCollections.observableArrayList();
       for(int i = 0; i<ListOfSt.length; i++)
       {
           
           Students.add(ListOfSt[i].getName());
         
       } 
       for(int k = 0; k<ListOfStLog.length; k++)
       {
           StudentsLog.add(ListOfStLog[k].getName());
       }
       
      
    
       if(Students.contains(StudentsLog.get(0)))
       {
           
           File BookInfo = new File("Borrowed_books//"+StudentsLog.get(0));
           Scanner Reader = new Scanner(BookInfo);
           String []  Book = Reader.nextLine().split("-");
          
              observableList.addAll(new ReturnBook(Book[0], "14 days to returned"));
          
       }
      return observableList;
    
    }
    
}
