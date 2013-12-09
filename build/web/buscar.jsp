<%-- 
    Document   : buscar
    Created on : 24/11/2013, 14:42:40
    Author     : clovis
--%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="${ pageContext.request.contextPath }/css/bootstrap.css" type="text/css"  rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/one-page-wonder.css" type="text/css" rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/datepicker.css" type="text/css" rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/typeahead.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

        <title>Embacou - busca de passagens</title>
    </head>
    <body>
        <hr class="topo">
        <header id="header">
            <div class="headline"pgadmin>
                <div class="container">
                    <div class="col-md-6">
                        <a href="../Embarcou/"><img src="img/logo_Embarcou_resultado.png.png" alt="logo_embarcou_header.png"/></a>
                    </div>
                    <hr>
                    <div class="col-md-3">
                        <button class="btn btn-danger btn-lg" data-toggle="modal" data-target="#myModal">
                            Buscar outra passagem
                        </button>
                    </div>
                </div>
            </div>
        </header>
        <div class="bs-header">
            <div class="container">
                <div class="row col-lg-12">
                    <h2>${requestScope.pesquisa.origem} para ${requestScope.pesquisa.destino}, <strong><fmt:formatDate value="${requestScope.pesquisa.data}" type="date" dateStyle="long" timeStyle="long"/></strong></h2>
                </div>
            </div>
        </div>
        <div class="container">
                    <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Nova busca</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form" method="GET" action="buscar" >

                                    <div class="form-group input-group-lg">
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control input-lg input-large typeahead" autocomplete="off" name="origem" id="inputOrigem" placeholder="Origem" value="${requestScope.pesquisa.origem}" >
                                        </div>
                                    </div>
                                    <div class="form-group input-group-lg">
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control input-lg input-large typeahead" autocomplete="off" name="destino" id="inputDestino" placeholder="Destino" value="${requestScope.pesquisa.destino}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <input type="text" name="data" class="datepicker form-control" placeholder="Data da viagem" value="<fmt:formatDate value="${requestScope.pesquisa.data}" pattern="dd-MM-yyyy"/>">
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-1">
                                            <button type="submit" name="buscar" class="btn btn-lg btn-primary">
                                                <span class="glyphicon glyphicon-search"></span>
                                                Buscar Passagens
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <c:if test="${not empty requestScope.msgBusca}" >
                    <h1>Nenhum resultado encontrado.</h1>
                </c:if>
            <c:forEach var="trecho" items="${requestScope.trechos}">
                <fmt:setLocale value="pt_BR"/>
                <div class="row">
                    <div class="buscaOnibus">
                        <div class="container">
                            <div class="col-md-2">
                                <img src="img/${trecho.viacao.logo}" alt="andorinha_logo"/>
                            </div>
                            <div class="col-md-8">
                                <span class="glyphicon glyphicon-search"></span>
                                <small class="block">Ônibus de ${trecho.rodoviariaOrigem.nome} para ${trecho.rodoviariaDestino.nome}</small>
                                <div class="row-fluid">
                                    <div class="span8">
                                        <span class="glyphicon glyphicon-time"></span>
                                        <small>Horário de embarque: </small>
                                        <strong class="hora">${trecho.saida}</strong>
                                    </div>
                                    <div class="span8">
                                        <span class="glyphicon glyphicon-time"></span>
                                        <small>Horário de embarque: </small>
                                        <strong class="hora">${trecho.chegada}</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <strong class="precoPassagem"><fmt:formatNumber value="${trecho.preco}" type="currency"/></strong>
                                <a href="http://${trecho.viacao.site}" class="btn btn-success ">Ver no site</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
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
        <script src="${ pageContext.request.contextPath }/js/typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
        <script type="text/javascript">
            $(function() {
                var options = new Array();
                options['value'] = 'now';
                options['language'] = 'pt-BR';
                options['format'] = "dd-mm-yyyy";
                options['autoclose'] = true;
                $('.datepicker').datepicker(options);
            });

            $('#inputOrigem').typeahead({        
                     local: [
                        <c:forEach items="${requestScope.rodoviarias}" var="rodoviaria" varStatus="status">"${rodoviaria.nome}"<c:if test="${not status.last}">,</c:if></c:forEach>             
                     ]
             });

             $('#inputDestino').typeahead({      
                     local: [
                        <c:forEach items="${requestScope.rodoviarias}" var="rodoviaria" varStatus="status">"${rodoviaria.nome}"<c:if test="${not status.last}">,</c:if></c:forEach>
                        ]
             });  
        </script>
    </body>
</html>