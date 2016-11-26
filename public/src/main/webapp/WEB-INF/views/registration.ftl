<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign-Up</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.css">
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <@form.form commandName="regForm" action="/sign-up" acceptCharset="UTF-8" method="post" cssClass="form-horizontal">
            <#--<form class="form-horizontal">-->
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <#--<input type="email" class="form-control" id="username" placeholder="Username">-->
                        <@form.input path="username" placeholder="Username" cssClass="form-control"/>
                        <@form.errors path="username" cssStyle="color: red;" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <#--<input type="password" class="form-control" id="password" placeholder="Password">-->
                        <@form.input path="password" placeholder="Password" cssClass="form-control" type="password"/>
                        <@form.errors path="password" cssStyle="color: red;" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="repassword" class="col-sm-2 control-label">RePassword</label>
                    <div class="col-sm-10">
                        <#--<input type="password" class="form-control" id="repassword" placeholder="Retype password">-->
                        <@form.input path="repassword" placeholder="RePassword" cssClass="form-control" type="password"/>
                        <@form.errors path="repassword" cssStyle="color: red;" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Зарегистрироваться</button>
                    </div>
                </div>
            <#--</form>-->
            </@form.form>
        </div>
    </div>
</div>
</body>
</html>