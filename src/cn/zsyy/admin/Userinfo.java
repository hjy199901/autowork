package cn.zsyy.admin;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthScrollBarUI;

import cn.zsyy.db.Dao;

/**
 * Servlet implementation class Userinfo
 */
@WebServlet("/admin/userinfo")
public class Userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户信息
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取表单数据信息
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String brief = request.getParameter("brief");
		String mail = request.getParameter("mail");
		String mobile = request.getParameter("mobile");
		String userType = request.getParameter("userType");
		
		//对表单提交的中文信息进行解码
		//URLEncoder编码，将中文的字符串变成URL地址的中文编码
		//URLDecoder解码，将URL地址的中文编码，解码成字符串
		name = URLDecoder.decode(name);
		sex = URLDecoder.decode(sex);
		brief = URLDecoder.decode(brief);
		System.out.println(name);
		
		//将表单信息更新到数据库
		String sqlStr = "update user set username=?,name=?,password=?,sex=?,age=?,brief=?,mail=?,mobile=?,userType=? where username=?";
		String[] params = {username,name,password,sex,age,brief,mail,mobile,userType,username};
		int execute = Dao.execute(sqlStr,params);
		System.out.println(execute);
		System.out.println(name);
		//用户修改完成
		request.setAttribute("httpUrl", "/admin/edituser?username="+username);
		request.setAttribute("info", "用户信息修改成功，返回至修改页面！");
		request.setAttribute("title", "修改成功");
		request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
	}

}
