<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 03/06/2019
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Comprovante</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="style/st_comprovante.css" rel="stylesheet">
</head>
<body>

<nav class="navbar fixed-top navbar-light" style="background-color: #363D9E; color: white">
    <div class="container">
        <a class="navbar-brand" style="color: yellowgreen"  href="#" >ShopStyle</a>
        <a>Usuario: <%= request.getSession().getAttribute("user")%></a>
    </div>
</nav>

<section class="col-12 portafolio">
    <h2 class="featured_work mt-5 mb-5"></h2>

    <div class="portafolio-showcase">
        <ul class="portafolio__lista row">

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h3>Comprovante da Compra</h3>
                        <p class="card-text">Usuario: <%= request.getSession().getAttribute("user")%></p>
                        <p class="card-text">Quantidade comprada: <%= request.getSession().getAttribute("qtd")%></p>
                        <p class="card-text">Valor total: <%= request.getSession().getAttribute("vlr")%></p>
                        <p class="card-text">Data de compra: <%= request.getSession().getAttribute("dt")%></p>
                        <p class="card-text">Hora de compra: <%= request.getSession().getAttribute("hr")%></p>
                        <form class="form-signin" method="post" action="Comprovante">
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button2">Seguir comprando</button>
                        </form>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</section>

</body>
</html>
