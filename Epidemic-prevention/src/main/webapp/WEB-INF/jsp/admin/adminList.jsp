<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all" />
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body class="childrenBody" style="padding: 30px">
<input type="checkbox" id="adminId" value="${admin.adminId}" /> <!--adminList.js中会用到 ->
blockquote就是引入一种样式-->

        <!--&#xe608就是 一个加号的图标-->
        <a class="layui-btn layui-btn-normal adminAdd_btn" style="margin-left: 20px;margin-bottom: 20px">
            <i class="layui-icon">&#xe608;</i>添加管理员 </a>

<table id="adminList" lay-filter="test"></table>  <!--加载管理员列表数据-->
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/adminList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
<!--
当type属性为text/html的时候，<script>片断中定义一个被JS调用的代码，
代码不会在页面上显示，在页面渲染的时候，浏览器不会读取script标签中的html代码
-->
<script type="text/html" id="barEdit">
    <a class="layui-btn layui-btn-sm" lay-event="edit">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>
<!--下面的 {{d.sex}} 是动态内容，它对应数据接口返回的字段名。
除此之外，你还可以读取到以下额外字段：
序号：{{ d.LAY_INDEX }} （该额外字段为 layui 2.2.0 新增）
详细使用 看layui官网的table模块 文档
-->

<script type="text/html" id="sexTpl">
    {{#  if(d.sex == 0){ }}
    <span style="color: #F581B1;">女</span>
    {{#  } else if(d.sex == 1){ }}
    <span style="color: #1e9fff;">男</span>
    {{#  } else{ }}
    <span style="color: #08f55f;">保密</span>
    {{#  } }}
</script>
</body>


</html>