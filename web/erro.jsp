<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@include file="include/header.jsp" %>

        <title>Embarcou - O melhor preço de passagem</title>
    </head>
    <body>
        <div class ="container">
            <div class="header-image">
                <div class="headline">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5">
                                <img class="featurette-image" src="${ pageContext.request.contextPath }/img/Mascote_home.png.png">
                            </div>
                            <div class="col-md-7">
                                <h2 class="alert alert-danger">
                                    Nao foi possível realizar o login<br /> <a href="admin/" class="alert-link">Clique aqui</a> e tente novamente.
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- FOOTER -->
            <footer>
                <p>
                    Copyright &copy; Company 2013 &middot; Facebook &middot; Twitter &middot; Google+
                </p>
            </footer>


        </div>

        <script src="${ pageContext.request.contextPath }/js/jquery.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/typeahead/typeahead.js"></script>

    </body>

</html>