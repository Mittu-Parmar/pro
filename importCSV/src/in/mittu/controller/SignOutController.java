package in.mittu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mittu.datasource.DataSource;
import in.mittu.util.StaticResource;

@WebServlet("/SignOutController")
public class SignOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
		StaticResource.indexList=null;
		StaticResource.mainList=null;
		StaticResource.optionList=null;
		StaticResource.menuItemModelList=null;
		
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
