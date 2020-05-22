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
 * Servlet implementation class Register
 */
@WebServlet("/admin/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getContextPath()
		request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		//查询数据是否已存在用户名
		String strSQL= "select username from user where username= ?";
		String[] params = {username};
		ArrayList<HashMap<String, Object>> result = Dao.query(strSQL,params);
		if(result.size()>0) {
			System.out.println("此用户名已经注册过");
			request.setAttribute("title", "注册失败");
			request.setAttribute("info", "注册失败，此用户名已存在。即将跳转至注册页面");
			request.setAttribute("httpUrl","/admin/register");
		}else {
			System.out.println("注册成功");
			//插入用户信息进入表单
			HashMap<String, Object> user = new HashMap<>();
			user.put("username", username);
			user.put("password", password);
			user.put("userType", "admin");
			
			Dao.insertObj("user", user);
			request.setAttribute("title", "注册成功");
			request.setAttribute("info", "注册成功，即将跳转至登录页面");
			request.setAttribute("httpUrl","/admin/login");
		}
		request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
		
	}

}
