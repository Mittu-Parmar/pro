<%@page import="in.mittu.models.MenuItemModel"%>
<%@page import="java.util.List"%>
<%@page import="in.mittu.util.StaticResource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Read CSV File</title>
</head>

<body class="">
	<div role="navigation" class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button data-target=".navbar-collapse" data-toggle="collapse"
					class="navbar-toggle" type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">CSV reader</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="import.html">Import CSV</a></li>
					<li><a href="SignOutController">logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container" style="min-height: 500px;">
		<div class="container" style="padding: 10px 10px;">
			<h1>Home Page</h1>
			<div class="well">
				<div class="content" style="overflow: scroll; padding: 10px">
					<div class="row">

						<%
							if (StaticResource.menuItemModelList.size()>0) {
						%>

						<table class='table table-striped table-bordered table-hover'>
							<tr>
								<th scope='col'>Menuitem Id</th>
								<th scope='col'>Menuitem Code</th>
								<th scope='col'>Name</th>
								<th scope='col'>Description</th>
								<th scope='col'>Available Time</th>
								<th scope='col'>Delivery Time</th>
								<th scope='col'>Keywords</th>
								<th scope='col'>Image</th>
								<th scope='col'>Position</th>
								<th scope='col'>Price</th>
								<th scope='col'>Hotel Id</th>
								<th scope='col'>created By</th>
								<th scope='col'>created On</th>
								<th scope='col'>modified By</th>
								<th scope='col'>modified On</th>
							</tr>

							<%
								for (int i = 0; i < StaticResource.menuItemModelList.size(); i++) {
										out.print("<tr>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getMenuItemId() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getMenuItemCode() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getName() + "</td>");
										if(StaticResource.menuItemModelList.get(i).getDescription()!=null){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getDescription() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										if(StaticResource.menuItemModelList.get(i).getAvailableTime()!=null){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getAvailableTime() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										if(StaticResource.menuItemModelList.get(i).getDeliveryTime()!=0){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getDeliveryTime() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										if(StaticResource.menuItemModelList.get(i).getKeywords()!=null){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getKeywords() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										if(StaticResource.menuItemModelList.get(i).getImage()!=null){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getImage() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getPosition() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getPrice() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getHotelId() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getCreatedBy() + "</td>");
										out.print("<td>" + StaticResource.menuItemModelList.get(i).getCreatedOn() + "</td>");
										if(StaticResource.menuItemModelList.get(i).getModifiedBy()!=0){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getModifiedBy() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										if(StaticResource.menuItemModelList.get(i).getModifiedOn()!=null){
											out.print("<td>" + StaticResource.menuItemModelList.get(i).getModifiedOn() + "</td>");	
										}else{
											out.print("<td><id>");
										}
										
										
									%>
										<td><a href="EditDeleteControler?op=he&i=<%=i%>"><button
										type='submit' id='uploadFile' class='btn btn-sm btn-primary'>Edit</button></a>
										<a href="EditDeleteControler?op=hd&i=<%=i%>"><button type='submit'
										id='uploadFile' class='btn btn-sm btn-danger'>Delete</button></a>
										</tr>
									<%
										}
									%>
								</td>
						</table>
						<%
							}
						%>
					</div>
				</div>
				<br>
			</div>
		</div>
	</div>
	</div>
</body>

</html>