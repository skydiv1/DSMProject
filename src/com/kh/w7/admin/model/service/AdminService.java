package com.kh.w7.admin.model.service;

import com.kh.w7.admin.model.dao.AdminDao;
import com.kh.w7.refund.model.vo.Refund;
import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


public class AdminService {

	public ArrayList<Refund> SelectAllRefundMember() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Refund> list = new AdminDao().SelectAllRefundMember(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

}
