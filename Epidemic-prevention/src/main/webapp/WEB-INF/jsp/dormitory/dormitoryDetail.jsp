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
    <link rel="stylesheet" href="${ctx}/css/details.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_848666_pri5cwk3xde.css"/>

    <script >
        var ctx="${ctx}";
    </script>
</head>
<body >


<section class="layui-container wrapper">

    <div class="my-anchor-title">
        <h3>宿舍照片</h3>
    </div>

    <div class="carousel-image layui-pull-left layui-col-md7">
        <div class="layui-carousel" id="details-image">
            <div carousel-item style="float: left;">
                <c:forEach items="${DetailsImg }" var="d">
                    <div style="background: url('${d}')no-repeat center/cover"></div>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="anchor-title">
        <h3>房屋配置</h3>
    </div>
    <div class="household-appliances">
        <ul>
            <li>
                <i class="iconfont icon-chuang"></i>
                <span>床</span>
            </li>
            <li>
                <i class="iconfont icon-kongtiao"></i>
                <span>空调</span>
            </li>
            <li>
                <i class="iconfont icon-yigui"></i>
                <span>衣柜</span>
            </li>
            <li>
                <i class="iconfont icon-iconyihuifu-"></i>
                <span>桌椅</span>
            </li>
            <li>
                <i class="iconfont icon-xiyiji"></i>
                <span>洗衣机</span>
            </li>
            <li>
                <i class="iconfont icon-shafa"></i>
                <span>沙发</span>
            </li>
            <li>
                <i class="iconfont icon-xiaodugui"></i>
                <span>消毒柜</span>
            </li>
            <li>
                <i class="iconfont icon-weibolu"></i>
                <span>微波炉</span>
            </li>
            <li>
                <i class="iconfont icon-chouyouyanji"></i>
                <span>抽油烟机</span>
            </li>
            <li>
                <i class="iconfont icon-dianshi"></i>
                <span>电视</span>
            </li>
            <li>
                <i class="iconfont icon-meiqitianranqi"></i>
                <span>天然气</span>
            </li>
            <li>
                <i class="iconfont icon-kuandai"></i>
                <span>宽带</span>
            </li>
            <li>
                <i class="iconfont icon-reshuiqianzhuang"></i>
                <span>热水器</span>
            </li>
            <li>
                <i class="iconfont icon-bingxiang"></i>
                <span>冰箱</span>
            </li>
        </ul>
    </div>
</section>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/dormitory/dormitoryDetail.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>




