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
public class Add_Book_Function extends Add_Book_FormController
{
   private String Book_Name;
  private  String Book_Category;
   private String Book_Description;
   private String Book_Title;
  private  String Book_Author;
   private String Book_Page;
   
  
    
    public void setBookName(String BookName)
    {
        this.Book_Name = BookName;
    }
    public void setBookCategory(String BookCategory)
    {
        this.Book_Category =BookCategory;
    }
    public void setBookDescription(String BookDescription)
    {
        this.Book_Description = BookDescription;
    }
    public void setBookTitle(String BookTitle)
    {
        this.Book_Title = BookTitle;
    }
    public void setBookAuthor(String BookAuthor)
    {
        this.Book_Author = BookAuthor;
    }
    public void setBookPage(String BookPage)
    {
        this.Book_Page = BookPage;
    }
    public String getBookName()
    {
        return Book_Name;
    }
    public String getBookCategory()
    {
        return Book_Category;
    }
    public String getBookDescription()
    {
        return Book_Description;
    }
    public String getBookTitle()
    {
        return Book_Title;
    }
    public String getBookAuthor()
    {
        return Book_Author;
    }
    public String getBookPage()
    {
        return Book_Page;
    }
}
