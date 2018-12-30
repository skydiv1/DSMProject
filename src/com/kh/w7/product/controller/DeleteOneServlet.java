package com.kh.w7.product.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.w7.common.MyFileRenamePolicy;
import com.kh.w7.product.model.service.ProductService;
import com.kh.w7.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class DeleteOneServlet
 */
@WebServlet("/deleteOne.pr")
public class DeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) { // 전송이 되었는지 확인한다.	
			int maxSize = 1024 * 1024 * 10;	
			String root = request.getSession().getServletContext().getRealPath("/");			
			String filePath = root + "image_uploadFiles/";
			
			MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String num = multiRequest.getParameter("num"); // MultipartRequest로 보내지 않으면 null값이 들어오는 오류
			
			System.out.println("num값 확인(deleteOne 서블릿): "+num);
			
			int result = new ProductService().deleteOne(num);
			System.out.println("deleteOne 서블릿(result값) : "+result);
			
			if(result>0) {				
				response.sendRedirect("/dsm/selectList.pr"); // 상품 삭제 후 리스트로 돌아가기
			}else {		
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
