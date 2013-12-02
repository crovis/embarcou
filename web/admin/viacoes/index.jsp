<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.embarcou.model.Viacao"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap core CSS -->
        <link href="${ pageContext.request.contextPath }/css/bootstrap.css" type="text/css"  rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/one-page-wonder.css" type="text/css" rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/datepicker.css" type="text/css" rel="stylesheet">

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <title>Embarcou - O melhor preço de passagem</title>
    </head>
    <body>
        <div class="container">
        <header class="navbar navbar-default navbar-fixed-top bs-docs-nav" role="banner">
            <div class="container">
              <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a href="../../admin" class="navbar-brand">Embarcou</a>
              </div>
              <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                <ul class="nav navbar-nav">
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trechos<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="../trechos/">Listar</a></li>
                      <li><a href="../trechos/nova">Nova</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviaria<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="../rodoviarias/">Listar</a></li>
                      <li><a href="../rodoviarias/nova">Nova</a></li>
                    </ul>
                  </li>
                  <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Viacões<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Listar</a></li>
                      <li><a href="nova">Nova</a></li>
                    </ul>
                  </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li>
                    <a href="ajuda">Ajuda</a>
                  </li>
                </ul>
              </nav>
            </div>
        </header>
        <div class="header-image">
            <div class="headline">
                <div class="container">
                    <div class="row">
                        <div class="page-header text-left">
                            <h1>Viação - <small>Lista de rodoviárias</small></h1>
                        </div>
                        ${requestScope.removeSucces}
                        <table class="table table-hover table-bordered">
                                    <thead>
                                        <tr>
                                            <th>
                                                #
                                            </th>
                                            <th>
                                                CNPJ
                                            </th>
                                            <th>
                                                Nome da viação
                                            </th>
                                            <th>
                                                Telefone
                                            </th>
                                            <th>
                                                Site
                                            </th>
                                            <th>
                                                Logo
                                            </th>
                                            <th>
                                                Editar
                                            </th>
                                            <th>
                                                Apagar
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="viacao" items="${requestScope.viacoes}">
                                            <tr>
                                                <td>${viacao.id}</td>
                                                <td>${viacao.cnpj}</td>
                                                <td>${viacao.nome}</td>
                                                <td>${viacao.telefone}</td>
                                                <td><a href="${viacao.site}">Site</a></td>
                                                <td>${viacao.logo}</td>
                                                <td><a class="btn btn-default btn-xs" href="edit?id=${viacao.id}">Editar</a></td>
                                                <td><a class="btn btn-danger btn-xs" href="delete?id=${viacao.id}">Apagar</a></td>
                                            </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- /header-image -->
            <hr>
            <!-- FOOTER -->
            <footer>
                <p>
                    Copyright &copy; Company 2013 &middot; Facebook &middot; Twitter &middot; Google+
                </p>
            </footer>


        </div>

        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap3-typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
    </body>

</html>