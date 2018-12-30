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
	
	public int insertBoard(Board b, ArrayList<Attachment> boardNo) {
		Connection con = getConnection();
		
		/*int result = new BoardDao().insertBoard(con, b);*/
		
		
		
		int board = new BoardDao().selectNextval(con); // 다음시퀀스 값 조회
		System.out.println("nextNum(다음시퀀스 조회) : "+board);
		
		int result= new BoardDao().insertBoard(con, b); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		System.out.println("result1  :  "+result);
		if(result>0) {
			int currNum = new BoardDao().selectCurrval(con); // 현재시퀀스 값 조회
			System.out.println("(insertPlusProduct)현재시퀀시 값 조회: " + currNum);
			
			for(int i=0; i<boardNo.size(); i++) { // 게시물 하나에 값 최대 3개가 존재
				boardNo.get(i).setBoardNo(currNum); // product에서 시퀀스 값을 가져와서 1,2,3번에 해당 시퀀스 값을 넣어준다. / CURRVAL로 가져온 값
			}
		}		
			
		/*if(result > 0) commit(con);*/
		// 트랜젝션 처리
		if(result>0 ) { // 둘 다 양수여야 리턴할 수 있음
			commit(con);
			result = 1; // 대표값으로 바꿔준다. (2,3, ... 어떤 값이 올지 모른다.) 
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
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
}
