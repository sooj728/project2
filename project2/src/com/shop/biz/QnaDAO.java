package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.shop.model.DBConn;
import com.shop.model.QnaVO;

//배치(batch) 프로그래밍: 한 곳에서 일을 한꺼번에 처리하기 위한 프로그래밍
//Qna 테이블에 접근하여 데이터 처리 요청되어 온 일들을 모두 한 곳에서 처리하기 위한 모듈

public class QnaDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//사용자 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해 주는 역할의 메서드
	public ArrayList<QnaVO> getQnaList() {
		ArrayList<QnaVO> QnaList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select * from qna order by qnaid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			QnaList = new ArrayList<QnaVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int qnaid = rs.getInt("qnaid");
				String tit = rs.getString("tit");
				String con = rs.getString("con");
				String author = rs.getString("author");
				int pw = rs.getInt("pw");
				Date regdate = rs.getDate("regdate");
				int visited = rs.getInt("visited");
			
				//각 지역변수에 담긴 필드값을 VO에 담기
				QnaVO qna = new QnaVO();
				qna.setQnaid(qnaid);
				qna.setTit(tit);
				qna.setCon(con);
				qna.setAuthor(author);
				qna.setPw(pw);
				qna.setRegdate(regdate);
				qna.setVisited(visited);
				
				//VO에 담긴 데이터를 LIST에 답기
				QnaList.add(qna);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return QnaList;
	}
	
	public QnaVO getQna(QnaVO vo) {
		QnaVO qna = null;
		try {
			conn = DBConn.getConnection();
			String sql = "update qna set visited=visited+1 where qnaid= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getQnaid());
			int r = stmt.executeUpdate();
			stmt.close();
			if(r>0)	{
				sql = "select * from qna where qnaid = ?";
				stmt.getConnection().prepareStatement(sql);
				stmt.setInt(1, vo.getQnaid());
				rs = stmt.executeQuery();
				if(rs.next()) {
					qna = new QnaVO();
					qna.setQnaid(rs.getInt("qnaid"));
					qna.setTit(rs.getString("tit"));
					qna.setCon(rs.getString("con"));
					qna.setAuthor(rs.getString("author"));
					qna.setPw(rs.getInt("pw"));
					qna.setRegdate(rs.getDate("regdate"));
					qna.setVisited(rs.getInt("visited"));
				}
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		return qna;
	}
	
	public int updateQna(QnaVO vo) {

		int r=0;
		try {
			conn= DBConn.getConnection();
			String sql = "update Qna set tit=? con=? regdate=sysdate where qnaid=?";
			stmt.getConnection().prepareStatement(sql);
			stmt.setString(1, vo.getTit());
			stmt.setString(2, vo.getCon());
			stmt.setInt(3, vo.getQnaid());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
	
	public int deleteQna(QnaVO vo) {
		int r = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "delete from qna where qnaid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getQnaid());
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

	public int insertQna(QnaVO vo) {
		int r=0;
		try {
			conn = DBConn.getConnection();
			String sql = "insert into qna values(qna_seq.nextval, ?, ?, ?, ?, sysdate, 0)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTit());
			stmt.setString(2, vo.getCon());
			stmt.setString(3, vo.getAuthor());
			stmt.setInt(4, vo.getPw());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
}
