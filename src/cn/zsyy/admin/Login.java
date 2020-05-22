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
		//��ȡ���ύ���û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//�������ݿ��Ƿ����û���������һ�µ�����
		String sqlStr = "select * from user where username=? and password=?";
		String[] params = {username,password};
		ArrayList<HashMap<String, Object>> result = Dao.query(sqlStr, params);
		System.out.println(result);
		if(result.size()>0) {
			System.out.println("��¼�ɹ�");
			//���õ�¼״̬
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("username", username);
			//��ʾ��¼�ɹ���Ϣ
			request.setAttribute("httpUrl", "/admin/index");
			request.setAttribute("info", "��¼�ɹ���������ת����̨��ҳ��");
			request.setAttribute("title", "��¼�ɹ�");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
			
		}else {
			System.out.println("�û��������벻�ԣ�");
			//��ʾ��¼ʧ��ҳ��
			request.setAttribute("httpUrl", "/admin/login");
			request.setAttribute("info", "��¼ʧ�ܣ��˺Ż����벻��ȷ��������ת����¼ҳ�档");
			request.setAttribute("title", "��¼ʧ��");
			request.getRequestDispatcher("/admin/info.jsp").forward(request, response);
		}
		
		
	}

}
