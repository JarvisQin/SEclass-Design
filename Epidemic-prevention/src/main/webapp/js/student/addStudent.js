layui.use(['form','layer','jquery','laydate'],function () {
    var layer=parent.layer===undefined?layui.layer:parent.layer;
    var $=layui.jquery,form=layui.form,laydate=layui.laydate;

    laydate.render({
        elem:'#birthday'
    });

    $("#username").blur(function () {
        $.ajax({
          type:"get",
          url:ctx+"/student/checkStudentByStudentname/"+$("#username").val(),
          success:function (d) {
              if(d.code!=0)
              {
                  top.layer.msg(d.msg);
                  $("#username").val("");
                  $("#username").focus();
              }
          }
        });
    });

    form.on("submit(addStudent)",function (data) {
        var index=top.layer.msg('数据提交中，请稍候',{icon:16,time:false,shade:0.2});
        var index1=parent.layer.getFrameIndex(window.name); //获取 学生列表 窗口
        var msg,flag=false;
        $.ajax({
            type:"post",
            url:ctx+"/student/insertStudent",
            async:false,
            data:data.field,
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="用户添加成功";
                    flag=true;
                    $("#auf")[0].reset(); //表单中元素恢复默认值
                }
                else
                {
                    msg=d.msg;
                }
            },
            error:function () {
                layer.msg("添加失败，请检查sql及输出",{icon:2});
            }

        });
        setTimeout(function () {
            parent.layer.close(index1);
            top.layer.close(index);
            if(flag)
            {
                top.layer.msg(msg,{icon:1});
            }
            else
            {
                top.layer.msg(msg,{icon:5});
            }
            parent.location.reload();
        },1500);
        return false;
    })

});