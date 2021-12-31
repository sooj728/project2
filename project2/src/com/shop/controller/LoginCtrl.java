package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.UsertbVO;

import com.shop.biz.UsertbDAO;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String u_id = request.getParameter("u_id");
		String pw =request.getParameter("pw");
		UsertbVO vo = new UsertbVO();
	
		vo.setU_id(u_id);
		vo.setPw(pw);
		
		UsertbVO tm = new UsertbVO();
		UsertbDAO dao = new UsertbDAO();
		tm = dao.loginUsertb(vo);
		HttpSession session = request.getSession();
		
		if (tm!=null) {
			session.setAttribute(u_id, tm.getU_id());
			session.setAttribute("uname", tm.getUname());
			session.setAttribute("email", tm.getEmail());
			session.setAttribute("add1", tm.getAdd1());
			session.setAttribute("add2", tm.getAdd2());
			session.setAttribute("cp", tm.getCp());
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("GetProlistListCtrl");
		}
	}

}
