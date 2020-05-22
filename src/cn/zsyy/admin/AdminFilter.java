package cn.zsyy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.zsyy.db.Dao;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//���·����Ϣ
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		if(servletPath.equals("/admin/register")||servletPath.equals("/admin/login")){
			chain.doFilter(request, response);
		}
		else {
			HttpSession session = req.getSession();
			if(session.getAttribute("username")!=null) {
				String username = (String)session.getAttribute("username");
				String sql = "select * from user where username = ?";
				String[] params = {username};
				ArrayList<HashMap<String, Object>> res = Dao.query(sql, params);
				HashMap<String, Object> user = res.get(0);
				if(user.get("usertype").equals("admin")) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("httpUrl", "/admin/login");
					req.setAttribute("info", "��û��Ȩ�ޣ�����ϵ������Ա��������ת����¼ҳ�档");
					req.setAttribute("title", "����ʧ�ܣ�");
					req.getRequestDispatcher("/admin/info.jsp").forward(req, response);
				}
			}else {
				//���û�е�¼����ת����¼ҳ��
				req.setAttribute("httpUrl", "/admin/login");
				req.setAttribute("info", "����δ��¼��������ת����¼ҳ�档");
				req.setAttribute("title", "δ��¼��");
				req.getRequestDispatcher("/admin/info.jsp").forward(req, response);;
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
