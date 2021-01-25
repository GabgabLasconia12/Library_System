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
public class StackOfBook
{
     private SimpleStringProperty BookName;
      public StackOfBook(String BookName)
    {
        this.BookName = new SimpleStringProperty(BookName);
        
    }
      public void setBookName(String BookName)
      {
          this.BookName = new SimpleStringProperty(BookName);
      }
      public String getBookName()
      {
          return BookName.get();
      }
}
