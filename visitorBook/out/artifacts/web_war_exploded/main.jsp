<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <title>Гостевая книга</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link ref="shortcut icon" href="/images/icon.png" type="image/png">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css"><!-- thats important for animation effects -->
    <link href="https://fonts.googleapis.com/css?family=Arbutus" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</head>

<body>
<div id="gradient">

    <!-- шапка -->
    <nav class="navbar  navbar-fixed-top " data-aos="fade-down" data-aos-duration="2600" data-aos-once="true">
        <div class="container-fluid ">
            <div class="navbar-collapse" id="navcol-1">
                <img src="images/brain.png" alt="df" class="df" height="40">
                <ul class="nav navbar-nav navbar-right" >
                    <c:if test="${user ne null}">
                        <!--ВЫХОД-->
                        <li  class="show-login">${user.login} </li>
                        <li ><a href="logout" id="exit" class="button-def" >Выйти </a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>

    <!-- контейнер с внутренностями -->
    <div class="container">
        <div class="row">

            <!-- шапка формы входа и реристрации -->
            <div class="col-md-7 col-xs-12 col-sm-12" data-aos="fade-right" data-aos-duration="2600" data-aos-once="true">
                <c:if test="${user eq null}">
                    <div class="panel panel-login" id="form-all" >
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Вход</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Регистрация</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <!-- форма входа -->
                                    <form id="login-form" action="/login" method="post" role="form" class="lf" style="display: block;">
                                        <div class="form-group stretch">
                                            <input type="text" name="login" id="login" tabindex="1" class="rfield form-control" placeholder="Логин" value="">
                                        </div>
                                        <div class="form-group stretch">
                                            <input type="password" name="password" id="password" tabindex="2" class="rfield form-control" placeholder="Пароль">
                                        </div>
                                        <div class="form-group ">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login " value="Войти">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- форма регистрации -->
                                    <form id="register-form" action="/signup" method="post" role="form" class="rf" style="display: none;">
                                        <div class="form-group stretch">
                                            <input type="text" name="username" id="username" tabindex="1" class="rfield form-control" placeholder="Имя" value="">
                                        </div>
                                        <div class="form-group stretch">
                                            <input type="text" name="login" id="login" tabindex="1" class="rfield form-control" placeholder="Логин" value="">
                                        </div>
                                        <div class="form-group stretch">
                                            <input type="password" name="password" id="password" tabindex="2" class="rfield form-control password" placeholder="Пароль">
                                        </div>
                                        <div class="form-group stretch">
                                            <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="rfield form-control confirm-password" placeholder="Подтвердите пароль">
                                        </div>
                                        <div class="block1">
                                            <div class="arrow-up"></div>
                                            <div class="error " ><img src="images/error.png" alt="df"  height="50">  Пароли не совпадают!</div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register " value="Зарегистрироваться">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <c:if test="${info != null}">
                                <div class="info-block">
                                        ${info}
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:if>

                <c:if test="${user ne null}">
                    <!-- форма написания сообщения -->
                    <div class="panel panel-default" id="message">
                        <div class="panel-body">
                            <form accept-charset="UTF-8" action="/createMessage" class="mf" method="POST">
                                <textarea class="form-control counted text-area" name="message" placeholder="Введите сообщение" rows="8" style="margin-bottom:10px; "></textarea>
                                <h6 class="pull-right" id="counter">320 символов осталось</h6>
                                <button class="btn  btn-message" type="submit" >Опубликовать</button>
                                <input type="reset" class="btn"  value="Очистить" >
                            </form>
                        </div>
                    </div>
                </c:if>
            </div>

            <!-- окно с выпадающими сообщениями -->
            <div class="col-md-5 col-xs-12 col-sm-12" data-aos="fade-left" data-aos-duration="2600" data-aos-once="true">
                <div class="window">
                    <article>
                        <div class="content">

                            <c:if test="${user eq null}">
                                <!-- сообщение о входе, чтобы оставить сообщение-->
                                <div class="alert alert-warning " role="alert" data-dismiss="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    <strong>Внимание!</strong> Войдите, чтобы оставить сообщение.
                                </div>
                            </c:if>

                            <c:forEach items="${messages}" var="message" varStatus="container">
                                <!-- квадраты с сообщением пользователя -->
                                <div class="window-message" id="">
                                    <article>
                                        <div class="title">
                                            <h2>${message.owner.username}</h2>
                                            <p class="small">${message.owner.login}</p>
                                        </div>
                                        <div class="content-inside">
                                            <p>${message.text}</p>
                                        </div>
                                    </article>
                                </div>
                            </c:forEach>

                            <!-- конец окна со всеми сообщениями -->
                        </div>
                    </article>
                </div>
            </div>

            <!-- закрыть контейнер со внутренностями -->
        </div>
    </div>

    <!-- футер -->
    <div class="footer-bottom">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 widget " >© 2018 | Карпенко, Хомяков</div>
            </div>
        </div>
    </div>

</div>

<script src="js/script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script> <!-- Important for animation -->

</body>
</html>
