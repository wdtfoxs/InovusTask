<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
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
<div class="container" style="margin: 20px auto">
    <div class="col-md-offset-3 col-md-6">
       <h1> ${curTime}, <@sec.authentication property="principal.username"/>!</h1>
        <a class="btn-primary" href="/logout">Выйти</a>
    </div>
</div>

</body>
</html>