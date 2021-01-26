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
public class Issue_Books 
{
    private SimpleStringProperty BOOKNAME;
    public Issue_Books(String BOOKNAME)
    {
        this.BOOKNAME = new SimpleStringProperty(BOOKNAME);
    }

    public String getBOOKNAME() {
        return BOOKNAME.get();
    }

    public void setBOOKNAME(String BOOKNAME) {
        this.BOOKNAME = new SimpleStringProperty(BOOKNAME);
    }
    
   
}
