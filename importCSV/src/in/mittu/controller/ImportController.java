package in.mittu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.opencsv.CSVReader;

import in.mittu.models.MenuItemModel;
import in.mittu.util.StaticResource;

@MultipartConfig
@WebServlet("/ImportController")
public class ImportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			if (fileName.substring(i + 1).equals("csv")) {

				////////// fetch data////////

				InputStream fileContent = filePart.getInputStream();
				Reader in = new InputStreamReader(fileContent);
				CSVReader reader;
				Iterator<String[]> iterator;
				reader = new CSVReader(new InputStreamReader(fileContent));
				iterator = reader.iterator();

				if (iterator.hasNext()) {

					List<String[]> mainList = new ArrayList<String[]>();

					while (iterator.hasNext()) {
						mainList.add(iterator.next());
					}

					////////// check dublicate or less 5////////

					List <String>optionList = new ArrayList();
					List <Integer>indexList = new ArrayList();
					

					for (int j = 0; j < mainList.get(0).length; j++) {
						if (!request.getParameter("option" + j).equals("Select Option")) {
							
							if(optionList.contains(request.getParameter("option" + j).toString())){
//								System.out.println("options should not be same");
								response.setContentType("text/html");
								response.getWriter().print("options should not be same");
								request.getRequestDispatcher("import.html").include(request, response);
								
							}else{
								optionList.add(request.getParameter("option" + j));
								indexList.add(j);
							}
						}
					}

					if (optionList.size() >= 0 && optionList.contains("menuitem code") && optionList.contains("name")
							&& optionList.contains("position") && optionList.contains("price") && optionList.contains("hotel id")) {

						////////// Fetch and put into StaticResource////////

						if(StaticResource.mainList!=null){
							
							StaticResource.indexList.clear();
							StaticResource.optionList.clear();
							StaticResource.mainList.clear();
						}
												
						StaticResource.indexList=indexList;
						StaticResource.optionList=optionList;
						StaticResource.mainList=mainList;
							
						request.getRequestDispatcher("final_import.jsp").forward(request, response);
						
						////////// Fetch and put into StaticResource////////

					} else {
						response.setContentType("text/html");
						response.getWriter().print("menuitem code,name,position,price,hotel id    must be selected");
						request.getRequestDispatcher("import.html").include(request, response);
					}

					////////// check dublicate or less 5////////

				} else {
					response.setContentType("text/html");
					response.getWriter().print("No data in csv file");
					request.getRequestDispatcher("import.html").include(request, response);
				}

				in.close();

				//////// fetch data////////

			} else {
				PrintWriter out = response.getWriter();
				out.print("<p>File type should be CSV</p>");
				request.getRequestDispatcher("import.html").include(request, response);
			}
		}
	}

}
