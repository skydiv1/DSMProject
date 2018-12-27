package com.kh.w7.reply.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.reply.model.dao.ReplyDao;
import com.kh.w7.reply.model.vo.Reply;


public class ReplyService {
	

	public ArrayList<Reply> insertReply(Reply r) {
		Connection con = getConnection();
		ArrayList<Reply> replyList = null;
		
		int result = new ReplyDao().insertReply(con, r);		
		
		if(result > 0) {
			commit(con);
			replyList = new ReplyDao().selectReplyList(con, r.getReplyNo());
			
			
		}else {
			rollback(con);
		}
		close(con);
		
		return replyList;
	}
}
