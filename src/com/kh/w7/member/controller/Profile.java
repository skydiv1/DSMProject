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

import com.kh.w7.common.MyFileRenamePolicy;
import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Img;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile.me")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*100;
			
			String root = request.getSession().getServletContext().getRealPath("/upload/");
			/*String filePath = root + "GisaJoinImg/";*/
			System.out.println("root : "+root);
			
			MultipartRequest multiRequest
			 = new MultipartRequest(request, root, maxSize,
					 "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration files = multiRequest.getFileNames();//input type=file
			
			while(files.hasMoreElements()) {
				String memberName = (String) files.nextElement();
				
				System.out.println();
				System.out.println("name  : " + memberName);
				
				saveFiles.add(multiRequest.getFilesystemName(memberName));
				originFiles.add(multiRequest.getOriginalFileName(memberName));
				
				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(memberName));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(memberName));
				
			}
			
			String memberId = multiRequest.getParameter("memberId");
			System.out.println("memberId : " + memberId);
			

			ArrayList<Img> fileList = new ArrayList<Img>();
			
			
			for(int i = originFiles.size()-1; i>=0; i--) {
				Img img = new Img();
				img.setImg_filepath(root);
				img.setOriginname(originFiles.get(i));
				img.setChangename(saveFiles.get(i));
				
				String member_code = new MemberService().findmemberCode(member_code);
				img.setMember_code(member_code);
				
				if(i==1) {
					img.setI_div("프로필 사진");
				}else {
					img.setI_div("신분증");
				}
				
				
				

				
				fileList.add(img);
			}	
				int result = new MemberService().insertImg(fileList);
				String page="";
				if(result > 0) {
					page="/dsm/index.jsp";
					response.sendRedirect(page);
					return;
				}else {
					//실패시 저장된 사진 삭제
					page="views/common/errorPage.jsp";
					for(int j = 0; j < saveFiles.size(); j++) {
						//파일시스템에 저장된 이름으로 파일 객체 생성
						File failedFile = new File(root + saveFiles.get(j));
						
						//true false를 리턴함
						failedFile.delete();
					}
					request.setAttribute("msg", "사진게시판 등록 실패!");
					request.getRequestDispatcher(page).forward(request, response);
					
				}
			
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
