/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Gab
 */
public class Student_RegisterController implements Initializable 
{
    


    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button Register;
    
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField middleName;
        
    @FXML
    private TextField studentId;
    
    @FXML
    private TextField Course;
    
    @FXML
    private PasswordField Password;
    
   @FXML
   private Button Cancel;

   @FXML private void Register()
   {
        Register_Function student = new Register_Function();
        student.setFirstName(firstName.getText());
        student.setLastName(lastName.getText());
        student.setMiddleName(middleName.getText());
        student.setStudentId(Integer.parseInt(studentId.getText()));
        student.setPassword(Password.getText());
        student.setCourse(Course.getText());
        System.out.println(student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName());
        System.out.println("Password "+student.getPassword());
        System.out.println("Course "+student.getCourse());
        System.out.println("Student Id "+student.getStudentId());
   }
   
    @FXML
    private void cancelRegister() throws IOException
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
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
        // TODO
    }    
    
}
