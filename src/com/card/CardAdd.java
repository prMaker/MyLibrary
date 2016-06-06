package com.card;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CardDAO;
import com.entity.Card;

/**
 * Servlet implementation class CardAdd
 */
public class CardAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/cardadd.jsp").forward(request,response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	CardDAO dao = new CardDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card c = new Card();
		c.setCode(request.getParameter("code"));
		c.setName(request.getParameter("name"));
		c.setTel(request.getParameter("tel"));
		System.out.println(c);
		if(dao.addC(c)){
			response.sendRedirect("/cardhome");
		}else{
			response.sendError(403,"没有权限进行该操作!");
		}
	}

}
