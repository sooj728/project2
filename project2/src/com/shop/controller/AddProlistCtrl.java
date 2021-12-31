package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.ProlistDAO;
import com.shop.model.ProlistVO;

@WebServlet("/AddProlistCtrl")
public class AddProlistCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String nat = request.getParameter("nat");
		String genre = request.getParameter("genre");
		int price = Integer.parseInt(request.getParameter("price"));
		String img = request.getParameter("img");
		int num = Integer.parseInt(request.getParameter("cnt"));
		
		ProlistVO vo = new ProlistVO();
		vo.setPcode(pcode);
		vo.setPname(pname);
		vo.setNat(nat);
		vo.setGenre(genre);
		vo.setPrice(price);
		vo.setImg(img);
		vo.setCnt(num);
		
		ProlistDAO dao = new ProlistDAO();
		int cnt = dao.addProlist(vo);
		
		if(cnt != 0) {
			response.sendRedirect("GetProlistListCtrl");
		} else {
			response.sendRedirect("addProlist.jsp");
		} 
	}

}
