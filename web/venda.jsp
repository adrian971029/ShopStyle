<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 15/05/2019
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Venda</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="style/st_venda.css" rel="stylesheet">
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

            <%
                if (request.getSession().getAttribute("controlVenda").equals("button1")) {
            %>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/listrada.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Blusa Listrada</h3>
                        <p class="card-text">Tudo o que você precisa para estar na moda.</p>
                    </div>
                </div>
            </li>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h3>Informações da Compra</h3>
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
                        <form class="form-signin" method="post" action="Venda">
                            <div class="form-group">
                                <label for="usr">Quantidade:</label>
                                <input type="text" class="form-control" id="usr" name="pd1">
                            </div>
                            <p class="card-text">Valor da Unidade: R$20,00</p>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button2">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

            <%
                }
            %>

            <%
                if (request.getSession().getAttribute("controlVenda").equals("button2")) {
            %>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/calcinha.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Kit semana</h3>
                        <p class="card-text">Perfeita para encantar seu parceiro.</p>
                    </div>
                </div>
            </li>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h3>Informações da Compra</h3>
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
                        <form class="form-signin" method="post" action="Venda">
                            <div class="form-group">
                                <label for="usr1">Quantidade:</label>
                                <input type="text" class="form-control" id="usr1" name="pd2">
                            </div>
                            <p class="card-text">Valor da Unidade: R$45,00 </p>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button2">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

            <%
                }
            %>

            <%
                if (request.getSession().getAttribute("controlVenda").equals("button3")) {
            %>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/zorba.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Cueca Infantil</h3>
                        <p class="card-text">Método 100% contraceptivo.</p>
                    </div>
                </div>
            </li>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h3>Informações da Compra</h3>
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

                        <form class="form-signin" method="post" action="Venda">
                            <div class="form-group">
                                <label for="usr2">Quantidade:</label>
                                <input type="text" class="form-control" id="usr2" name="pd3">
                            </div>
                            <p class="card-text">Valor da Unidade: R$12,00</p>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button2">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

            <%
                }
            %>

        </ul>
    </div>
</section>

</body>
</html>
