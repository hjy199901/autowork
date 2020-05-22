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
 * Servlet implementation class Adduser
 */
@WebServlet("/admin/adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/admin/adduser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
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
		//判断用户是否已经存在
		String sqlStr = "select * from user where username=?";
		String[] params = {username};
		ArrayList<HashMap<String, Object>> result = Dao.query(sqlStr,params);
		if(result.size()==0) {
			HashMap<String, Object> user = new HashMap<>();
			user.put("username", username);
			user.put("name", name);
			user.put("password", password);
			user.put("sex", sex);
			user.put("age", age);
			user.put("brief", brief);
			user.put("mail", mail);
			user.put("mobile", mobile);
			user.put("userType",userType);
			int insertObj = Dao.insertObj("user", user);
			System.out.println(insertObj);
			//告知用户添加成功
			request.setAttribute("httpUrl", "/admin/userlist");
			request.setAttribute("info", "用户添加成功，即将返回用户列表页");
			request.setAttribute("title", "添加成功");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
		}else if(result.get(0).get("isDelete")!=null&&result.get(0).get("isDelete").equals("true")) {
			//将表单信息更新到数据库
			sqlStr = "update user set username=?,name=?,password=?,sex=?,age=?,brief=?,mail=?,mobile=?,userType=? where username=?";
			String[] params1 = {username,name,password,sex,age,brief,mail,mobile,userType,username};
			int execute = Dao.execute(sqlStr,params1);
			
		}else {
			//告知用户添加失败
			request.setAttribute("httpUrl", "/admin/userlist");
			request.setAttribute("info", "此用户名已使用，用户添加失败，即将返回用户列表页");
			request.setAttribute("title", "添加失败");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
			
		}
		
		
		
	}

}
