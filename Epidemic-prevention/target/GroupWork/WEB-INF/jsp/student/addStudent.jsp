<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
    <form class="layui-form" style="width: 80%;" id="auf">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="username" id="username"
                lay-verify="required" placeholder="请输入学生姓名" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="radio" name="sex" value="1" title="男" checked>
                <input type="radio" name="sex" value="0" title="女" checked>
                <input type="radio" name="sex" value="2" title="保密" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">宿舍职务</label>
            <div class="layui-input-inline">
                <select name="level">
                    <option value="">请选择</option>
                    <option value="0">舍长</option>
                    <option value="1">舍员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input type="text" id="birthday" name="birthday" class="layui-input"
                       lay-verify="required" placeholder="请输入出生日期">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" id="email" name="email" class="layui-input"
                       lay-verify="email" placeholder="请输入邮箱" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" class="layui-input"
                       lay-verify="phone" placeholder="请输入手机号" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">家庭住址</label>
            <div class="layui-input-inline">
                <input type="text" id="address" name="address" class="layui-input"
                       lay-verify="required" placeholder="请输入家庭住址" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" id="note" name="note" class="layui-input"
                       lay-verify="required" placeholder="请输入备注信息" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分配班级</label>
            <div class="layui-input-block">
                <select name="classId">
                    <option value="">请选择</option>
                    <c:forEach items="${classes}" var="c">
                        <option value="${c.classId}">${c.className}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分配宿舍</label>
            <div class="layui-input-block">
                <select name="dormitoryId">
                    <option value="">请选择</option>
                    <c:forEach items="${dormitories}" var="d">
                        <option value="${d.dormitoryId}">${d.dormitoryNumber}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addStudent">立即提交</button>
            </div>
        </div>
    </form>

    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/student/addStudent.js"></script>
    <script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>