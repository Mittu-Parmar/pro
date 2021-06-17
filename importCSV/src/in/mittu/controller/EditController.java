package in.mittu.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.jws.WebParam.Mode;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mittu.dao.MenuItemsDao;
import in.mittu.models.MenuItemModel;
import in.mittu.util.StaticResource;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = Integer.parseInt(request.getParameter("i"));

		if (request.getParameter("op").equals("e")) {
			if (StaticResource.optionList.contains("menuitem code")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("menuitem code"));
				StaticResource.mainList.get(i)[p] = request.getParameter("menuitem code");
			}
			if (StaticResource.optionList.contains("name")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("name"));
				StaticResource.mainList.get(i)[p] = request.getParameter("name");

			}
			if (StaticResource.optionList.contains("description")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("description"));
				StaticResource.mainList.get(i)[p] = request.getParameter("description");

			}
			if (StaticResource.optionList.contains("available time")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("available time"));
				StaticResource.mainList.get(i)[p] = request.getParameter("available time");

			}
			if (StaticResource.optionList.contains("delivery time")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("delivery time"));
				StaticResource.mainList.get(i)[p] = request.getParameter("delivery time");

			}
			if (StaticResource.optionList.contains("keywords")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("keywords"));
				StaticResource.mainList.get(i)[p] = request.getParameter("keywords");

			}
			if (StaticResource.optionList.contains("image")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("image"));
				StaticResource.mainList.get(i)[p] = request.getParameter("image");

			}
			if (StaticResource.optionList.contains("position")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("position"));
				StaticResource.mainList.get(i)[p] = request.getParameter("position");

			}
			if (StaticResource.optionList.contains("price")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("price"));
				StaticResource.mainList.get(i)[p] = request.getParameter("price");

			}
			if (StaticResource.optionList.contains("hotel id")) {
				int p = StaticResource.indexList.get(StaticResource.optionList.indexOf("hotel id"));
				StaticResource.mainList.get(i)[p] = request.getParameter("hotel id");

			}
			request.getRequestDispatcher("final_import.jsp").forward(request, response);
		} else if (request.getParameter("op").equals("he")) {

			MenuItemModel itemModel = new MenuItemModel();
			itemModel.setMenuItemId(StaticResource.menuItemModelList.get(i).getMenuItemId());
			itemModel.setMenuItemCode(request.getParameter("menuitem code"));
			itemModel.setName(request.getParameter("name"));
			itemModel.setDescription(request.getParameter("description"));
			itemModel.setAvailableTime(request.getParameter("available time"));
			itemModel.setDeliveryTime(Integer.parseInt(request.getParameter("delivery time")));
			itemModel.setKeywords(request.getParameter("keywords"));
			itemModel.setImage(request.getParameter("image"));
			itemModel.setPosition(Integer.parseInt(request.getParameter("position")));
			itemModel.setPrice(Double.parseDouble(request.getParameter("price")));
			itemModel.setHotelId(Integer.parseInt(request.getParameter("hotel id")));
			
			HttpSession session = request.getSession();
	        int userid = (Integer) session.getAttribute("userid");
			MenuItemsDao dao=new MenuItemsDao();
				if(dao.update(itemModel,userid)){
					
					StaticResource.menuItemModelList.get(i).setMenuItemCode(request.getParameter("menuitem code"));
					StaticResource.menuItemModelList.get(i).setName(request.getParameter("name"));
					StaticResource.menuItemModelList.get(i).setDescription(request.getParameter("description"));
					StaticResource.menuItemModelList.get(i).setAvailableTime(request.getParameter("available time"));
					StaticResource.menuItemModelList.get(i).setDeliveryTime(Integer.parseInt(request.getParameter("delivery time")));
					StaticResource.menuItemModelList.get(i).setKeywords(request.getParameter("keywords"));
					StaticResource.menuItemModelList.get(i).setImage(request.getParameter("image"));
					StaticResource.menuItemModelList.get(i).setPosition(Integer.parseInt(request.getParameter("position")));
					StaticResource.menuItemModelList.get(i).setPrice(Double.parseDouble(request.getParameter("price")));
					StaticResource.menuItemModelList.get(i).setHotelId(Integer.parseInt(request.getParameter("hotel id")));
					
					StaticResource.menuItemModelList.get(i).setModifiedBy(userid);
					StaticResource.menuItemModelList.get(i).setModifiedOn(new Timestamp(new Date().getTime()));
					
				}else{
					response.getWriter().print("something went wrong");
				}
				request.getRequestDispatcher("HomeView").include(request, response);
			}
		
	}

}
