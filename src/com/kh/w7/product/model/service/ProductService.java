package com.kh.w7.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.common.Attachment;
import com.kh.w7.product.model.dao.ProductDao;
import com.kh.w7.product.model.vo.PlusProduct;
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
	public ArrayList<HashMap<String, Object>> selecImagetList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ProductDao().selecImagetList(con,currentPage, limit);
		
		close(con);
		
		return list;
	}


	/* 추가 항목 (최대 3개) 입력 *//* 상품 등록 페이지(이미지 첨부 포함) */
	public int insertPlusProduct(Product product, ArrayList<PlusProduct> pList, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;

		/*int nextNum = new ProductDao().selectNextval(con); // SEQ_PRODUCT 다음시퀀스 값 조회
		System.out.println("nextNum(다음시퀀스 조회) : "+nextNum);
		int imgNo = new ProductDao().selectImgNextval(con); // SEQ_IMG 다음시퀀스 값 조회
		System.out.println("nextNum(이미지테이블 다음시퀀스 조회) : "+imgNo);*/
		
		int result1= new ProductDao().insertThumbnailContent(con, product); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		System.out.println("result1  :  "+result1);
		if(result1>0) {
			int currNum = new ProductDao().selectCurrval(con); // 현재시퀀스 값 조회
			System.out.println("(insertPlusProduct)현재시퀀시 값 조회: " + currNum); // SEQ_PRODUCT
			
			for(int i=0; i<pList.size(); i++) { // 게시물 하나에 값 최대 3개가 존재
				pList.get(i).setProductNo(currNum); // product에서 시퀀스 값을 가져와서 1,2,3번에 해당 시퀀스 값을 넣어준다. / CURRVAL로 가져온 값
				fileList.get(i).setProductNo(currNum); 	
				//fileList.get(i).setImgNo(imgNo); 
			}		
			System.out.println("pList.size() 서비스 : "+pList.size());
			
			for(int i=0; i<fileList.size(); i++) { 
				//fileList.get(i).setProductNo(currNum); 	
				//fileList.get(i).setImgNo(imgNo); 
			}
			System.out.println("fileList.size() 서비스 : "+fileList.size());
		}

		int result2 = new ProductDao().insertPlusProduct(con, pList);

		int result3 = new ProductDao().insertAttachment(con, fileList);
		
		// 트랜젝션 처리
		if(result1>0 && result2>0 && result3>0) { // 둘 다 양수여야 리턴할 수 있음
			commit(con);
			result = 1; // 대표값으로 바꿔준다. (2,3, ... 어떤 값이 올지 모른다.) 
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


	/* 상품 등록 페이지(이미지 첨부 포함) */
	/*public int insertThumbnail(Product product, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		
		//int imgNo = new ProductDao().selectImgNextval(con); // 다음시퀀스 값 조회
		//System.out.println("nextNum(이미지테이블 다음시퀀스 조회) : "+imgNo);
		
		int result1= new ProductDao().insertThumbnailContent(con, product); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.

		if(result1>0) {
			int productNo = new ProductDao().selectCurrval(con); // 현재시퀀스 값 조회
			System.out.println("(insertThumbnail)현재시퀀시 값 조회: " + productNo);
			
			for(int i=0; i<fileList.size(); i++) { // 게시물 하나에 파일이 최대 6개가 존재
				fileList.get(i).setProductNo(productNo); // Product에서 시퀀스 값을 가져와서 1,2,3,4번 사진에 해당 시퀀스 값을 넣어준다. / CURRVAL로 가져온 값
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
	}*/


	/* 상품 목록에서 상품 상세보기 페이지로 이동 */
	public HashMap<String, Object> selectThumbnailMap(int num) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		
		hmap = new ProductDao().selectThumbnailMap(con, num);
		
		close(con);
		
		System.out.println("hmap(service)확인: "+hmap);
		
		return hmap;
	}


	/* 상품 업데이트 - 이미지 */
	public int updateThumbnail(Product product, ArrayList<Attachment> fileList, int num, Attachment at) {
		Connection con = getConnection();
		int result = 0;
		
		int result1= new ProductDao().updateThumbnailContent(con, product, num); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		
		/* 이미지 업데이트 */
		//ArrayList<Attachment> imgList = new ArrayList<Attachment>();
		for(int i=0; i<fileList.size(); i++){
			at = new Attachment();
			fileList.get(i).getImgNo();
			fileList.get(i).getChangeName();
			fileList.get(i).getImgFilePath();
			fileList.add(at);			
		}
		System.out.println("▶ service에서 이미지 리스트 값 확인 : "+fileList);
		int result2 = new ProductDao().updateAttachment(con, fileList, num);
		System.out.println("result2(updateThumbnail) 이미지 수정되는지 확인 : "+result2);
		
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


	/* 상품 업데이트 - 추가항목 */
	public int updatePlusProduct(Product product, ArrayList<PlusProduct> pList, int num, ArrayList<PlusProduct> fixedpList) {
		Connection con = getConnection();
		int result = 0;

		int result1= new ProductDao().updateThumbnailContent(con, product,num); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.

		System.out.println("result1  :  "+result1);

		int result2 =0;
		//String item[]= new String[pList.size()];
		ArrayList<String> plusList = new ArrayList<String>();
		for(int i=0; i<pList.size(); i++){
			plusList.add(pList.get(i).getPlusProductItem());
			System.out.println("service에서 item 값 확인 : "+plusList);
		}
		result2 = new ProductDao().updatePlusProduct(con, pList, num, plusList, fixedpList);
		System.out.println("result2값 service에서 증가하는지 확인(updatePlusProduct): "+result2);
		System.out.println("pList: "+pList);
		
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


	/* ajax를 이용한 검색(검색어 입력 후 검색버튼 클릭 시) */
	public ArrayList<HashMap<String, Object>> searchtList(int currentPage, int listCount, int limit, String searchList) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ProductDao().searchtList(con, currentPage, listCount, limit, searchList);
		
		close(con);
		
		return list;
	}


	/* 상품 삭제(update PRODUCT_DELETEYN=1) */
	public int deleteOne(String num) {
		Connection con = getConnection();
		
		int result= new ProductDao().deleteOne(con, num); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		System.out.println("result1(deleteOne)  :  "+result);
		
		// 트랜젝션 처리
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


	/* 이미지 삭제(update IMG_DELETE=1) */
	public int deleteImgOne(String num) {
		Connection con = getConnection();
		
		int result= new ProductDao().deleteImgOne(con, num); // product 내용만 insert / 부모 테이블 먼저 insert 해야 한다.
		System.out.println("result1(deleteImgOne)  :  "+result);
		
		// 트랜젝션 처리
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


	/* 특정 게시글 수 조회 */
	public int getTitleListCount(String searchList) {
		Connection con = getConnection();
		int listCount = new ProductDao().getTitleListCount(con, searchList);
		close(con);	

		return listCount;
	}





}
