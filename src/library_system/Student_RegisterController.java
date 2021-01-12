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
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
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
   private Button Cancel;

   @FXML private void Register() throws IOException
   {
        Register_Login_Function student = new Register_Login_Function();
        ArrayList <String> Info;
        Info = new ArrayList();
       
        
        
        student.setFirstName(firstName.getText());
        student.setLastName(lastName.getText());
        student.setMiddleName(middleName.getText());
        student.setStudentId(studentId.getText());
        student.setCourse(Course.getText());
           
        if(firstName.getText().isEmpty() && lastName.getText().isEmpty() && middleName.getText().isEmpty() && studentId.getText().isEmpty()
                &&  Course.getText().isEmpty() )
        {
            Alert dg = new Alert(Alert.AlertType.ERROR, "all field are required");
            dg.showAndWait();
        }
        else
        {
        Info.add(student.getFirstName());
        Info.add(student.getLastName());
        Info.add(student.getMiddleName());
        Info.add(student.getStudentId());
        Info.add(student.getPassword());
        Info.add(student.getCourse());
        student.StudentIdCollection.add(studentId.getText());
        
        File file = new File("Students Account");
        file.mkdir();
        File StudentidCollec = new File("Students_Id");
        StudentidCollec.mkdir();
        FileWriter wf = new FileWriter("Students_Id/"+student.getStudentId()+".txt");
        for(String idcollection : student.StudentIdCollection)
        {
            wf.write(idcollection);
        }
        wf.close();
        FileWriter fw = new FileWriter("Students Account/"+student.getLastName());
        for(String info: Info)
        {
               fw.write(info+"-");
        }
            fw.close();
            
            firstName.clear();
            lastName.clear();
            middleName.clear();
            studentId.clear();
            Course.clear();
         Alert AlertBox = new Alert(Alert.AlertType.INFORMATION, "Registered Succesfully!"); 
         AlertBox.showAndWait();
         for( String ob: student.StudentIdCollection)
         {
           System.out.print(ob);
         }
        }
  
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
