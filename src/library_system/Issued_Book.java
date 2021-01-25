/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Gab
 */
public class Issued_Book
{
     private SimpleStringProperty _BookName;
    private SimpleStringProperty StudentName;
   
   
    
    
    public Issued_Book(String _BookName, String StudentName)
    {
        this._BookName = new SimpleStringProperty(_BookName);
        this.StudentName = new SimpleStringProperty(StudentName);
        
    }
    public void setBookName(String _BookName)
    {
       this._BookName = new SimpleStringProperty(_BookName);
    }
    public void setStudentName(String StudentName)
    {
        this.StudentName = new SimpleStringProperty(StudentName);
    }
    public String getBookName()
    {
        return _BookName.get();
    }
    public String getStudentName()
    {
        return StudentName.get();
    }
}
