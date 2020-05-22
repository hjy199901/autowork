package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zsyy.db.Dao;

/**
 * Servlet implementation class Userinfo
 */
@WebServlet("/admin/edituser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户信息
		String username = request.getParameter("username");
		String strSql = "select * from user where username = ?";
		String[] params = {username};
		ArrayList<HashMap<String, Object>> result = Dao.query(strSql, params);
		//返回数组的第一个内容即是用户的map对象
		HashMap<String, Object> user = result.get(0);
		//将usermap对象放置到request
		request.setAttribute("user", user);
		
		
		request.getRequestDispatcher("/admin/userinfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
