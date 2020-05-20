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

        <a class="layui-btn layui-btn-normal cleanAdd_btn" style="margin-left: 20px;margin-bottom: 20px">
            <i class="layui-icon">&#xe608;</i>打扫卫生记录
        </a>



<!--数据表格-->
<table id="cleanList" class="cleanList" lay-filter="cleanList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/clean/cleanList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<script type="text/html" id="barEdit">
    <a class="layui-btn layui-btn-sm" lay-event="edit">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a class="layui-btn layui-btn-sm layui-btn-danger " lay-event="del">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>


<script type="text/html" id="levelTpl">
    {{#  if(d.cleanLevel==0){                         }}
    <span style="color: #0000FF">优秀</span>
    {{#   }  else if(d.cleanLevel==1){                        }}
    <span style="color: #FF5722">良好</span>
    {{#   }else {                                      }}
    <span style="color: #1AA094">不及格</span>
    {{#      }                                          }}
</script>

</body>
</html>




