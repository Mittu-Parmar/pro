package in.mittu.controller;

import java.io.IOException;
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

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		
		if (id.isEmpty() || password.isEmpty()) {
			request.setAttribute("result", "Please fill empty field");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else if(!password.equals(repassword)){
			request.setAttribute("result", "Password is not maching");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			
			LoginRegisterService service=new LoginRegisterService();
			int i=service.register(new User(Integer.parseInt(id),password));
			if(i==UserDao.INSERTED){
				
				HttpSession session=request.getSession();  
		        session.setAttribute("userid",Integer.parseInt(id));
				
				MenuItemsDao dao=new MenuItemsDao();
				dao.loadMenuItems();
				request.getRequestDispatcher("HomeView").forward(request, response);
				
			}else if(i==UserDao.AlERADY_EXIST){
				request.setAttribute("result", "User id alerady exist");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else{
				request.setAttribute("result", "Something went wrong");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
}
