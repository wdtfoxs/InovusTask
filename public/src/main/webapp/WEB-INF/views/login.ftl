<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Sign-In</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.css">
    <style type="text/css">
        a {
            color: #337ab7;
            text-decoration: none;
            display: inline-block;
            padding: 5px 10px 6px 10px;
            border: 1px solid;
            border-radius: 5px 5px;
            text-align: center;
        }
        a:hover{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div class="col-md-offset-3 col-md-6">
        <form class="form-horizontal" action="/j_spring_security_check" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username</label>
                <div class="col-sm-10">
                    <input class="form-control" id="username" placeholder="Username" name="j_username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="Password" name="j_password">
                </div>
            </div>
            <#if error?has_content>
                <div style="color: red;" class="col-sm-offset-2 col-sm-10">Имя пользователя и пароль не подходят</div>
            </#if>
            <input type="checkbox"
                   name="_spring_security_remember_me"
                   id="checkbox" checked hidden>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <#--<@sec.csrfInput />-->
                    <button type="submit" class="btn btn-default">Войти</button>
                    <#--<a href="/sign-up" class="btn-primary">Зарегистрироваться</a>-->
                    <a class="btn-primary" href="/sign-up" type="button">Зарегистрироваться</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>