package in.mittu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.mittu.dao.MenuItemsDao;
import in.mittu.models.MenuItemModel;
import in.mittu.util.StaticResource;

@WebServlet("/FinalImportController")
public class FinalImportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MenuItemModel> menuItemModels = new ArrayList<MenuItemModel>();

		for (int i = 0; i < StaticResource.mainList.size(); i++) {
			String row[] = StaticResource.mainList.get(i);
			
			int menuitemCodeIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("menuitem code"));
			int nameIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("name"));
			int positionIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("position"));
			int hotelIdIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("hotel id"));

			if (!( row[menuitemCodeIndex].equals("") || row[nameIndex].equals("") || row[positionIndex].equals("")
					|| row[hotelIdIndex].equals(""))) {

				try {
					int n;
					n = Integer.parseInt(row[hotelIdIndex]);
					n = Integer.parseInt(row[positionIndex]);

					int priceIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("price"));
					if (!row[priceIndex].equals("")) {
						double d = Double.parseDouble(row[priceIndex]);
					}

					MenuItemModel model = new MenuItemModel();

					if (StaticResource.optionList.contains("description")
							&& StaticResource.optionList.contains("available time")
							&& StaticResource.optionList.contains("delivery time")
							&& StaticResource.optionList.contains("keywords")
							&& StaticResource.optionList.contains("image")) {

						int descriptionIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("description"));
						int availableTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("available time"));
						int deliveryTimeTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("delivery time"));
						int keywords = StaticResource.indexList.get(StaticResource.optionList.indexOf("keywords"));
						int imageIndex = StaticResource.indexList.get(StaticResource.optionList.indexOf("image"));

						int x = Integer.parseInt(row[deliveryTimeTimeIndex]);
						model.setDescription(row[descriptionIndex]);
						model.setAvailableTime(row[availableTimeIndex]);
						model.setDeliveryTime(Integer.parseInt(row[deliveryTimeTimeIndex]));
						model.setKeywords(row[keywords]);
						model.setImage(row[imageIndex]);

					} else if (StaticResource.optionList.contains("description")
							&& StaticResource.optionList.contains("available time")
							&& StaticResource.optionList.contains("delivery time")
							&& StaticResource.optionList.contains("keywords")) {

						int descriptionIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("description"));
						int availableTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("available time"));
						int deliveryTimeTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("delivery time"));
						int keywords = StaticResource.indexList.get(StaticResource.optionList.indexOf("keywords"));

						int x = Integer.parseInt(row[deliveryTimeTimeIndex]);

						model.setDescription(row[descriptionIndex]);
						model.setAvailableTime(row[availableTimeIndex]);
						model.setDeliveryTime(Integer.parseInt(row[deliveryTimeTimeIndex]));
						model.setKeywords(row[keywords]);

					} else if (StaticResource.optionList.contains("description")
							&& StaticResource.optionList.contains("available time")
							&& StaticResource.optionList.contains("delivery time")) {

						int descriptionIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("description"));
						int availableTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("available time"));
						int deliveryTimeTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("delivery time"));

						int x = Integer.parseInt(row[deliveryTimeTimeIndex]);

						model.setDescription(row[descriptionIndex]);
						model.setAvailableTime(row[availableTimeIndex]);
						model.setDeliveryTime(Integer.parseInt(row[deliveryTimeTimeIndex]));

					} else if (StaticResource.optionList.contains("description")
							&& StaticResource.optionList.contains("available time")) {

						int descriptionIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("description"));
						int availableTimeIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("available time"));

						model.setDescription(row[descriptionIndex]);
						model.setAvailableTime(row[availableTimeIndex]);

					} else if (StaticResource.optionList.contains("description")) {

						int descriptionIndex = StaticResource.indexList
								.get(StaticResource.optionList.indexOf("description"));

						model.setDescription(row[descriptionIndex]);

					}
					model.setMenuItemCode(row[menuitemCodeIndex]);
					model.setName(row[nameIndex]);
					model.setPosition(Integer.parseInt(row[positionIndex]));
					if (!row[priceIndex].equals("")) {
						model.setPrice(Double.parseDouble(row[priceIndex]));
					}
					model.setHotelId(Integer.parseInt(row[hotelIdIndex]));

					menuItemModels.add(model);

				} catch (Exception e) {
					
				}

			}

		}

		HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");
		MenuItemsDao dao = new MenuItemsDao();
		if (dao.saveItems(menuItemModels,userid)) {
			dao.loadMenuItems();
			request.getRequestDispatcher("HomeView").forward(request, response);

		} else {
			response.getWriter().append("something wnt wrong");
		}

	}

}
