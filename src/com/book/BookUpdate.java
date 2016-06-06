package com.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;

/**
 * Servlet implementation class BookUpdate
 */
public class BookUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BookDAO dao = new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Book b = dao.selectB(id);
		request.setAttribute("book", b);
		request.getRequestDispatcher("/WEB-INF/views/bookupdate.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		b.setId(new Integer(request.getParameter("id")));
		b.setCode(request.getParameter("code"));
		b.setTitle(request.getParameter("title"));
		b.setAuthor(request.getParameter("author"));
		b.setPublishing(request.getParameter("publishing"));
		b.setTotal(new Integer(request.getParameter("total")));
		b.setCount(new Integer(request.getParameter("count")));
		System.out.println(b);
		if(dao.updateB(b)){
			response.sendRedirect("/bookhome");
		}else{
			response.sendError(403,"没有权限进行该操作！");
		}
	}

}
