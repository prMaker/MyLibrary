package com.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.CardDAO;
import com.entity.Book;

/**
 * Servlet implementation class BookAdd
 */
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/bookadd.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	BookDAO dao = new BookDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		b.setCode(request.getParameter("code"));
		b.setTitle(request.getParameter("title"));
		b.setAuthor(request.getParameter("author"));
		b.setPublishing(request.getParameter("publishing"));
		b.setTotal(new Integer(request.getParameter("total")));
		b.setCount(new Integer(request.getParameter("total")));
		if(dao.add(b)){
			response.sendRedirect("/bookhome");
		}else{
			response.sendError(403,"没有权限进行该操作！");
		}
	}

}
