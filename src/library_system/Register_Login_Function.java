/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;
import java.util.Queue;



public class Register_Login_Function extends Student_RegisterController 
{
   String firstName;
   String lastName;
   String middleName;
   String StudentId;
   String Password;
   String Course;
  
Queue<String> StudentIdCollection = new LinkedList<String>();
  
   public void setFirstName(String FirstName)
   {
       this.firstName = FirstName;
   }
  public void setLastName(String LastName)
  {
      this.lastName = LastName;
  }
  public void setMiddleName (String MiddleName)
  {
      this.middleName = MiddleName;
  }
  
  public void setStudentId(String id)
  {
      this.StudentId = id;
  }
  
  public void setPassword(String _Password)
  {
      this.Password = _Password;
  }
  
  public void setCourse(String _Course)
  {
      this.Course = _Course;
  }
  
  public String getStudentId()
  {
      return StudentId;
  }
  
    public String getPassword()
  {
      return Password;
  }
    
      public String getCourse()
  {
      return Course;
  }
  
  public String getFirstName()
  {
      return firstName;
  }
  
  public String getLastName()
  {
      return lastName;
  }
  
  public String getMiddleName()
  {
      return middleName;
  }
}
