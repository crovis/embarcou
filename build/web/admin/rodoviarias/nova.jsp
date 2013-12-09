<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        <a href="admin/" class="navbar-brand">Embarcou</a>
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviárias<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../rodoviarias">Listar</a></li>
                                    <li><a href="#">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Viacões<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../viacoes">Listar</a></li>
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
                    <div class="col-lg-10 col-lg-offset-1">
                        <div class="page-header text-left">
                            <h1>Rodoviárias -<small> adicionar rodoviária</small></h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-1">
                        <form role="form" method="POST" action="nova_rodoviaria" character_set="UTF-8">
                            <div class="form-group">
                                <label for="inputNome">Nome da rodoviária</label>
                                <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Nome da rodoviária">
                            </div>
                            <button type="submit" class="btn btn-primary">Inserir</button>
                        </form>
                    </div>
                </div>
            </div>
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