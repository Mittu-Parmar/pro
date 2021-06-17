<%@page import="org.eclipse.jdt.internal.compiler.batch.Main"%>
<%@page import="in.mittu.util.StaticResource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<title>Read CSV File</title>
</head>

<body class="">
	<div role="navigation" class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">CSV reader</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="HomeView">Home</a></li>
				</ul>
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="SignOutController">logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container" style="min-height:500px;">
		<div class="container" style="padding:10px 10px;">
			<h1>Import CSV File</h1>
			<div class="well">
				<div class="content" style="overflow: scroll; padding: 10px">
					<div class="row">
                        <table class='table table-striped table-bordered table-hover'>
                            <tr>
                            <%
                            	for(int i=0;i<StaticResource.optionList.size();i++){
                            		out.print("<th scope='col'>"+StaticResource.optionList.get(i)+"</th>");	
                            	}
                            %>
                            </tr>
							<%
							for(int i=0;i<StaticResource.mainList.size();i++){
								out.print("<tr>");
								String row[]=StaticResource.mainList.get(i);
								for(int j=0;j<StaticResource.optionList.size();j++){
									
									int menuitemCodeIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("menuitem code"));
									int nameIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("name"));
									int positionIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("position"));
									int hotelIdIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("hotel id"));
									
									if(row[menuitemCodeIndex].equals("") || row[nameIndex].equals("") || row[positionIndex].equals("") || row[hotelIdIndex].equals("")){
		
										out.print("<td class='bg-danger'>"+row[StaticResource.indexList.get(j)]+"</td>");	
									}else{
										
										try{
											
											 int n;
											 n=Integer.parseInt(row[hotelIdIndex]);
											 n=Integer.parseInt(row[positionIndex]);
											 
											 int priceIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("price"));
											 if(!row[priceIndex].equals("")){
												 double d=Double.parseDouble(row[priceIndex]);	 
											 }
											 
											 if(StaticResource.optionList.contains("delivery time")){
												 int deliveryTimeTimeIndex=StaticResource.indexList.get(StaticResource.optionList.indexOf("delivery time"));
												 n=Integer.parseInt(row[deliveryTimeTimeIndex]);
											 }
											 
											 
											out.print("<td>"+row[StaticResource.indexList.get(j)]+"</td>");
										}catch(NumberFormatException e){
											out.print("<td class='bg-danger'>"+row[StaticResource.indexList.get(j)]+"</td>");
										}
											
									}
                            	}

								%>
								<td>
                                	<a href="EditDeleteControler?op=e&i=<%=i%>" ><button type='submit' id='uploadFile' class='btn btn-sm btn-primary'>Edit</button></a>
                                	<a href="EditDeleteControler?op=d&i=<%=i%>" ><button type='submit' id='uploadFile' class='btn btn-sm btn-danger'>Delete</button></a>
                                </td>
								</tr>
								<%
                        	}
                            %>
                        </table>
                    </div>
				</div>
                <br>
                <a href="FinalImportController">
                <button type='submit' id='uploadFile' class='btn btn-primary center-block'>Save</button>
                </a>
			</div>
		</div>
		</div>
	</div>
</body>

</html>
