package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.shop.model.BoardVO;
import com.shop.model.DBConn;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public int getBoardListCount(HashMap<String, Object> listOpt) {
		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");
		String sql;
		int cnt = 0;
		try {
			conn = DBConn.getConnection();
			if(opt==null) {	//리스트페이지를 처음 방문했을 때
				sql = "select count(*) from board";
				stmt = conn.prepareStatement(sql);
			} else if (opt=="0") {	//제목으로 검색한 글의 개수	
				sql = "select count(*) from board where board_subject like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');
			} else if (opt=="1") {	//내용으로 검색한 글의 개수	
				sql = "select count(*) from board where board_content like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');
			} else if (opt=="2") {	//제목+내용 으로 검색한 글의 개수	
				sql = "select count(*) from board where board_subject like ? or board_content like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');
				stmt.setString(2, '%'+condition+'%');
			} else if (opt=="3") {	//글쓴이로 검색한 글의 개수	
				sql = "select count(*) from board where board_id like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');
			}
			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		
		return cnt;
	}
	
	
	public ArrayList<BoardVO> getBoardList(HashMap<String, Object> listOpt) {
		ArrayList<BoardVO> boardList = null;
		String opt = (String) listOpt.get("opt");			//"0"
		String condition = (String) listOpt.get("condition");	//"이벤트"
		int start = (Integer) listOpt.get("start");			//시작 페이지 또는 현재 페이지
		String sql = null;
		try {
			if(opt == null) {  //리스트 페이지를 처음 접속했을 때
				sql = "select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_count, board_date from (select * from board order by board_re_ref desc, board_re_seq asc )) where rnum>=? and rnum<=?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, start);
				stmt.setInt(2, start+9);
			} else if(opt == "0") {  //제목으로 검색한 글의 개수
				sql = "select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_count, board_date from (select * from board where board_subject like ? order by board_re_ref desc, board_re_seq asc)) where rnum>=? and rnum<=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');
				stmt.setInt(2, start);
				stmt.setInt(3, start+9);		
			} else if(opt == "1") {  //내용으로 검색한 글의 개수
				sql = "select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_count, board_date from (select * from board where board_content like ? order by board_re_ref desc, board_re_seq asc)) where rnum>=? and rnum<=?";
				stmt = conn.prepareStatement(sql);		
				stmt.setString(1, '%'+condition+'%');
				stmt.setInt(2, start);
				stmt.setInt(3, start+9);
			} else if(opt == "2") {  //제목+내용으로 검색한 글의 개수
				sql = "select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_count, board_date from (select * from board where board_subject like ? or board_content like ? order by board_re_ref desc, board_re_seq asc )) where rnum>=? and rnum<=?";
				sql = "select count(*) from board where board_subject like ? or board_content like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, '%'+condition+'%');		
				stmt.setString(2, '%'+condition+'%');
				stmt.setInt(3, start);
				stmt.setInt(4, start+9);
			} else if(opt.equals("3")) {
				sql = "select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_count, board_date from (select * from board where board_id like ? order by board_re_ref desc, board_re_seq asc )) where rnum>=? and rnum<=?";
				stmt = conn.prepareStatement(sql);		
				stmt.setString(1, '%'+condition+'%');
				stmt.setInt(2, start);
				stmt.setInt(3, start+9);
				
			}
			rs = stmt.executeQuery();
			boardList = new ArrayList<BoardVO>();
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setNum(rs.getInt("board_num"));
				board.setSubject(rs.getString("board_subject"));
				board.setContent(rs.getString("board_content"));
				board.setFile(rs.getString("board_file"));
				board.setRe_ref(rs.getInt("board_re_ref"));
				board.setRe_lev(rs.getInt("board_re_lev"));
				board.setRe_seq(rs.getInt("board_re_seq"));
				board.setCount(rs.getInt("board_count"));
				board.setDate(rs.getDate("board_date"));
				boardList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		return boardList;
	}
	
	public int insertBoard(BoardVO vo) {
		int r= 0;
		try {
			conn = DBConn.getConnection();
			String sql = "insert into board values (re_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 0, sysdate)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getSubject());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, vo.getFile());
			stmt.setInt(5, vo.getRe_ref());
			stmt.setInt(6, vo.getRe_lev());
			stmt.setInt(7, vo.getRe_seq());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
	
	public int updateBoard(BoardVO vo) {
		int r= 0;
		try {
			conn = DBConn.getConnection();
			String sql = "update board set board_subject=? board_content=? "
					+ "board_file=? board_date=sysdate where board_num=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getSubject());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getFile());
			stmt.setInt(4, vo.getNum());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
	
	public int deleteBoard(BoardVO vo) {
		int r = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "delete from board where board_num=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getNum());
			r = stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
}
