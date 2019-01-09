package com.kh.w7.member.controller;

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
import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/insertImg.me")
public class InsertImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param memberId 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("판매자 이미지 서블릿");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*100;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root); // D드라이브 경로 : C:\Users\Owner\git\DSMProject\web\
			
			String filePath = root + "image_uploadFiles/";
			
			System.out.println("root : "+root);
			
			MultipartRequest multiRequest
			 = new MultipartRequest(request, filePath, maxSize,
					 "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration<String> files = multiRequest.getFileNames();//input type=file
			
			while(files.hasMoreElements()) {
				String memberName = files.nextElement();
				
				System.out.println();
				System.out.println("name  : " + memberName);
				
				saveFiles.add(multiRequest.getFilesystemName(memberName));
				originFiles.add(multiRequest.getOriginalFileName(memberName));
				
				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(memberName));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(memberName));
				
			}
			
			
			
			String memberId = multiRequest.getParameter("memberId");
			String memberPwd = multiRequest.getParameter("memberPwd");
			String memberName = multiRequest.getParameter("memberName");
			String memberPhone = multiRequest.getParameter("memberPhone");
			String memberEmail = multiRequest.getParameter("memberEmail");
			String sellerIntroduction = multiRequest.getParameter("sellerIntroduction");
			String sellerCareer = multiRequest.getParameter("sellerCareer");
			
			System.out.println("memberId : " + memberId);
			System.out.println("memberPwd: " + memberPwd);
			System.out.println("memberName: " + memberName);
			System.out.println("memberPhone: " + memberPhone);
			System.out.println("memberEmail: " + memberEmail);
			System.out.println("selleIntroduction: " + sellerIntroduction);
			System.out.println("sellerCareer: " + sellerCareer);
			
			
			Member reqMember = new Member();
			reqMember.setMemberId(memberId);
			reqMember.setMemberPwd(memberPwd);
			reqMember.setMemberName(memberName);
			reqMember.setMemberPhone(memberPhone);
			reqMember.setMemberEmail(memberEmail);
			reqMember.setSellerIntroduction(sellerIntroduction);
			reqMember.setSellerCareer(sellerCareer);


			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			
			for(int i = originFiles.size()-1; i>=0; i--) {
				Attachment img = new Attachment();
				img.setImgFilePath(root);
				img.setOriginName(originFiles.get(i));
				img.setChangeName(saveFiles.get(i));
//				img.setMemberCode(memberCode);
				
				System.out.println();
				System.out.println("getOriginName() : " + img.getOriginName());
				System.out.println("getOriginName() : " + img.getChangeName());
				System.out.println("getChangeName() : " + img.getSellerCertName());
				System.out.println("getMemberCode() : " + img.getMemberCode());
				System.out.println("getImgFilePath() : " + img.getImgFilePath());

				fileList.add(img);
			}	
			
			int result1 = new MemberService().insertSel(reqMember, fileList);
			System.out.println("result1 : "+result1);
			
			//int result2 = new MemberService().insertImg(fileList);
				String page="";
				if(result1 > 0) {
//					response.sendRedirect("index.jsp");
					page="index.jsp";
					response.sendRedirect(page);
					//return;
				}else {
					//실패시 저장된 사진 삭제
					page="index.jsp";
					for(int j = 0; j < saveFiles.size(); j++) {
						//파일시스템에 저장된 이름으로 파일 객체 생성
						File failedFile = new File(root + saveFiles.get(j));
						
						//true false를 리턴함
						failedFile.delete();
					}
					request.setAttribute("msg", "기사 회원가입 실패!");
					request.getRequestDispatcher(page).forward(request, response);
					
				}
				//response.sendRedirect(page);
				//
			
			
			
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
