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
public class Book_Issued 
{
  private SimpleStringProperty BookName_;
  private SimpleStringProperty Name_;
  
  public Book_Issued(String BookName_, String Name_)
  {
      this.BookName_ = new  SimpleStringProperty(BookName_);
      this.Name_ = new SimpleStringProperty(Name_);
  }

    public String getBookName_() {
        return BookName_.get();
    }

    public void setBookName_(String BookName_) {
        this.BookName_ = new SimpleStringProperty(BookName_);
    }

    public String getName_() {
        return Name_.get();
    }

    public void setName_(String Name_) {
        this.Name_ = new SimpleStringProperty(Name_);
    }
  
  
}
