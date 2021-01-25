/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Gab
 */
public class ReturnBook 
{
    private SimpleStringProperty _Book_Name;
    private SimpleStringProperty _TimetoReturn;
   
   
    
    
    public ReturnBook(String _Book_Name, String _TimetoReturn)
    {
        this._Book_Name = new SimpleStringProperty(_Book_Name);
        this._TimetoReturn = new SimpleStringProperty(_TimetoReturn);
        
    }
    public void setBookName(String _Book_Name)
    {
       this._Book_Name = new SimpleStringProperty(_Book_Name);
    }
    public void setTimeToReturn(String _TimetoReturn)
    {
        this._TimetoReturn = new SimpleStringProperty(_TimetoReturn);
    }
    public String getBook_Name()
    {
        return _Book_Name.get();
    }
    public String getTimeToReturn()
    {
        return _TimetoReturn.get();
    }
}
