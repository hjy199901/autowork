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
 * Servlet implementation class Login
 */
@WebServlet("/admin/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//查找数据库是否有用户名和密码一致的数据
		String sqlStr = "select * from user where username=? and password=?";
		String[] params = {username,password};
		ArrayList<HashMap<String, Object>> result = Dao.query(sqlStr, params);
		System.out.println(result);
		if(result.size()>0) {
			System.out.println("登录成功");
			//设置登录状态
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("username", username);
			//显示登录成功信息
			request.setAttribute("httpUrl", "/admin/index");
			request.setAttribute("info", "登录成功！即将跳转至后台首页。");
			request.setAttribute("title", "登录成功");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
			
		}else {
			System.out.println("用户名或密码不对！");
			//显示登录失败页面
			request.setAttribute("httpUrl", "/admin/login");
			request.setAttribute("info", "登录失败！账号或密码不正确！即将跳转至登录页面。");
			request.setAttribute("title", "登录失败");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
		}
		
		
	}

}
