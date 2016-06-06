package com.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

import com.dao.AdminDAO;

/**
 * Servlet implementation class Home
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] ck = request.getCookies();
		String user = null;
		String password = null;
		for (Cookie cook : ck) {
			if ("user".equals(cook.getName())) {
				user = cook.getValue();
			}
			if ("password".equals(cook.getName())) {
				password = cook.getValue();
			}
		}
		if (user != null && password != null) {
			if (dao.find(user, password)) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/homepage");
				return;
			} else {
				Cookie ck1 = new Cookie("user", "");
				Cookie ck2 = new Cookie("password", "");
				ck1.setPath("");
				ck1.setMaxAge(0);
				ck1.setValue("");
				response.addCookie(ck1);
				ck2.setMaxAge(0);
				ck2.setDomain("/");
				ck2.setValue("");
				response.addCookie(ck2);
			}
		}

		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	AdminDAO dao = new AdminDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("name");
		String password = request.getParameter("pwd");
		String remberMe = request.getParameter("remberMe");
		if (dao.find(user, password)) {
			if ("remberMe".equals(remberMe)) {
				Cookie ck1 = new Cookie("user", user);
				Cookie ck2 = new Cookie("password", password);
				ck1.setHttpOnly(true);
				ck1.setMaxAge(60 * 60 * 24 * 7);
				ck1.setPath("/");
				ck2.setHttpOnly(true);
				ck2.setMaxAge(60 * 60 * 24 * 7);
				ck2.setPath("/");
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/homepage");
		} else {
			response.sendRedirect("/index?error=10001");
		}
	}
}
