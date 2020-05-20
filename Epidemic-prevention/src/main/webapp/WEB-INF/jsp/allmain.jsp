<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/main.css" media="all" />
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body class="layui-layout-body close-footer" style="background-image: url(/image/bg4.jpg);background-size: 100% 100%;background-attachment: fixed" >
<div class="layui-layout layui-layout-admin close-footer" >
    <!-- 顶部 -->
    <div class="layui-header header" style="margin-top: 30px;margin-left: 80px;margin-right: 30px;border-radius: 20px;background-color: rgba(255,255,255,0.1)">
        <div class="layui-main">
            <a href="#" class="logo">Content</a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:;" class="iconfont hideMenu icon-menu1"></a>
            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav top_menu" style="top:10px;">
                <li class="layui-nav-item"  >
                    <a href="${ctx }/admin/logOut" class="signOut" >
                        <i class="iconfont icon-loginout" style="color:red"></i>
                        <cite style="color: #3F3F3F" >退出</cite>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="layui-side" style="margin-top:80px;margin-left: 80px;margin-bottom: 30px;border-radius: 20px;background-color: rgba(255,255,255,0.1);width: 250px">
        <div class="navBar" ></div>
    </div>
    <!-- 右侧内容 -->
    <div class="layui-body layui-form close-footer" style="margin-bottom:0px;margin-left: 165px;margin-right: 100px;margin-top: 30px;background-color: rgba(230, 230 ,250,0.5)">
        <div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs" >
                <li class="layui-this" lay-id=""><i class="iconfont icon-computer" style="left: 30px"></i><cite>后台首页</cite></li>
            </ul>
            <!-- 当前页面操作 -->
            <ul class="layui-nav closeBox" style="width: 140px">
                <li class="layui-nav-item" >
                    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <!-- 中间内容区域 -->
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src="${ctx }/admin/main"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/leftNav.js"></script>
<script type="text/javascript" src="${ctx }/js/allmain.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>