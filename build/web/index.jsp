<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" type="text/css"  rel="stylesheet">
        <link href="css/one-page-wonder.css" type="text/css" rel="stylesheet">
        <link href="css/datepicker.css" type="text/css" rel="stylesheet">
        <link href="css/typeahead.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js"></script>

        <title>Embarcou - O melhor preço de passagem</title>
    </head>
    <body>
        <hr class="topo">
        <div class="header-image">
            <div class="headline">
                <div class="container">
                    <div class="row">
                        <div class="col-md-5">
                            <img class="featurette-image" src="img/Mascote_home.png.png" alt="Mascote da empresa embarcou.com">
                        </div>
                        <div class="col-md-6 pull-right">
                            <h1 class="logo pull-left">
                                    <img src="img/logo_embarcou_header.png.png" alt="Logo da empresa embarcou.com">
                            </h1>

                            <form class="form-horizontal" role="form" method="GET" action="buscar" name="buscar_form" >

                                <div class="form-group input-group-lg">
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control input-lg input-large typeahead" autocomplete="off" name="origem" id="inputOrigem" placeholder="Origem" >
                                    </div>
                                </div>
                                
                                <div class="form-group input-group-lg">
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control input-lg input-large typeahead" autocomplete="off" name="destino" id="inputDestino" placeholder="Destino">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-4">
                                        <input type="text" name="data"  id="inputData"class="datepicker form-control" placeholder="Data da viagem">
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-sm-1">
                                        <button type="submit" id="idbuscar" class="btn btn-lg btn-primary">
                                            <span class="glyphicon glyphicon-search"></span>
                                            Buscar Passagens
                                        </button>
                                        <c:forEach var="recente" items="${sessionScope.recentes}">
                                            ${recente.origem}
                                            ${recente.destino}
                                            ${recente.data}
                                        </c:forEach>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div> 
            </div>
        </div>

        <!-- /header-image -->
        <hr class="featurette-divider">
            <div class="cidade-bonito">
                <div class="row-fluid">
                    <div class="span5">
                        <div class="block-index" id="bonito">
                            <h1>Bonito - MS</h1>
                        </div>
                    </div>
                    
                    <div class="span5">
                        <div class="block-index" id="bonito-conteudo">
                            <p>Onde a natureza mostra o seu lado mais belo</p>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
        
            <div class="cidade-corumba">
                <div class="row-fluid">
                    <div class="span5">
                        <div class="block-index" id="corumba">
                            <h1>Corumbá - MS</h1>
                        </div>
                    </div>
                    
                    <div class="span5">
                        <div class="block-index" id="corumba-conteudo">
                            <p>Cultura, Natureza, Arte, Passado e Presente</p>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            
            <div class="cidade-pantanal">
                <div class="row-fluid">
                    <div class="span3">
                        <div class="block-index" id="pantanal">
                            <h1>Pantanal - MS</h1>
                        </div>
                    </div>
                    <div class="span3">
                        <div class="block-index" id="pantanal-conteudo">
                            <small>"Quieto, no meio das coisas miúdas. E me encantei"</small>
                        </div>
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

        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
        <script type="text/javascript">
            
            var nowTemp = new Date();
            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
            
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