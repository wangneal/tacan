<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>TACAN后台管理面板</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../static/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../static/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../static/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../static/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>TACAN</strong> <small>后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <#--<li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>-->
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
            <#if user??>
          <span class="am-icon-users"></span> ${user.userName} <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <#--<li><a href="#"><span class="am-icon-user"></span> 资料</a></li>-->
          <li><a href="/admin/user"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="/logout"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 基础管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="/admin/website" class="am-cf"><span class="am-icon-check"></span> 网站设置<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="/admin/category"><span class="am-icon-puzzle-piece"></span> 分类管理</a></li>
            <li><a href="/admin/urls"><span class="am-icon-th"></span> 网址管理</a></li>
            <li><a href="/admin/log"><span class="am-icon-calendar"></span> 系统日志</a></li>
            <#--<li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>-->
          </ul>
        </li>

      </ul>

    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>网址管理</small></div>
      </div>

      <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
        <li><a href="/admin/urlsbyc" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>分类查询</a></li>
        <li><a href="/admin/urls?s=0" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>待审核</a></li>
        <li><a href="/admin/urls?s=1" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>已审核</a></li>
        <li><a href="/visitor" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>访问量</a></li>
      </ul>
      <#if category ??>
          <table class="am-table am-table-striped am-table-hover">
            <thead>
              <tr>
                  <#list category as c>
                  <td><a class="am-btn am-btn-primary" href="/admin/urls?c=${c.name}" target="_blank">${c.name}</a></td>
                  </#list>
              </tr>
            </thead>
          </table>
      </#if>
        <#if page ??>

          <table class="am-table am-table-striped am-table-hover">
              <thead>
                <tr>
                    <td>序号</td>
                    <td>网站名称</td>
                    <td>网址</td>
                    <td>状态</td>
                    <td>更新</td>
                    <td>删除</td>
                </tr>
              </thead>
        <#list page.content as u>
              <thead>
              <tr>
                  <td>${u.id}</td>
                  <td>${u.sitename}</td>
                  <td>${u.siteurl}</td>

                <#if u.status==0>
                  <td>未审核</td>
                <#else >
                    <td>已审核</td>
                </#if>
                  <td><a href="/admin/urlsupdate?id=${u.id}" class="am-btn am-btn-primary">更新</a> </td>
                  <td><a href="/admin/urlsdelete?id=${u.id}" class="am-btn am-btn-primary">删除</a> </td>
              </tr>
              </thead>
        </#list>
          </table>
            <br>
        <a href="/admin/urls?p=0" class="am-btn am-btn-primary">首页</a>
        <a href="/admin/urls?p=${page.number-1}" class="am-btn am-btn-primary">上一页</a>
        <a href="/admin/urls?p=${page.number+1}" class="am-btn am-btn-primary">下一页</a>
        <a href="/admin/urls?p=${page.totalPages-1}" class="am-btn am-btn-primary">尾页</a>
        </#if>
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
            </#if>
</body>
</html>
