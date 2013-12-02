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

                            <form class="form-horizontal" role="form" method="GET" action="buscar" >

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
                                        <button type="submit" class="btn btn-lg btn-primary">
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

        <div class="container">

            <!-- START THE FEATURETTES -->
            <hr class="featurette-divider">
            
            <div class="featurette" id="about">
                <img class="featurette-image img-circle img-responsive pull-right" src="http://media-cdn.tripadvisor.com/media/photo-s/01/d7/b4/78/pousada-surucua-bonito.jpg" alt="Bonito em Mato Grosso do Sul">
                <h2 class="featurette-heading">Venha conhecer <span class="text-muted">Bonito-MS</span></h2>
                <p class="lead">Onde a natureza mostra o seu lado mais belo.</p>
            </div>

            <hr class="featurette-divider">

            <div class="featurette" id="services">
                <img class="featurette-image img-circle img-responsive pull-left" src="http://www.eonlineexperiences.com/INsider_Zone/wp-content/uploads/o-pantanal-mato-grosso-do-sul-em-1988-de-121112-a-27113-um-olhar-sobre-o-brasil-a-fotografia-na-construcao-da-imagem-da-nacao-no-instituto-tomie-ohtake-av-faria-lima-201-entrada-pela-rua-1353010113704_500x500.jpg" alt="Pantanal de Mato Grosso do Sul">
                <h2 class="featurette-heading">Já conhece o <span class="text-muted">Pantanal?</span></h2>
                <p class="lead">A maior planície alagada do planeta. </p>
            </div>
            <!-- /END THE FEATURETTES -->
            <hr>
            <!-- FOOTER -->
            <footer>
                <p>
                    Copyright &copy; Company 2013 &middot; Facebook &middot; Twitter &middot; Google+
                </p>
            </footer>
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