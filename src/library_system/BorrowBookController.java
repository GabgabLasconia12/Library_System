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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class BorrowBookController   implements Initializable
{

    @FXML
    private TextField BTitle;
    @FXML
    private TextField StudentId;
    @FXML
    private TextField Name;
   
    @FXML
    private Button Cancel;
    
    @FXML
    private Button Borrow;
    
    @FXML
    private void Borrow() throws IOException
    {
     
     Borrow_Book_Function Function = new Borrow_Book_Function();
      LinkedList<String> BookBorrow = new  LinkedList();
      
      Function.setBookT(BTitle.getText());
      Function.setStudentId(StudentId.getText());
      Function.setName(Name.getText());
      
      BookBorrow.add(Function.getBookT());
      BookBorrow.add(Function.getName());
      BookBorrow.add(Function.getStudentId());
      
      if(BTitle.getText().isEmpty() &&StudentId.getText().isEmpty()&& Name.getText().isEmpty())
      {
          Alert dg = new Alert(Alert.AlertType.ERROR, "All fields are require" );
        Optional<ButtonType> result = dg.showAndWait();
      }
      else
      {
              File file = new File("Borrowed_books");
             File [] ListOfBook = file.listFiles();
             LinkedList<String> Books = new LinkedList<String>();
             String check =Function.getName().substring(0, Function.getName().lastIndexOf(","))+".txt";
            
              for(int i = 0; i<ListOfBook.length; i++)
                {
                    Books.add(ListOfBook[i].getName());
                }  
              if(Books.contains(check))
              {
                      Alert dg = new Alert(Alert.AlertType.INFORMATION, "You reach your limit" );
                     Optional<ButtonType> result = dg.showAndWait();
              }
            
              else
              {
               file.mkdir();
                  try (FileWriter writer = new FileWriter("Borrowed_books/"+Function.getName().substring(0, Function.getName().lastIndexOf(","))+".txt")) {
                      for (String Bookinfo : BookBorrow) 
                      {
                          writer.write(Bookinfo+"-");
                      }
                      writer.close();
                     Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, "You can now get the book to the librain!"); 
                   AlertBox.showAndWait();
                   BTitle.clear();
                   StudentId.clear();
                   Name.clear();
                  }
              }
      
      }
  
    }
    
    
    @FXML
    public void Cancel()
    {
        ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to Cancel?", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
          Stage stage = (Stage) Cancel.getScene().getWindow();
          stage.close();
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    
    
}
