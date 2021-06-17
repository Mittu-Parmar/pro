package in.mittu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mittu.dao.MenuItemsDao;
import in.mittu.util.StaticResource;

@WebServlet("/EditDeleteControler")
public class EditDeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String i=request.getParameter("i");
		if(request.getParameter("op").equals("d")){
			StaticResource.mainList.remove(Integer.parseInt(i));
			if(StaticResource.mainList.size()==0){
				request.getRequestDispatcher("import.html").forward(request, response);
			}else{
				request.getRequestDispatcher("final_import.jsp").forward(request, response);
			}
		}else if(request.getParameter("op").equals("e")){
			request.setAttribute("i", i);
			request.setAttribute("op", "e");
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}else if(request.getParameter("op").equals("hd")){
			MenuItemsDao dao=new MenuItemsDao();
			
			if(dao.delete(StaticResource.menuItemModelList.get(Integer.parseInt(i)).getMenuItemId())){
				StaticResource.menuItemModelList.remove(Integer.parseInt(i));
				request.getRequestDispatcher("HomeView").forward(request, response);
			}else{
				response.getWriter().print("Some thing went wrong");
				request.getRequestDispatcher("HomeView").forward(request, response);
			}
		}else if(request.getParameter("op").equals("he")){
			request.setAttribute("i", i);
			request.setAttribute("op", "he");
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}

}
