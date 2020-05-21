<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all" />
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />

    <script >
        var ctx="${ctx}";
    </script>
</head>
<body class="childrenBody" style="padding: 30px">

        <a class="layui-btn layui-btn-normal fixAdd_btn" style="margin-left: 20px;margin-bottom: 20px">
            <i class="layui-icon">&#xe608;</i>宿舍维修记录
        </a>

<!--数据表格-->
<table id="fixList" class="fixList" lay-filter="fixList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/fix/fixList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<script type="text/html" id="barEdit">
    <a class="layui-btn layui-btn-sm" lay-event="edit">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a class="layui-btn layui-btn-sm layui-btn-danger " lay-event="del">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>


<script type="text/html" id="fixTpl">
    {{#  if(d.fixStatus==0){                         }}
    <span style="color: #0000FF">维修完毕</span>
    {{#   }  else if(d.fixStatus==1){                        }}
    <span style="color: #FF5722">正在维修</span>
    {{#   }else {                                      }}
    <span style="color: #1AA094">未知状态</span>
    {{#      }                                          }}
</script>

</body>
</html>




