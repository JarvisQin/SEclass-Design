<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>编辑管理员</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <script>
        var ctx="${ctx}";
    </script>
    <!-- @meida 表示如果文档宽度小于 1240 像素 那么.layui-form-item .layui-inline的宽度等样式改变-->
    <style type="text/css">
        .layui-form-item .layui-inline {
            width: 33.333%;
            float: left;
            margin-right: 0;
        }
        @media ( max-width :1240px) {
            .layui-form-item .layui-inline {
                width: 100%;
                float: none;
            }
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;">
    <!--管理员id 这个是 提交表单时 携带的参数-->
    <input type="hidden" name="classId" value="${dClass.classId}"/>
    <div class="layui-form-item">
        <label class="layui-form-label ">班级名称</label>
        <div class="layui-input-block">
            <input type="text" id="className" class="layui-input"
                   lay-verify="required" placeholder="请班级名称" name="className" value="${dClass.className}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">班级备注</label>
        <div class="layui-input-block">
            <input type="text" name="classNote" id="nickname" class="layui-input"
                   lay-verify="required" placeholder="请输入备注" value="${dClass.classNote}">
        </div>
    </div>


    <!--在layui.all中预定义了很多格式  如果上面的lay-verify="required" 那么只是验证非空
        如果写成 lay-verify="email" 那么输入的邮箱没有@ 就会报错
        如果写成 lay-verify="phone" 那么输入的手机号 位数不对 会报错
        layui.all中定义email phone的验证规则 还有很多.....
    -->

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updClass">立即保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/class/editClass.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>