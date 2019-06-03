<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 03/06/2019
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Produto</title>
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

    <form class="form-signin" method="post" action="Produto">
        <label for="inputNome" class="sr-only">Nome do produto</label>
        <input id="inputNome" class="form-control" placeholder="Nome do produto" required="" autofocus="" type="text" name="nome">
        <label for="inputPreco" class="sr-only">Preco do produto</label>
        <input id="inputPreco" class="form-control" placeholder="Preço do produto" required="" autofocus="" type="text" name="preco">
        <label for="inputQtd" class="sr-only">Quantidade</label>
        <input id="inputQtd" class="form-control" placeholder="Quantidade" required="" autofocus="" type="text" name="quantidade">
        <label for="inputDescricao" class="sr-only">Descricao</label>
        <input id="inputDescricao" class="form-control" placeholder="Descrição" required="" autofocus="" type="text" name="descricao">
        <p class="card-text">Selecione o tamanho:</p>
        <div class="radio">
            <label><input type="radio" name="optradio" checked>Tamanho P</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="optradio">Tamanho M</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="optradio">Tamanho G</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
    </form>
</div>

</body>
</html>
