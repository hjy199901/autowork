package cn.zsyy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zsyy.db.Dao;

/**
 * Servlet implementation class Deleteuser
 */
@WebServlet("/admin/deluser")
public class Deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String  sqlStr = "update user set isdelete='true' where id = ?";
		String[] params = {id};
		int execute = Dao.execute(sqlStr, params);
		//��ʾɾ���ɹ���Ϣ
		request.setAttribute("httpUrl", "/admin/userlist");
		request.setAttribute("info", "ɾ���ɹ���������ת���û��б�ҳ��");
		request.setAttribute("title", "ɾ���ɹ�");
		request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String[] ids = request.getParameterValues("ids[]");

		String sqlStr = "update user set isdelete='true' where id in (";
		for(int i=0;i<ids.length;i++) {
			if(i==(ids.length-1)) {
				sqlStr = sqlStr+ids[i]+")";
			}else {
				sqlStr = sqlStr+ids[i]+",";
			}
		}
		int execute = Dao.execute(sqlStr);
		System.out.println(execute);
		response.getWriter().println("piliang delete success");
	}

}