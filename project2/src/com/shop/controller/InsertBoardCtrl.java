package com.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.biz.BoardDAO;
import com.shop.model.BoardVO;

@WebServlet("/InsertBoardCtrl")
public class InsertBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileSize = 5*1024*1024;
		
		try {
		//파일업로드
		//MultipartRequest multi = new MultipartRequest, saveDirectory, fileSize, "utf-8", new DefaultFileRenamePolicy());
		String saveDirectory = "D:\\ssj\\jsp2\\project2\\WebContent\\img";
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, fileSize, "utf-8"); //덮어쓰기
		
        // 파일이름 가져오기
        String fileName = "";
        Enumeration<String> names = multi.getFileNames();
        if(names.hasMoreElements()) {
            String name = names.nextElement();
            fileName = multi.getFilesystemName(name);
        }
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
	      board.setNum(Integer.parseInt(request.getParameter("num"))); // 시퀀스값 가져와 세팅
          board.setId(multi.getParameter("id")); // 히든값
          board.setSubject(multi.getParameter("subject"));
          board.setContent(multi.getParameter("content"));
          board.setFile(multi.getParameter("file"));
          
          int cnt = dao.insertBoard(board);
	  	if(cnt != 0) {
			response.sendRedirect("GetBoardListCtrl");
		} else {
			response.sendRedirect("insertBoard.jsp");
		} 
    	} catch (Exception e) {
    		e.printStackTrace();
        System.out.println("글 작성 오류 : " + e.getMessage());
	    }
	}

}
