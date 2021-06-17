<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.mittu.util.StaticResource"%>
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
				<ul class="nav navbar-nav">
					<li class="active"><a href="">Home</a></li>
				</ul>
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="SignOutController">logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container" style="min-height: 500px;">
		<div class="container" style="padding: 10px 10px;">
			<h1>Edit CSV Data</h1>
			<div class="well">
				<form class="form-inline" action="EditController">
					<div class="content" padding: 10px>
						<div class="row">
							<table class=''>

								
								<%
									if(request.getParameter("op").equals("e")){
								%>
								
								<input type="hidden" name="op"
									value="e">
																		
								<input type="hidden" name="i"
									value="<%=request.getAttribute("i")%>">

								<%
									if (StaticResource.optionList.contains("menuitem code")) {
								%>
								<div class="from-row">
									<div class="col text-center">
										<label>menuitem code<label> <input type="text"
												name="menuitem code" class="form-control my-2 p-2">
									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("name")) {
								%>
								<div class="from-row">
									<div class="col text-center">
										<label>name</label> <input type="text" name="name"
											class="form-control my-2 p-2">
									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("description")) {
								%>

								<div class="from-row">
									<div class="col text-center">
										<label>description</label> <input type="text"
											name="description" class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("available time")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>available time</label> <input type="text"
											name="available time" class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("delivery time")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>delivery time</label> <input type="number"
											name="delivery time" class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("keywords")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>keywords</label> <input type="text" name="keywords"
											class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("image")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>image</label> <input type="text" name="image"
											class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("position")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>position</label> <input type="number" name="position"
											class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("price")) {
								%>


								<div class="from-row">
									<div class="col text-center">
										<label>price</label> <input type="text" name="price"
											class="form-control my-2 p-2">

									</div>
								</div>
								<%
									}
									if (StaticResource.optionList.contains("hotel id")) {
								%>

								<div class="from-row">
									<div class="col text-center">
										<label>hotel id</label> <input type="number" name="hotel id"
											class="form-control my-2 p-2">
									</div>
								</div>
								<%
									}
									}else{
										
										String i=(String)request.getAttribute("i");
										int index=Integer.parseInt(i); 
								%>
								
								<input type="hidden" name="op"
									value="he">
								
								<input type="hidden" name="i"
									value="<%=index%>">


								<div class="from-row">
									<div class="col text-center">
										<label>Menu item id <label>  <label> : <%= StaticResource.menuItemModelList.get(index).getMenuItemId() %><label>
									</div>
								</div>


								
								<div class="from-row">
									<div class="col text-center">
										<label>menuitem code<label> <input type="text" 
												value="<%= StaticResource.menuItemModelList.get(index).getMenuItemCode() %>" name="menuitem code" class="form-control my-2 p-2">
									</div>
								</div>
								
								<div class="from-row">
									<div class="col text-center">
										<label>name</label> <input type="text" name="name"
										value="<%= StaticResource.menuItemModelList.get(index).getName() %>"	class="form-control my-2 p-2">
									</div>
								</div>
								


								<div class="from-row">
									<div class="col text-center">
										<label>description</label> <input type="text"
											value="<%= StaticResource.menuItemModelList.get(index).getDescription() %>" name="description" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>available time</label> <input type="text"
											value="<%= StaticResource.menuItemModelList.get(index).getAvailableTime() %>" name="available time" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>delivery time</label> <input type="number"
											value="<%= StaticResource.menuItemModelList.get(index).getDeliveryTime() %>" name="delivery time" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>keywords</label> <input type="text" name="keywords"
											value="<%= StaticResource.menuItemModelList.get(index).getKeywords() %>" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>image</label> <input type="text" name="image"
											value="<%= StaticResource.menuItemModelList.get(index).getImage() %>" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>position</label> <input type="number" name="position"
											value="<%= StaticResource.menuItemModelList.get(index).getPosition() %>" class="form-control my-2 p-2">

									</div>
								</div>



								<div class="from-row">
									<div class="col text-center">
										<label>price</label> <input type="text" name="price"
											value="<%= StaticResource.menuItemModelList.get(index).getPrice() %>" class="form-control my-2 p-2">

									</div>
								</div>


								<div class="from-row">
									<div class="col text-center">
										<label>hotel id</label> <input type="number" name="hotel id"
											value="<%= StaticResource.menuItemModelList.get(index).getHotelId() %>" class="form-control my-2 p-2">
									</div>
								</div>
								<%
									}
								%>

							</table>
						</div>
					</div>
					<br>
					<button type='submit' id='uploadFile'
						class='btn btn-primary center-block'>Save</button>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>

</html>
