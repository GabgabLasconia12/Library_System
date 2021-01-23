/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system;

/**
 *
 * @author Gab
 */
public class Search_Book extends Screen1Controller
{
    private String BookSearch;
    
    public void setBook(String Book)
    {
        this.BookSearch = Book;
    }
    
    public String getBook()
    {
        return BookSearch;
    }
    
}
