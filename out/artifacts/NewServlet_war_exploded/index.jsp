<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 13/05/2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>ShopStyle</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="style/st_login.css" rel="stylesheet">
</head>
<body>
<nav class="navbar fixed-top navbar-light" style="background-color: #363D9E;">
    <div class="container">
        <a class="navbar-brand" style="color: yellowgreen"  href="#" >ShopStyle</a>
    </div>
</nav>

<div class="container login">

    <form class="form-signin" method="post" action="Login">
        <h2 class="form-signin-heading"><img src="images/logo.png"/></h2>
        <label for="inputUser" class="sr-only">Usuário</label>
        <input id="inputUser" class="form-control" placeholder="Usuário" required="" autofocus="" type="text" name="user">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Senha" required="" type="password" name="password">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>

        <div class="row">
            <div class="col-md-6"><a class="btn btn-link" href="#" role="button">Esqueci a senha</a></div>
            <div class="col-md-6"><a class="btn btn-link pull-right " href="cadastro.jsp" role="button">Registrar</a></div>
        </div>
    </form>
</body>
</html>
