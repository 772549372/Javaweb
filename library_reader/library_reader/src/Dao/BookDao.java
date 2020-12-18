package Dao;

import Entity.Book;
import Util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends DBConnect {
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> booklist = new ArrayList<>();
        IODao ioDao = new IODao();
        try {
            Connection conn = super.getConnection();
            String sql = "SELECT * FROM Book";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getString("id"));
                book.setName(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getInt("price"));
                book.setCategory(rs.getString("category"));
                book.setStore(rs.getInt("store"));
                book.setLend(ioDao.QueryBookNumById(book.getId()));
                book.setRemain(book.getStore() - book.getLend());
                book.setLocation(rs.getString("location"));
                booklist.add(book);
            }
            return booklist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booklist;
    }


    public  Book QueryBookById(String s){
        try {
            IODao ioDao = new IODao();
            Connection conn = super.getConnection();
            String sql = "SELECT * FROM Book WHERE id=" + "'" + s + "'";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Book book = new Book();
            while (rs.next()) {
                book.setId(rs.getString("id"));
                book.setName(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getInt("price"));
                book.setCategory(rs.getString("category"));
                book.setStore(rs.getInt("store"));
                book.setLend(ioDao.QueryBookNumById(book.getId()));
                book.setRemain(book.getStore() - book.getLend());
                book.setDesc(rs.getString("bookdesc"));
                book.setLocation(rs.getString("location"));
            }
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    
 
}
