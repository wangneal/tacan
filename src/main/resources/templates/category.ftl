<!DOCTYPE HTML>
<html>
<#include "/public/header.ftl">
<header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
    <title>${category.name}</title>
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
<body>
<#--baidu start-->
<div style="align-content: center">
<form onsubmit="return gowhere1(this)" target="_blank" name="search_form1" method="get" action="http://www.baidu.com/baidu">
    <table width="100%" height="80" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体">
        <tbody>
        <tr>
            <td>
                <table width="144%" height="80" cellspacing="0" cellpadding="0" border="0">
                    <input type="hidden" value="0" name="myselectvalue">
                    <input type="hidden" value="utf-8" name="ie">
                    <input type="hidden" name="tn" value="SE_zzsearchcode_shhzc78w">
                    <input type="hidden" name="ct">
                    <input type="hidden" name="lm">
                    <input type="hidden" name="cl">
                    <input type="hidden" name="rn">
                    <tbody>
                    <tr>
                        <td width="8%" valign="bottom">
                            <div align="center">
                                <a href="https://www.baidu.com/"  target="_blank">
                                    <img border="0" align="bottom" alt="Baidu" src="https://www.baidu.com/img/baidu_jgylogo3.gif">
                                </a>
                            </div>
                        </td>
                        <td width="92%" valign="bottom">

                            <input type="radio" value="0" onclick="javascript:this.form.myselectvalue.value=4;" name="myselect">
                            <font color="#0000cc">新闻</font>

                            <input type="radio" value="0" onclick="javascript:this.form.myselectvalue.value=0;" name="myselect" checked="">
                            <span class="f12"><font color="#0000cc">网页</font></span>

                            <input type="radio" value="1" onclick="javascript:this.form.myselectvalue.value=1;" name="myselect">
                            <span class="f12"><font color="#0000cc">音乐</font></span>

                            <input type="radio" value="0" onclick="javascript:this.form.myselectvalue.value=6;" name="myselect">
                            <font color="#0000cc">贴吧</font>

                            <input type="radio" value="0" onclick="javascript:this.form.myselectvalue.value=5;" name="myselect">
                            <font color="#0000cc">图片</font>

                            <table width="100%" cellspacing="0" cellpadding="0" border="0" align="right">
                                <tbody>
                                <tr>
                                    <td style="padding-top:10px;">
                                        <font>
                                            <input id="word" type="text" name="word" size="40" onfocus="checkHttps">
                                        </font>
                                        <input  type="submit" value="百度一下">
                                    </td>
                                    <td><br></td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td width="8%"></td>
                        <td width="92%"></td>
                    </tr>
                    <tr><td></td></tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<table class="am-table am-table-striped am-table-hover">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    <thead>
    <tr>
        <#list urlsite as u>
            <th><a href="http://${u.siteurl}">${u.sitename}</a> </th>
        </#list>
    </tr>
    </thead>
</table>
</div>

<#--baidu end-->
<script src="http://s1.bdstatic.com/r/www/cache/global/js/BaiduHttps_20150714_zhanzhang.js"></script>
<script>
    function checkHttps () {
        BaiduHttps.useHttps();
    };
    function gowhere1 (formname) {
        var data = BaiduHttps.useHttps();
        var url;
        if (formname.myselectvalue.value == "0") {
            url = data.s == 0 ? "http://www.baidu.com/baidu" : 'https://www.baidu.com/baidu' + '?ssl_s=1&ssl_c' + data.ssl_code;
            document.search_form1.tn.value = "SE_zzsearchcode_shhzc78w";
            formname.method = "get";
        }
        if (formname.myselectvalue.value == "1") {
            document.search_form1.tn.value = "SE_zzsearchcode_shhzc78w";
            document.search_form1.ct.value = "134217728";
            document.search_form1.lm.value = "-1";
            url = "http://mp3.baidu.com/m";
        }
        if (formname.myselectvalue.value == "4") {
            document.search_form1.tn.value = "SE_zzsearchcode_shhzc78w";
            document.search_form1.cl.value = "2";
            document.search_form1.rn.value = "20";
            url = "http://news.baidu.com/ns";
        }
        if (formname.myselectvalue.value == "5") {
            document.search_form1.tn.value = "SE_zzsearchcode_shhzc78w";
            document.search_form1.ct.value = "201326592";
            document.search_form1.cl.value = "2";
            document.search_form1.lm.value = "-1";
            url = "http://image.baidu.com/i";
        }
        if (formname.myselectvalue.value == "6") {
            document.search_form1.tn.value = "SE_zzsearchcode_shhzc78w";
            document.search_form1.ct.value = "352321536";
            document.search_form1.rn.value = "10";
            document.search_form1.lm.value = "65536";
            url = "http://tieba.baidu.com";
        }
        formname.action = url;
        return true;
    }
</script>

</body>

<#include "/public/footer.ftl">
</html>