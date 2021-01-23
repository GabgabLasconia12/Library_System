/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;               
import javafx.fxml.Initializable;
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
    private TextField Search;
    
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
        //linkedlist
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
                            Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, Search.getText()+", is in the list of our library books"); 
                            AlertBox.showAndWait();
                            Search.clear();
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
   private void SearchButton()
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
                            Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, Search.getText()+", is in the list of our library books"); 
                            AlertBox.showAndWait();
                            Search.clear();
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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Issue_Book.fxml"));
          rootPane1.getChildren().setAll(pane);
    }
            
    @FXML
    private void _Return_Book() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Return_Book.fxml"));
          rootPane1.getChildren().setAll(pane);
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
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootPane1.getChildren().setAll(pane);
       }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
 
    }    
    
}
