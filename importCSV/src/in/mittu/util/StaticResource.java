package in.mittu.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Part;

import com.opencsv.CSVReader;

import in.mittu.models.MenuItemModel;

public class StaticResource {

	public static List<String[]> mainList=null;
	public static List<String> optionList=null;
	public static List<Integer> indexList=null;
	
	public static List<MenuItemModel> menuItemModelList=null;
	
}
