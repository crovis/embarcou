<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <a href="../" class="navbar-brand">Embarcou</a>
                    </div>
                    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                        <ul class="nav navbar-nav">
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trechos<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../trechos/">Listar</a></li>
                                    <li><a href="#">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviária<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../rodoviarias/">Listar</a></li>
                                    <li><a href="../rodoviarias/nova">Nova</a></li>
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
            <div class="container headline">
                <div class="row">
                    <div class="col-md-12 col-md-offset-1">
                        <div class="page-header text-left">
                            <h1>Trechos <small> adicionar trecho</small></h1>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-1">
                        <form role="form" method="POST" action="novo_trecho">
                            <div class="form-group">
                                <label for="inputOrigem">Origem</label>
                                <select class="form-control" name="origem">
                                    <c:forEach var="rodoviarias" items="${requestScope.rodoviarias}">
                                        <option>${rodoviarias.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputDestino">Destino</label>
                                <select class="form-control" name="destino">
                                    <c:forEach var="rodoviarias" items="${requestScope.rodoviarias}">
                                        <option>${rodoviarias.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputViacao">Viação</label>
                                <select class="form-control" name="viacao">
                                    <c:forEach var="viacoes" items="${requestScope.viacoes}">
                                        <option>${viacoes.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputSaida">Hora da Saída</label>
                                <input type="text" class="form-control" name="saida" id="idsaida" placeholder="13:00">
                            </div>
                            <div class="form-group">
                                <label for="inputChegada">Hora da Chegada</label>
                                <input type="text" class="form-control" name="chegada" id="idchegada" placeholder="17:00">
                            </div>
                            <div class="form-group">
                                <label for="inputPreco">Preço do Trecho</label>
                                <input type="text" class="form-control" name="preco" id="idpreco" placeholder="99,00">
                            </div>
                            <div class="form-group">
                                <label>
                                    <input type="checkbox" id="idsegunda" name="segunda" value="segunda"> Segunda
                                </label>
                                <label>
                                    <input type="checkbox" id="idterca" name="terca" value="terca"> Terça
                                </label>
                                <label>
                                    <input type="checkbox" id="idquarta" name="quarta" value="quarta"> Quarta
                                </label>
                                <label>
                                    <input type="checkbox" id="idquinta" name="quinta" value="quinta"> Quinta
                                </label>
                                <label>
                                    <input type="checkbox" id="idsexta" name="sexta" value="sexta"> Sexta
                                </label>
                                <label>
                                    <input type="checkbox" id="idsabado" name="sabado" value="sabado"> Sabado
                                </label>
                                <label>
                                    <input type="checkbox" id="iddomingo" name="domingo" value="domingo"> Domingo
                                </label>
                            </div>
                            <button type="submit" class="btn btn-primary">Inserir</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- /header-image -->
            <hr>
            <div class="footer">
                <div class="container">
                    <footer>
                        <p>
                            Copyleft &copy; Embarcou.com 2013 &middot; <a href="${ pageContext.request.contextPath }/equipe">Equipe :) </a>
                        </p>
                    </footer>
                </div>
            </div>


        </div>

        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap3-typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
    </body>

</html>