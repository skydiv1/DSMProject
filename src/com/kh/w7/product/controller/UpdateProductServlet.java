package com.kh.w7.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.w7.common.Attachment;
import com.kh.w7.common.MyFileRenamePolicy;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.service.ProductService;
import com.kh.w7.product.model.vo.PlusProduct;
import com.kh.w7.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/update.pr")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리 스트링으로 넘긴 값 파라미터로 받는다.
		
		// 폼전송을 multipart/form-data로 전송하는 경우에는
		// 기존처럼 requset.getParameter로 값을 받을 수 없다.
		
		// ★ cos.jar가 파일도 받고 다른 값도 받아주는 역할을 한다.
		// com.orelilly.servlet의 약자이다.
		
		// cos.jar 파일 -> WEB-INF/lib 밑에 넣어준다.
		
		if(ServletFileUpload.isMultipartContent(request)) { // 전송이 되었는지 확인한다.			
			// 전송 파일 용량 제한 : 10MB로 제한
			int maxSize = 1024 * 1024 * 10;//1MB x 10 = 10MB
			
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root); // D드라이브 경로 : C:\Users\Owner\git\DSMProject\web\
			
			String filePath = root + "image_uploadFiles/";
			
			MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int num = Integer.parseInt(multiRequest.getParameter("num")); // update.jsp에서 받아온 hidden의 num값을 담아준다.
			
			// 다중 파일을 묶어서 업로드 하기 위해 컬렉션 사용
			// 저장한 파일의 이름을 저장할 ArrayList 생성
			ArrayList<String> saveFiles = new ArrayList<String>(); // 바뀐이름의 파일 저장
			
			// 원본 파일의 이름을 저장할 ArrayLsit 생성
			ArrayList<String> originFiles = new ArrayList<String>(); // 원본 파일 저장
			
			// 각 파일의 정보를 구해온 뒤 DB에 저장할 목적의 테이블을 꺼내온다.
			Enumeration<String> files = multiRequest.getFileNames(); //getFileNames 리턴타입: Enumeration 
			
			while(files.hasMoreElements()) { // 보낸 파일의 역순으로 가져온다.
				String name = files.nextElement();				
				System.out.println("name: "+name);
				
				saveFiles.add(multiRequest.getFilesystemName(name)); // 저장되어 있는 이름을 가져올 수 있다.
				originFiles.add(multiRequest.getOriginalFileName(name)); // 바뀐 이름을 받아올 수 있다.
				
				System.out.println("fileSystem name: "+multiRequest.getFilesystemName(name)); // 2018121912231355085.jpg
				System.out.println("originalFileName name: "+multiRequest.getOriginalFileName(name)); // 다운로드.jpg
			}

			String multiAdditionalItem1 = "";
			String multiAdditionalItem2 = "";
			String multiAdditionalItem3 = "";
			int multiAdditionalPrice1 = 0;
			int multiAdditionalPrice2 = 0;
			int multiAdditionalPrice3 = 0;	
			
			/* name으로 준 값들을 java에서 servlet으로 가져온다. */
			//String membercode = "";
			String multiTile = multiRequest.getParameter("title"); // title: 키값
			String multiCateList = multiRequest.getParameter("cateList");
			String multiBasicItem = multiRequest.getParameter("basicItem");
			int multiBasicPrice = Integer.parseInt(multiRequest.getParameter("basicPrice"));		
			
			if(multiRequest.getParameter("additionalItem1") != null ) {
				multiAdditionalItem1 = multiRequest.getParameter("additionalItem1");
			}
			if(multiRequest.getParameter("additionalItem2") != null ) {
				multiAdditionalItem2 = multiRequest.getParameter("additionalItem2");
			}
			if(multiRequest.getParameter("additionalItem3") != null ) {
				multiAdditionalItem3 = multiRequest.getParameter("additionalItem3");
			}
			if(multiRequest.getParameter("additionalPrice1") != null ) {
				multiAdditionalPrice1 = Integer.parseInt(multiRequest.getParameter("additionalPrice1"));
			}
			if(multiRequest.getParameter("additionalPrice2") != null ) {
				multiAdditionalPrice2 = Integer.parseInt(multiRequest.getParameter("additionalPrice2"));
			}
			if(multiRequest.getParameter("additionalPrice3") != null ) {
				multiAdditionalPrice3 = Integer.parseInt(multiRequest.getParameter("additionalPrice3"));
			}
			
			String multiContent = multiRequest.getParameter("content");
			
			/* 데이터 제대로 넘어가는지 확인 */
			System.out.println("■(업데이트) title: "+multiTile);
			System.out.println("■(업데이트) cateList: "+multiCateList);
			System.out.println("■(업데이트) basicItem: "+multiBasicItem);
			System.out.println("■(업데이트) basicPrice: "+multiBasicPrice);
			System.out.println("■(업데이트) additionalItem1: "+multiAdditionalItem1);
			System.out.println("■(업데이트) additionalItem2: "+multiAdditionalItem2);
			System.out.println("■(업데이트) additionalItem3: "+multiAdditionalItem3);
			System.out.println("■(업데이트) additionalPrice1: "+multiAdditionalPrice1);
			System.out.println("■(업데이트) additionalPrice2: "+multiAdditionalPrice2);
			System.out.println("■(업데이트) additionalPrice3: "+multiAdditionalPrice3);				
			System.out.println("■(업데이트) content: "+multiContent);
			
			/* Product객체 생성 */
			Product product = new Product();
			product.setMemberCode(Integer.parseInt(String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getMemberCode())));			
			product.setProductName(multiTile);
			product.setProductCategory(multiCateList);
			product.setProductItem(multiBasicItem);
			product.setProductItemPrice(multiBasicPrice);
			product.setProductContext(multiContent);
			
			// 배열에 담아서 가져와야 한다.
			ArrayList<PlusProduct> pList = new ArrayList<PlusProduct>();
			PlusProduct pp = null;			

			if(multiAdditionalItem1 != "") {
				pp = new PlusProduct();
				pp.setPlusProductItem(multiAdditionalItem1);
				pp.setPlusProductPrice(multiAdditionalPrice1);		
				pList.add(pp);		
			}	
			if(multiAdditionalItem2 != "") {
				pp = new PlusProduct();
				pp.setPlusProductItem(multiAdditionalItem2);
				pp.setPlusProductPrice(multiAdditionalPrice2);		
				pList.add(pp);		
			}	
			if(multiAdditionalItem3 != "") {
				pp = new PlusProduct();
				pp.setPlusProductItem(multiAdditionalItem3);
				pp.setPlusProductPrice(multiAdditionalPrice3);		
				pList.add(pp);		
			}
						
			int result2 = new ProductService().updatePlusProduct(product, pList);
						
			// 세션으로 작성자를 가져온다.
			//String writer = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUno());
			
			// Attachment 객체 생성하여 ArrayList 객체 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			// 반복문을 통해 거꾸로 넘어온 파일들을 다시 역순으로 바꿔준다.
			for(int i=originFiles.size()-1; i>=0; i--) {
				Attachment at = new Attachment();
				at.setImgFilePath(filePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				at.setMemberCode(Integer.parseInt(String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getMemberCode())));
				
				fileList.add(at);
			}			
			int result1 = new ProductService().updateThumbnail(product, fileList);
		
			if(result1>0 && result2>0) {				
				response.sendRedirect("/dsm/selectOne.no?num="+num); // 수정완료 후 해당 상품 상세 페이지를 보기 위해서는 num의 값을 넘겨줘야 한다. - detail.jsp로 가기 위해
			}else {
				// 실패했을 때 저장된 사진 삭제
				for(int i=0; i<saveFiles.size(); i++) {
					// 파일시스템에 저장된 이름으로 파일 객체 생성
					File failedFile = new File(filePath + saveFiles.get(i));
					
					// 리턴값이 있다 (true, false)
					failedFile.delete(); // 이용할 일이 없어서 호출만으로 끝낸다.
				}	
								
				request.setAttribute("msg", "상품 수정 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
