package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zsyy.db.Dao;

/**
 * Servlet implementation class Userlist
 */
@WebServlet("/admin/userlist")
public class Userlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���е��û�,��ȡ���½�����10���û�
		String page = request.getParameter("page");
		//���Ĭ�ϻ�ȡ�����ڼ�ҳ�Ĳ�������ôĬ�ϴ򿪵�һҳ
		if(page==null) {
			page = "1";
		}
		String strSql = null;
		String strSql1 = null;
		int num = (Integer.parseInt(page) -1)*5;
		//��ȡ�鿴���û�����
		String userType = request.getParameter("userType");
		if(userType==null) {
			userType = "all";
		}
			
		//��ȡģ�����ҵ������û���ģ�����ҵĹؼ���
		String likeuser = request.getParameter("likeuser");
		System.out.println(likeuser);
		System.out.println(likeuser);
		System.out.println(likeuser);
		System.out.println(likeuser);
		System.out.println(likeuser);
		System.out.println(userType);
		if(likeuser==null&&!userType.equals("all")) {
			//û��ģ�������κ��û�
			strSql = "select * from user where isdelete is NULL and userType='"+userType +"' order by id desc limit "+num+",5";
			strSql1 = "select * from user where isdelete is NULL and userType='"+userType +"'";
		}else if(likeuser!=null&&!userType.equals("all")) {
			strSql = "select * from user where isdelete is NULL and userType='"+userType +"' and username like '%"+likeuser+"%' order by id desc limit "+num+",5";
			strSql1 = "select * from user where isdelete is NULL and userType='"+userType +"' and username like '%"+likeuser+"%'";
		}else if(likeuser!=null&&userType.equals("all")) {
			strSql = "select * from user where isdelete is NULL  and username like '%"+likeuser+"%' order by id desc limit "+num+",5";
			strSql1 = "select * from user where isdelete is NULL and username like '%"+likeuser+"%'";
		}else {
			strSql = "select * from user where isdelete is NULL order by id desc limit "+num+",5";
			strSql1 = "select * from user where isdelete is NULL";
		}
		
		
		
		
		
		
		//�û��б��ȡ
		//String strSql = "select * from user where isdelete is NULL order by id desc limit "+num+",5";
		System.out.println(strSql);
		ArrayList<HashMap<String, Object>> userList = Dao.query(strSql);
		request.setAttribute("userlist", userList);
		request.setAttribute("page", page);
		//��ȡ���û���
		//String strSql1 = "select id from user where isdelete is NULL";
		ArrayList<HashMap<String, Object>> allList = Dao.query(strSql1);
		int allNum = allList.size();
		//System.out.println(allNum);
		//System.out.println(Math.ceil((double)allNum/5));
		int allpage =  (int) Math.ceil((double)allNum/5);
		
		//System.out.println(allpage);
		
		request.setAttribute("allNum", allNum);
		request.setAttribute("allpage", allpage);
		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
