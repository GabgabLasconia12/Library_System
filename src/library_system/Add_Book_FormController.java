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
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Add_Book_FormController implements Initializable {

  

 

    @FXML
    private Button btnAdd_Book;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private TextField BookName;
    @FXML
    private TextField BookDescription;
    @FXML
    private TextField BookTitle;
    @FXML
    private TextField BookAuthor;
    @FXML
    private TextField BookPage;
    
    @FXML
    private ComboBox BookCategory;
    
    @FXML
    private void Awit()
    {
        System.out.print("Awit");
    }
    
    @FXML
    public void AddBook() throws IOException
    {
        ArrayList <String> BookInfo;
        BookInfo = new ArrayList();
        
        Add_Book_Function AddBook = new Add_Book_Function();
        
        
        
        AddBook.setBookName(BookName.getText());
         AddBook.setBookCategory((String) BookCategory.getValue());
        AddBook.setBookDescription(BookDescription.getText());
        AddBook.setBookTitle(BookTitle.getText());
        AddBook.setBookAuthor(BookAuthor.getText());
        AddBook.setBookPage(BookPage.getText());
      
        BookInfo.add(AddBook.getBookName());
       BookInfo.add(AddBook.getBookCategory());
        BookInfo.add(AddBook.getBookDescription());
        BookInfo.add(AddBook.getBookTitle());
        BookInfo.add(AddBook.getBookAuthor());
        BookInfo.add(AddBook.getBookPage());
        
        if(BookName.getText().isEmpty() && BookCategory.getValue()== null && BookDescription.getText().isEmpty() && BookTitle.getText().isEmpty()
                && BookAuthor.getText().isEmpty() && BookPage.getText().isEmpty())
        {
            Alert dg = new Alert(Alert.AlertType.ERROR, "all field are required");
            dg.showAndWait();
        }
        else
        {
        File Books = new File("Book List");
        Books.mkdir();
        FileWriter wr = new FileWriter("Book List/"+AddBook.getBookTitle()+".txt");
        for(String books : BookInfo)
        {
            wr.write(books+"-");
        }
            wr.close();
      
        }
        BookName.clear();
        BookPage.clear();
        BookTitle.clear();
        BookAuthor.clear();
        BookDescription.clear();
        BookCategory.valueProperty().set(null);
        Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, "Book added succesfully!"); 
        AlertBox.showAndWait();
     
       
        
       
        
    }
    
    
    @FXML
    private void Cancel()
    {
        ButtonType YES = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
       ButtonType NO = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
       Alert dg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to Cancel?", YES,NO );
       Optional<ButtonType> result = dg.showAndWait();
       if(result.get()== YES)
       {
          Stage stage = (Stage) btnCancel.getScene().getWindow();
          stage.close();
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
          ObservableList <String> BookCategories = FXCollections.observableArrayList("Fiction", "non-fiction",
                  "Fantasy", "History", "Educational");
          BookCategory.setItems(BookCategories);
          
          
    }    
    
}
