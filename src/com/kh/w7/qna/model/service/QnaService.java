package com.kh.w7.qna.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.board.model.dao.BoardDao;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.common.Attachment;

public class QnaService {

	public ArrayList<Board> selectList(){
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(con);
		close(con);
		return list;
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
