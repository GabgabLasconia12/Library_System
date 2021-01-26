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


public class Issue_BookController implements Initializable 
{
    
    
    @FXML 
    private TableView <Issue_Books>IssueTable;
    
    @FXML
    private TableColumn <Issue_Books, String> BookName;
    
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
           LinkedList<String> StudentsLog = new LinkedList<String>();
           File folderLog = new File("Students loggedIn");
            File [] ListOfStLog = folderLog.listFiles();
            for(int k = 0; k<ListOfStLog.length; k++)
              {
            StudentsLog.add(ListOfStLog[k].getName());
            }
           // System.out.println(StudentsLog.get(0));
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
        
        try {
            BookName.setCellValueFactory(new PropertyValueFactory<> ("BOOKNAME"));
            IssueTable.setItems(getBooks());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Issue_BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }    
      public ObservableList<Issue_Books> getBooks() throws FileNotFoundException
   
    {
       Student_Fullname name = new Student_Fullname();
       //name.setFullname(FullIName.getText());
      // System.out.println(FullIName.getText());
         LinkedList<String> StudentsLog = new LinkedList<String>();
           LinkedList<String> Students = new LinkedList<String>();
       File folder = new File("Borrowed books");
       File folderLog = new File("Students loggedIn");
       File [] ListOfStLog = folderLog.listFiles();
       File [] ListOfSt = folder.listFiles();
       ObservableList<Issue_Books> observableList = FXCollections.observableArrayList();
       for(int i = 0; i<ListOfSt.length; i++)
       {
           
           Students.add(ListOfSt[i].getName());
         
       } 
       for(int k = 0; k<ListOfStLog.length; k++)
       {
           StudentsLog.add(ListOfStLog[k].getName());
       }
       
      
         //System.out.println(StudentsLog);
       if(Students.contains(StudentsLog.get(0)))
       {
           File BookInfo = new File("/Users/Gab/Desktop/try/Library_System/Borrowed Books/"+StudentsLog.get(0));
           Scanner Reader = new Scanner(BookInfo);
           String []  Book = Reader.next().split("-");
          
              observableList.addAll(new Issue_Books(Book[0]));
          
       }
           //observableList.addAll(new Issue_Books("sadasd"));
      
     
      
                 return observableList;   
         
    }
    
}
