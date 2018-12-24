package com.kh.w7.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.common.Attachment;
import com.kh.w7.product.model.dao.ProductDao;
import com.kh.w7.product.model.vo.Product;

import static com.kh.w7.common.JDBCTemplate.*;

public class ProductService {

	/* 상품 목록 페이지 조회 */
	public ArrayList<Product> selectList() {
		Connection con = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectList(con);
		
		close(con);	
		
		return list;
	}

	
	/* 전체 게시글 수 조회 */
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new ProductDao().getListCount(con);
		close(con);	

		return listCount;
	}


	/* 상품 목록 페이지 조회(페이징처리) */
	public ArrayList<Product> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectList(con, currentPage, limit);
		
		return list;
	}


	/* 상품 등록 페이지(이미지 첨부 포함) */
	public int insertThumbnail(Product product, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		
		int result1= new ProductDao().insertThumbnailContent(con, product); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		
		if(result1>0) {
			int bid = new ProductDao().selectCurrval(con); // 현재시퀀스 값 조회
			
			for(int i=0; i<fileList.size(); i++) { // 게시물 하나에 파일이 네개가 존재
				fileList.get(i).setBid(bid); // Board에서 시퀀스 값을 가져와서 1,2,3,4번 사진에 해당 시퀀스 값을 넣어준다. / CURRVAL로 가져온 값
			}
		}
		
		int result2 = new ProductDao().insertAttachment(con, fileList);
		
		// 트랜젝션 처리
		if(result1>0 && result2>0) { // 둘 다 양수여야 리턴할 수 있음
			commit(con);
			result = 1; // 대표값으로 바꿔준다. (2,3, ... 어떤 값이 올지 모른다.) 
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
