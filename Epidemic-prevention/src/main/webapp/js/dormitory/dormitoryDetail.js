
layui.use(['form','layer','carousel', 'jquery','laypage'],function () {
    var form=layui.form,table=layui.table,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
        $=layui.jquery;
        carousel = layui.carousel;

    carousel.render({
        elem: "#details-image",
        width: "100%",
        height: "400px",
        anim: "default"
    });




});