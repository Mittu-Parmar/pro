package in.mittu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mittu.dao.MenuItemsDao;
import in.mittu.dao.UserDao;
import in.mittu.models.User;
import in.mittu.services.LoginRegisterService;
import in.mittu.util.StaticResource;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		if (id.isEmpty() || password.isEmpty()) {			
			
			request.setAttribute("result", "Please fill empty field");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else{
			
			User user=new User(Integer.parseInt(id),password);
			LoginRegisterService service=new LoginRegisterService();
			int i=service.login(user);
			
			if(i==UserDao.AlERADY_EXIST){
				
				HttpSession session=request.getSession();  
		        session.setAttribute("userid",Integer.parseInt(id));
				
				MenuItemsDao dao=new MenuItemsDao();
				dao.loadMenuItems();
				request.getRequestDispatcher("HomeView").forward(request, response);
				
			}else if(i==UserDao.NOT_EXIST){
				
				request.setAttribute("result", "User not exist");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("result", "Something went wrong");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
