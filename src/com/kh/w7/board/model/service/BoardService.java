package com.kh.w7.board.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.board.model.dao.BoardDao;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.common.Attachment;

public class BoardService {

	public ArrayList<Board> selectList(){
		Connection con = getConnection();		
		ArrayList<Board> list = new BoardDao().selectList(con);				
		close(con);		
		return list;
	}
	
	public int insertBoard(Board b) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertBoard(con, b);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}
	//페이징처리 적용한 게시물 조회용 메소드
		public ArrayList<Board> selectList(int currentPage, int limit) {
			Connection con = getConnection();
			
			ArrayList<Board> list 
				= new BoardDao().selectList(con, currentPage, limit);
			
			close(con);
			
			return list;
		}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con);
		close(con);
		return listCount;
	}

	

	public Board selectOne(int num) {
		Connection con = getConnection();
		
		Board b = null;
		
		int result = new BoardDao().updateCount(con, num);
		
		if(result > 0 ) {
			commit(con);
			b = new BoardDao().selectOne(con, num);
			
		}else {
			rollback(con);
		}

		close(con);
		
		return b;
	}

	
}
