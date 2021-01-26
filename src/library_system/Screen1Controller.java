/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gab
 */
//User 
public class Screen1Controller implements Initializable {

  
    @FXML
    private Label FullName;
    
    public void setName(String name)
    {
        FullName.setText(name);
    }
    
   

    @FXML
    public TextField Search;
    
    @FXML
    private Button SearchB;
    
    @FXML
    public Label Course;
    
    public void setCourse(String course)
    {
        Course.setText(course);
    }
    
    @FXML
    private AnchorPane rootPane1;
    
    @FXML
    private Button Logout;
    
    @FXML
    private Button Return_Book;
    
    @FXML
    private Button Issue_Book;
    
  
    
   @FXML
   private void Enter() 
    {

        Search_Book searchBook = new Search_Book();
        LinkedList<String> Books = new LinkedList<String>();
        KeyCombination Combination = new KeyCodeCombination(KeyCode.ENTER);
        Search.setOnKeyPressed((KeyEvent event) ->{
            if(Combination.match(event))
                {
                    File Book = new File("Book List");
                    File [] ListOfBook = Book.listFiles();
                    for(int i = 0; i<ListOfBook.length; i++)
                     {
                        Books.add(ListOfBook[i].getName());
                     }
                        searchBook.setBook(Search.getText()+".txt");
                        
                        if(Books.contains(searchBook.getBook()))
                       {
                            
                             ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
                                ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                                Alert dg = new Alert(Alert.AlertType.CONFIRMATION, Search.getText()+", is in the list of our library books, do you want to borrow it?", YES,NO );
                                Optional<ButtonType> result = dg.showAndWait();
                                if(result.get() == YES)
                                {
                                   if(result.get() == YES)
                                { 
                                       try {
                                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BorrowBook.fxml"));
                                           Parent root1 = (Parent) fxmlLoader.load();
                                           Stage stage = new Stage();
                                           stage.setScene(new Scene(root1));
                                           stage.show();
                                           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                       } catch (IOException ex) {
                                           Logger.getLogger(Screen1Controller.class.getName()).log(Level.SEVERE, null, ex);
                                       }
                                  
                                }
                                }
                      }
                        else if(Search.getText().isEmpty())
                           {
                                Alert AlertBox = new Alert(Alert.AlertType.ERROR , "You don't type Anything"); 
                                AlertBox.showAndWait();
                            }
                        else
                         {
                            Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, "Your search "+Search.getText()+", did not match in any books"); 
                            AlertBox.showAndWait();
                            Search.clear();
                           }
     
                }
           
        
        });
        
       
    }
    
   @FXML
   private void SearchButton(ActionEvent event) throws IOException
   {
       Search_Book searchBook = new Search_Book();
        LinkedList<String> Books = new LinkedList<String>();
         File Book = new File("Book List");
                    File [] ListOfBook = Book.listFiles();
                    for(int i = 0; i<ListOfBook.length; i++)
                     {
                        Books.add(ListOfBook[i].getName());
                     }
                        searchBook.setBook(Search.getText()+".txt");
                        
                        if(Books.contains(searchBook.getBook()))
                       {
                           
                            
                               ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
                                ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                                Alert dg = new Alert(Alert.AlertType.CONFIRMATION, Search.getText()+", is in the list of our library books, do you want to borrow it?", YES,NO );
                                Optional<ButtonType> result = dg.showAndWait();
                                if(result.get() == YES)
                                { 
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BorrowBook.fxml"));
                                    Parent root1 = (Parent) fxmlLoader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root1)); 
                                    stage.show();
                                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                  
                                }
                      }
                         else if(Search.getText().isEmpty())
                           {
                               
                             
                                Alert AlertBox = new Alert(Alert.AlertType.ERROR , "You don't type Anything"); 
                                AlertBox.showAndWait();
                                
                            }
                        else
                          {
                              Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, "Your search "+Search.getText()+", did not match in any books"); 
                              AlertBox.showAndWait();
                              Search.clear();
                        }
   }
   
    @FXML
    private void _Issue_Book() throws IOException
    {
      
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Issue_Book.fxml"));
           Parent root = loader.load();
           Issue_BookController student = loader.getController();
           student.setFullName(FullName.getText().toString());
           student.setICourse(Course.getText());
           Issue_Book.getScene().setRoot(root);
         
    }
            
    @FXML
    private void _Return_Book() throws IOException
    {
      
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Return_Book.fxml"));
           Parent root = loader.load();
           Return_BookController student = loader.getController();
           student.setRName(FullName.getText());
           student.setRCourse(Course.getText());
           Return_Book.getScene().setRoot(root);
    }
    
    @FXML
    private void _Logout() throws IOException
    {
       ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to logout", YES,NO );
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
            rootPane1.getChildren().setAll(pane);
       }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
}
