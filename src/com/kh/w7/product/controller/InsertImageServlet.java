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
import com.kh.w7.product.model.service.ProductService;
import com.kh.w7.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertImageServlet
 */
@WebServlet("/insert.pr")
public class InsertImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			/* name으로 준 값들을 java에서 servlet으로 가져온다. */
			String multiTile = multiRequest.getParameter("title"); // title: 키값
			String multiCateList = multiRequest.getParameter("cateList");
			String multiBasicItem = multiRequest.getParameter("basicItem");
			int multiBasicPrice = Integer.parseInt(multiRequest.getParameter("basicPrice"));			
			String multiAdditionalItem1 = multiRequest.getParameter("additionalItem1");
			String multiAdditionalItem2 = multiRequest.getParameter("additionalItem2");
			String multiAdditionalItem3 = multiRequest.getParameter("additionalItem3");
			int multiAdditionalPrice1 = Integer.parseInt(multiRequest.getParameter("additionalPrice1"));
			int multiAdditionalPrice2 = Integer.parseInt(multiRequest.getParameter("additionalPrice2"));
			int multiAdditionalPrice3 = Integer.parseInt(multiRequest.getParameter("additionalPrice3"));			
			String multiContent = multiRequest.getParameter("content");
			
			/* 데이터 제대로 넘어가는지 확인 */
			System.out.println("■ title: "+multiTile);
			System.out.println("■ cateList: "+multiCateList);
			System.out.println("■ basicItem: "+multiBasicItem);
			System.out.println("■ basicPrice: "+multiBasicPrice);
			System.out.println("■ additionalItem1: "+multiAdditionalItem1);
			System.out.println("■ additionalItem2: "+multiAdditionalItem2);
			System.out.println("■ additionalItem3: "+multiAdditionalItem3);
			System.out.println("■ additionalPrice1: "+multiAdditionalPrice1);
			System.out.println("■ additionalPrice2: "+multiAdditionalPrice2);
			System.out.println("■ additionalPrice3: "+multiAdditionalPrice3);				
			System.out.println("■ content: "+multiContent);
			
			// Product객체 생성
			Product product = new Product();
			//product.setMemberCode(로그인되면 맴버코드);
			
			//★ 여기서 널값이 들어온다면(입력한 값이 없다면) 500번 오류 발생(NullPointException)
			// 널 값을 잡으려면 if else문으로 널 값일때 들어갈 수 없게 잡아줘야 한다.
			product.setProductName(multiTile);
			product.setProductCategory(multiCateList);
			product.setProductItem(multiBasicItem);
			product.setProductItemPrice(multiBasicPrice);
			product.setPlusProductItem(multiAdditionalItem1);
			product.setPlusProductItem(multiAdditionalItem2);
			product.setPlusProductItem(multiAdditionalItem3);
			product.setPlusProductPrice(multiAdditionalPrice1);
			product.setPlusProductPrice(multiAdditionalPrice2);
			product.setPlusProductPrice(multiAdditionalPrice3);
			product.setProductContext(multiContent);
						
			// 세션으로 작성자를 가져온다.
			//product.setbWriter(String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUno()));
			
			// Attachment 객체 생성하여 ArrayList 객체 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			// 반복문을 통해 거꾸로 넘어온 파일들을 다시 역순으로 바꿔준다.
			for(int i=originFiles.size()-1; i>=0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(filePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				fileList.add(at);
			}			
			int result = new ProductService().insertThumbnail(product, fileList);
		
			if(result>0) {
				response.sendRedirect(request.getContextPath()+"/selectList.pr");
			}else {
				// 실패했을 때 저장된 사진 삭제
				for(int i=0; i<saveFiles.size(); i++) {
					// 파일시스템에 저장된 이름으로 파일 객체 생성
					File failedFile = new File(filePath + saveFiles.get(i));
					
					// 리턴값이 있다 (true, false)
					failedFile.delete(); // 이용할 일이 없어서 호출만으로 끝낸다.
				}	
								
				request.setAttribute("msg", "사진 게시판 등록 실패!");
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
