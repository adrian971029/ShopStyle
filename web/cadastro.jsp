<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 13/05/2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Cadastro</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="style/st_cadastro.css" rel="stylesheet">
</head>
<body>

<nav class="navbar fixed-top navbar-light" style="background-color: #363D9E; color: white">
    <div class="container">
        <a class="navbar-brand" style="color: yellowgreen"  href="#" >ShopStyle</a>
    </div>
</nav>

<div class="container login">

    <form class="form-signin" method="post" action="Cadastro">
        <label for="inputNome" class="sr-only">Nome</label>
        <input id="inputNome" class="form-control" placeholder="Nome" required="" autofocus="" type="text" name="nome">
        <label for="inputEndereço" class="sr-only">Endereço</label>
        <input id="inputEndereço" class="form-control" placeholder="Endereço" required="" autofocus="" type="text" name="endereco">
        <label for="inputCep" class="sr-only">CEP</label>
        <input id="inputCep" class="form-control" placeholder="CEP" required="" autofocus="" type="text" name="cep">
        <label for="inputEmail" class="sr-only">Email</label>
        <input id="inputEmail" class="form-control" placeholder="Email" required="" autofocus="" type="text" name="email">
        <label for="inputPassword" class="sr-only">Senha</label>
        <input id="inputPassword" class="form-control" placeholder="Senha" required="" type="password" name="password">
        <label for="inputConfirmarSenha" class="sr-only">Confirma_Senha</label>
        <input id="inputConfirmarSenha" class="form-control ultimo" placeholder="Confirmar Senha" required="" type="password" name="cfPassword">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>

    </form>
</div>
</body>
</html>