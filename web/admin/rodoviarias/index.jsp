<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.embarcou.model.Rodoviaria"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
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
                <a href="../../admin/" class="navbar-brand">Embarcou</a>
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
                  <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviaria<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Listar</a></li>
                      <li><a href="nova">Nova</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Viacões<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="../viacoes/">Listar</a></li>
                      <li><a href="../viacoes/nova">Nova</a></li>
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
                                    <h1>Rodoviárias <small>Lista de rodoviárias</small></h1>
                                </div>
                                ${requestScope.insertSuccess}
                                ${requestScope.removeSuccess}
                                <table class="table table-hover text-left table-bordered">
                                    <thead>
                                        <tr>
                                            <th>
                                                #
                                            </th>
                                            <th>
                                                Nome da rodoviária
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
                                        
                                        <c:forEach var="rodoviaria" items="${requestScope.rodoviarias}">
                                            <tr>
                                            <td>${rodoviaria.id}</td>
                                            <td>${rodoviaria.nome}</td>
                                            <td><a class="btn btn-default btn-xs" href="edit?id=${rodoviaria.id}">Editar</a></td>
                                            <td><a class="btn btn-danger btn-xs" href="delete?id=${rodoviaria.id}">Deletar</a></td>
                                            </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                   </div>
            </div>
        </div>
        </div>
        <hr>
        <footer>
            <p>
                Copyright &copy; Company 2013 &middot; Facebook &middot; Twitter &middot; Google+
            </p>
        </footer>

        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap3-typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
    </body>

</html>