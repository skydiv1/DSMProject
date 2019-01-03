package com.kh.w7.faq.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.board.model.dao.BoardDao;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.faq.model.dao.FaqDao;
import com.kh.w7.faq.model.service.*;
import com.kh.w7.qna.model.dao.QnaDao;

public class FaqService {

	public ArrayList<Board> selectList(){
		Connection con = getConnection();		
		ArrayList<Board> list = new FaqDao().selectList(con);				
		close(con);		
		return list;
	}
	
	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list 
			= new FaqDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new FaqDao().getListCount(con);
		close(con);
		return listCount;
	}

	public Board selectOne(String num) {
		Connection con = getConnection();
		
		Board b = new FaqDao().selectOne(con, num);
		
		int result = 0;
		
		if(b != null ) {
			result = new FaqDao().updateCount(con, b.getBoardNo());
			if(result >0)commit(con);
			else rollback(con);
		}

		close(con);
		
		return b;
	}

	public int updateFaq(Board b) {
		Connection con = getConnection();
		
		int result = new FaqDao().updateFaq(con, b);
		
		if(result > 0) { 
			commit(con);
		}else {
			rollback(con);
		
		}
		close(con);
		
		return result;
	}
	
	
	
	
	
}
