### TACAN网址导航系统
### 1、简介
我在大学的时候初次学习php的时候就有写个网址导航系统的想法，但是一直没有付诸实践，最近学习Java和springboot框架，顺手就写了一个。

### 2、技术选型

 - springboot2.0
 - springdata-Jpa
 - mybatis
 - mysql5.6
 - freemarker
 - shiro（进行权限控制）
 - Jsoup（xss过滤）

### 3、使用
由于使用了lombok插件，所以最好你会配置它。
clone项目之后、使用Maven导入，运行`TacanApplication.java`.

导入sql文件：项目目录的log文件夹下，tacan.sql文件。
访问http://localhost:8080/admin 默认帐号admin   密码 admin123

### 4、完成进度

 - 1、后端：90%，还有些小bug没有修复。暂时先这样吧。还有些功能也没有实现，时间有限，先这样吧。 
 - 2、前台模块：50%，做了后台管理面板，前台首页部分实在没有灵感就先弃了，做了网址登录的页面和分类显示的页面。
 - 3、暂时就先这样吧，毕竟时间有限，这是熬夜写出来的。

### 5、感言
嘿嘿，，，以前就喜欢写感言，毛病到现在都没改，写这款软件的感触很多，遇到的问题也很多：

 - 1、Mybatis的xml Mapper文件总是扫描不到，查了很多资料没有什么思路，先弃了，直接写的注解。
 - 2、代码质量，代码质量真的很重要，不然回头去看一脸懵逼，我昨天写的，今天翻出来看就不知道东南西北了。
 - 3、Jpa的一些坑，Mysql级联CRUD的坑踩得不要太爽，最后还是放弃了，使用Mybatis来做级联操作了。
 
 总之，这次是第一次相对完整的自己完成了一款软件，虽然还有很多不完美的地方，我会在接下来的时间慢慢进行优化，包括代码沉余的问题，但是当时也没有其他好的办法，所以就先这样了，后面可能会进行更新再来优化一些。