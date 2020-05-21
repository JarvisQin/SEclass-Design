
var $;
var $form;
var form;
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery'],function () {
   var layer=parent.layer===undefined?layui.layer:parent.layer,
   laypage=layui.laypage;
   $=layui.jquery;
   form=layui.form;

    form.verify({
        pass:[/(.+){6,16}$/,'密码必须6到16位'],
        repass:function (value) { //value就是repass的输入值
            var repassvalue=$('#password').val(); //获取输入的密码
            if(value!=repassvalue)
            {
                return '两次输入的密码不一致!';
            }
        }
    });
    $("#username").blur(function () {
        $.ajax({
            type:"get",
            url:ctx+"/admin/checkAdminName/"+$("#username").val(),
            success:function (data) {
                if(data.code!=0)
                {
                    top.layer.msg(data.msg);//top.layer 表示在最顶层弹出窗口
                    $("#username").val(""); //清空原来的输入
                    $("#username").focus();//焦点重新定位到username
                }
            }
        });
    });
    form.on("submit(addAdmin)",function (data) {
        var index=top.layer.msg('数据提交中，请稍候。',{icon:16,time:false,shade:0.8});
        var msg;
        $.ajax({
          type: "post",
          url:ctx+"/admin/insAdmin",
          data:data.field,
          dataType:"json",
          success:function (d) {
              if(d.code==0)
              {
                 msg="添加成功!";
              }
              else
              {
                  msg=d.msg;
              }
          },
            error:function (jqXHR, textStatus, errorThrown) {
                layer.alert("获取数据失败! 先检查sql 及 Tomcat Localhost Log 的输出");
            }


        });

        setTimeout(function () {
            top.layer.msg(msg);
            top.layer.close(index);
            layer.closeAll("iframe");
            setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                //刷新父页面
                top.location.reload();
            },1000);
        },2000);  //在点击提交后2秒执行 setTimeout中的function函数

        return false;
    })
 });


