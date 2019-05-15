<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 13/05/2019
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Bemvindo</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="style/st_welcome.css" rel="stylesheet">

</head>
<body>

<%
    if (request != null) {
        if (request.getSession().getAttribute("venda") != null) {
            if (request.getSession().getAttribute("venda").equals("ok")) {
                response.setContentType("text/html");
                PrintWriter pw=response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Compra realizada!');");
                pw.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");
                rd.include(request, response);
            }
        }
    }
%>

<nav class="navbar fixed-top navbar-light" style="background-color: #363D9E; color: white">
    <div class="container">
        <a class="navbar-brand" style="color: yellowgreen"  href="#" >ShopStyle</a>
        <a>Usuario: <%= request.getSession().getAttribute("user")%></a></a>
    </div>
</nav>

<section class="col-12 portafolio">
    <h2 class="featured_work mt-5 mb-5">Produtos</h2>

    <div class="portafolio-showcase">
        <ul class="portafolio__lista row">

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/listrada.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Blusa Listrada</h3>
                        <p class="card-text">Tudo o que você precisa para estar na moda.</p>
                        <form class="form-signin" method="post" action="Welcome">
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button1">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

            <li class="portafolio__lista_cont col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/calcinha.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Kit semana</h3>
                        <p class="card-text">Perfeita para encantar seu parceiro.</p>
                        <form class="form-signin" method="post" action="Welcome">
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button2">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

            <li class="portafolio__lista_contcol-12 col-sm-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="images/zorba.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h3>Cueca Infantil</h3>
                        <p class="card-text">Método 100% contraceptivo.</p>
                        <form class="form-signin" method="post" action="Welcome">
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="button3">Comprar</button>
                        </form>
                    </div>
                </div>
            </li>

        </ul>
    </div>
</section>


</body>
</html>
