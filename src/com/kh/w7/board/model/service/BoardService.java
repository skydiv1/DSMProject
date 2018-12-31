package com.kh.w7.board.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
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
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	
	}
	
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

	

	public Board selectOne(String boardNo) {
		Connection con = getConnection();
		
		Board b = new BoardDao().selectOne(con, boardNo);
		
		int result = 0;
		
		if(b != null ) {
			result = new BoardDao().updateCount(con, b.getBoardNo());
			if(result >0)commit(con);
			else rollback(con);
		}

		close(con);
		
		return b;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();
		
		int result = new BoardDao().updateBoard(con, b);
		
		if(result > 0) { 
			commit(con);
		}else {
			rollback(con);
		
		}
		close(con);
		
		return result;
	}


	
	
}
