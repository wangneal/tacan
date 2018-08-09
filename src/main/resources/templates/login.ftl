<!DOCTYPE HTML>
<html>
<head>

    <title>用户登录</title>
    <#include "/public/header.ftl">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<style>
    .header {
        text-align: center;
    }
    .header h1 {
        font-size: 200%;
        color: #333;
        margin-top: 30px;
    }
    .header p {
        font-size: 14px;
    }
</style>
<body>
<div class="header">
    <div class="am-g">
        <h1>TANCAN导航系统</h1>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>用户登录</h3>
        <hr>
        <div class="am-btn-group">
            <a href="#" class="am-btn am-btn-secondary am-btn-sm"><i class="am-icon-github am-icon-sm"></i> Github</a>
            <a href="#" class="am-btn am-btn-success am-btn-sm"><i class="am-icon-google-plus-square am-icon-sm"></i> Google+</a>
            <a href="#" class="am-btn am-btn-primary am-btn-sm"><i class="am-icon-stack-overflow am-icon-sm"></i> stackOverflow</a>
        </div>
        <br>
        <br>

        <form  class="am-form" action="/login" method="post">
            <label for="username">用户名:</label>
            <input type="text" name="username" id="username" value="">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" value="">
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox" name="rememberme" value="true">
                保持登录
            </label>
            <br />
            <div class="am-cf">
                <input type="submit" class="am-btn am-btn-primary am-btn-sm am-fl" value="登录"></input>
                <#--<button type="button" onclick="fogot()" class="btn btn-primary">忘记密码 ^_^?</button>-->
            </div>
        </form>
    </div>
    </div>
</div>
<#include "/public/footer.ftl">
</body>
<script>
    <#if msg??>
        alert(msg);
    </#if>
</script>
<#--<script>-->
    <#--var ctx = "/";-->
    <#--function login() {-->
        <#--var username = $("input[name='username']").val();-->
        <#--var password = $("input[name='password']").val();-->
        <#--var remberme = $("#remember-me").is(':checked');-->
        <#--$.ajax({-->
            <#--type : "post",-->
            <#--url : ctx + "login",-->
            <#--data : {"username":username, "password":password, "remberme":remberme},-->
            <#--dataType: "json",-->
            <#--success: function (r) {-->
                <#--if (r.code==0){-->
                    <#--location.href=ctx + "admin/index";-->
                <#--}else {-->
                    <#--alert(r.msg);-->
                <#--}-->
            <#--}-->
        <#--})-->
    <#--}-->
<#--</script>-->
</html>