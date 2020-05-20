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
<body style="padding: 30px">
    <div>
        <table id="adminLogList" lay-filter="adminLogList"></table>
    </div>
    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/admin/adminLogList.js"></script>
    <script type="text/javascript" src="${ctx }/js/pubilc.js"></script>


    <script type="text/html" id="isSafeExitTpl">

        {{#  if(d.isSafeExit == 0){ }}
        <span style="color: #FF5722;">异常退出</span>
        {{#  } else if(d.isSafeExit == 1){ }}
        <span style="color: #1e9fff;">安全退出</span>
        {{#  } }}
    </script>
</body>
</html>