package com.card;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CardDAO;
import com.entity.Card;

/**
 * Servlet implementation class CardUpdate
 */
public class CardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CardDAO dao = new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Card c = dao.selectC(id);
		request.setAttribute("card", c);
		request.getRequestDispatcher("/WEB-INF/views/cardupdate.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card c = new Card();
		c.setId(new Integer(request.getParameter("id")));
		c.setCode(request.getParameter("code"));
		c.setName(request.getParameter("name"));
		c.setTel(request.getParameter("tel"));
		if(dao.updateC(c)){
			response.sendRedirect("/cardhome");
		}else{
			response.sendError(403,"没有权限进行该操作!");
		}
	}

}
