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
        <label class="layui-form-label">维修日期</label>
        <div class="layui-input-inline">
            <input type="text" id="fixTime" name="fixTime" class="layui-input"
                   lay-verify="required" placeholder="请输入维修日期">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">维修状况</label>
        <div class="layui-input-inline">
            <input type="radio" name="fixStatus" value="0" title="维修完毕" checked>
            <input type="radio" name="fixStatus" value="1" title="维修中" checked>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">宿舍名称</label>
        <div class="layui-input-block">
            <select name="dormitoryId" id="dormitoryId"
                    lay-filter="dormitoryFilter">
                <option value="">请选择</option>
                <c:forEach items="${dormitories}" var="d">
                    <option value="${d.dormitoryId}">${d.dormitoryNumber}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">维修人员</label>
        <div class="layui-input-block">
            <select name="fixPepoleId" id="fixPepoleId">
                <option value="">请选择</option>
                <c:forEach items="${fixPeoples}" var="s">
                    <option value="${s.admin_id}">${s.username}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">维修备注</label>
        <div class="layui-input-block">
            <input type="text" id="fixNote" class="layui-input"
                   lay-verify="required" placeholder="请输入维修内容" name="fixNote" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addFix">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/fix/addFix.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>