<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
	<title>用户登录</title>

    <!-- Bootstrap core CSS -->
	<link href="https://getbootstrap.com/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <!-- Favicons -->
	<link rel="apple-touch-icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
	<link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon.ico">
	<meta name="msapplication-config" content="https://getbootstrap.com/docs/4.5/assets/img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#563d7c">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.5/examples/sign-in/signin.css" rel="stylesheet">
    </head>
 <body class="text-center">
 
	  <form class="form-signin"  method="post" action="users-login-do.jsp">
		<img class="mb-4" src="https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="username" class="sr-only" >Username</label>
		<input type="text" name = "username" id="username" class="form-control" placeholder="Username" value="<%= session.getAttribute("username") %>" required autofocus >
		<label for="password" class="sr-only">Password</label>
		<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
</body>
</html>