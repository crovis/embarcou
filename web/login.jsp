<!DOCTYPE html>
<html lang="en">
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
                            <h1 class="logo">
                                <img src="${ pageContext.request.contextPath }/img/logo_embarcou_header.png.png">
                            </h1>
                            <form class="form-horizontal" role="form" method="POST" action="j_security_check">
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Usuário</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="j_username" class="form-control" id="inputEmail3" placeholder="Usuário">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">Senha</label>
                                    <div class="col-sm-6">
                                        <input type="password" name="j_password" class="form-control" id="inputPassword3" placeholder="Senha">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-1">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Lembrar
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-primary">Entrar</button>
                                    </div>
                                </div>
                            </form>
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