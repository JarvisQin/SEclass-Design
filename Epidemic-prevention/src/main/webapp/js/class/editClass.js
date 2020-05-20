var $;
var $form;
var form;
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery'],function () {
    var layer=parent.layer===undefined?layui.layer:parent.layer;
    $=layui.jquery;
    form=layui.form;
    $("#className").blur(function () { //当元素失去焦点时发生 blur 事件 就是输入完用户名的时候 调用functino函数
        $.ajax({
            type:"get",
            url:ctx+"/class/checkClassName/"+$("#className").val(),
            success:function (data) {
                if(data.code!=0)
                {
                    top.layer.msg(data.msg);//top.layer 表示在最顶层弹出窗口
                    $("#className").val(""); //清空原来的输入
                    $("#className").focus();//焦点重新定位到username
                }
            }
        });
    });

    form.on("submit(updClass)",function (data) {
        //弹出loading
        var index=top.layer.msg('数据提交中，请稍候',{icon:6,time:false,shade:0.2});
        var msg;
        $.ajax({
            type:"post",
            url:ctx+"/class/updClass",
            data:data.field,  //当前容器的全部表单字段，名值对形式：{name: value}
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="更新成功！";
                }
                else
                {
                    msg=d.msg;
                }
            }
        });

        setTimeout(function () {
            top.layer.close(index);//点击提交后2秒关闭上面的弹出框
            /*
            top.layer.msg(msg); //弹出新的信息提示框
            layer.closeAll("iframe");

            setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                //刷新父页面
                parent.location.reload();
            },1000);
*/
            top.layer.msg("更新成功", { shift: -1, time: 2000 },function () {
                parent.location.reload();  //shift: -1表示提示信息不抖动 2秒后调用回调函数
            });
        },2000);




        return false;//因为默认的情况是submit，这个标签大家都知道是跳转的，
        // return false主要是阻止页面跳转，并提交数据。
        // 如果去掉了，虽然同样会进行数据提交【前提是你有进行ajax操作】，但是会进行页面的刷新
    });
});