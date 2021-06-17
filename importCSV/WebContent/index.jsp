<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Login</title>

    <style>

      *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
      }

      body{
        background: rgb(229, 231, 226);
      }
      .row{
        background-color: white;
        border-radius: 30px;
      }

      img{
        border-top-left-radius: 30px;
        border-bottom-left-radius: 30px;
      }

      .btn1{
        border: none;
        outline: none;
        height: 40px;
        width: 100%;
        background-color: black;
        color: white;
        border-radius: 4px;
        font-weight: bold;
      }
      .btn1:hover{
        background: white;
        border: 1px solid black;
        color: black ;
      }
    </style>

  </head>
  <body>

    <section class="Form my-4 mx-5 justify-content-center">
        <div class="container">
          <div class="row no-gutters">
              <div class="col-lg-6">
                  <img src="img/image.jpg" class="image-fluid" alt="" style="height: 370px;">
              </div>
              <div class="col-lg-6 px-5 pt-4">
                <h1 class="font-weight-bolt py-3">Sign In</h1>
                  <form action="LoginController" method="post"> 
                    <div class="from-row">
                        <div class="col-lg-6">
                          <input type="number" name="id" placeholder='Id "should be number"' class="form-control my-2 p-2 ">
                        </div>
                    </div>
                    <div class="from-row">
                      <div class="col-lg-6">
                        <input type="password" name="password" placeholder="********" class="form-control my-2 p-2">
                      </div>
                    </div>
                    <div class="from-row">
                      <div class="col-lg-6">
                        <button type="submit" class="btn1 mb-3">Login</button>
                      </div>
                    </div> 
                    <p><% 
                    if(request.getAttribute("result")!=null){
                    	out.print(request.getAttribute("result"));
                    	} %>
                    </p>
                    <p>Don't have an account? <a href="register.jsp">Register hear</a></p>
                  </form>
              </div>
          </div>
        </div>
    </section>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>