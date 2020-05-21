<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加角色</title>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/zTreeStyle/zTreeStyle.css" media="all"  type="text/css"/>
    <script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery.ztree.all.js"></script>
    <script>
        var ctx = "${ctx}";
    </script>
    <style type="text/css">
        .layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
        @media(max-width:1240px){
            .layui-form-item .layui-inline{ width:100%; float:none; }
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;" id="arf">
    <!--权限提交 隐藏参数-->
    <input type="hidden" id="m" name="m" />
    <div class="layui-form-item">
        <label class="layui-form-label">角色名</label>
        <div class="layui-input-block">
            <input type="text" id="roleName" class="layui-input userName" lay-verify="required"
                   placeholder="请输入角色名" name="roleName" value="${role.roleName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入角色描述" class="layui-textarea linksDesc" lay-verify="required"
             name="roleRemark">${role.roleRemark}</textarea>
        </div>
    </div>
    <!--权限树-->
    <div class="layui-form-item">
        <label class="layui-form-label">权限分配：</label>
        <div style="padding-left: 10%">
            <input id="checkAllTrue" href="#" type="button" value="全选">
            <input id="checkAllFalse" href="#" type="button" value="取消全选">
        </div>
        <ul id="xtree1" class="ztree" style="width: 200px;margin-left: 105px"></ul>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addRole">立即提交</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/role/addRole.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>