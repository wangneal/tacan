<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>友情链接申请</title>
  <#include "/public/header.ftl">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse am-topbar-fixed-top">

    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="/" class="am-text-ir">TACAN</a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                data-am-collapse="{target: '#doc-topbar-collapse-4'}"><span class="am-sr-only">导航切换</span> <span
                class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse-4">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li class="am-active"><a href="/">TACAN导航</a></li>
                <li class="am-active"><a href="javascript:void(0);">待添加</a></li>
                <li class="am-active"><a href="javascript:void(0);">待添加</a></li>
                <li class="am-active"><a href="javascript:void(0);">待添加</a></li>
            </ul>
        </div>
    </div>
</header>

    <#if msg ??>
        <div class="am-alert am-alert-success" data-am-alert>
            <button type="button" class="am-close">&times;</button>
            <p>${msg}</p>
        </div>
    </#if>
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>网址编辑</small></div>
      </div>
        <form action="/register" method="post" class="am-form">
            <label for="username">网站名称:</label>
            <input type="text" name="name"  value="">
            <br/>
            <label for="username">网站URL:</label>
            <input type="text" name="url"  value="">
            <br/>

            <label for="username">网站分类:</label>
            <select id="state" name="category">
                <#list category as c>
                <option value="${c.id}">${c.name}</option>
                </#list>
            </select>
            <br/>
            <div class="am-cf">
                <input type="submit" class="am-btn am-btn-primary am-btn-sm am-fl" value="提交"></input>
            <#--<button type="button" onclick="fogot()" class="btn btn-primary">忘记密码 ^_^?</button>-->
            </div>
        </form>


   <#include "/public/footer.ftl">
  <!-- content end -->
    </div>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../static/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="../static/js/amazeui.min.js"></script>
<script src="../static/js/app.js"></script>

</body>
</html>
