package Action;

import Dao.BookDao;
import Entity.Book;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookAction extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action.equals("getall")){
            this.getAll(request, response);
        }     
        else if(action.equals("querybookbyid")){
            this.QueryBookById(request, response);
        }      
        
    }
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bdao = new BookDao();
        ArrayList<Book> bookArrayList = bdao.getAllBook();
        HttpSession session = request.getSession();
        session.setAttribute("allbooklist", bookArrayList);
        request.getRequestDispatcher("/booklist.jsp").forward(request, response);
    }


    private void QueryBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BookDao bdao = new BookDao();
        String id = request.getParameter("id");
        String next = request.getParameter("next");
        Book book = bdao.QueryBookById(id);
        HttpSession session = request.getSession();
        session.setAttribute("resultbook", book);
        PrintWriter out = response.getWriter();
        if(next.equals("check"))
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        else if(next.equals("edit"))
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        else if(next.equals("borrowcheck")){
            out.write(book.getName() + "||" + book.getAuthor() + "||" + book.getPublisher() + "||" + book.getRemain());
        }
        else if(next.equals("existcheck")){
            out.write(book.getName());
        }
    }


 
}
