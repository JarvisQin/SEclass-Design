var $;
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery'],function () {
    var form=layui.form;
    layer=parent.layer===undefined?layui.layer:parent.layer;
    $=layui.jquery;
    laypage=layui.laypage;
    form.on("submit(addRole)",function (data) {
      var treeObj=$.fn.zTree.getZTreeObj("xtree1");
      var list=treeObj.getCheckedNodes(true);
      //菜单id
       var mStr="";
       for(var i=0;i<list.length;i++)
       {
           mStr+=list[i].menuId+",";
       }
       //去掉字符串尾的 “，”
        mStr=mStr.substring(0,mStr.length-1);
       var m=$("#m");
       //将菜单写进隐藏域
        m.val(mStr);
        //弹出loading
        var index=top.layer.msg('数据提交中，请稍候！',{icon:16,time:false,shade:0.8});
        var msg;
        $.ajax({
            type:"POST",
            url:ctx+"/admin/insRole",
            data:$("#arf").serialize(),
            success:function (d) {
                if(d.code==0)
                {
                    msg="添加成功";
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
            top.layer.close(index);
            top.layer.msg(msg); //这个信息往往刚显示就让parent.location.reload();刷新了 看不到
            layer.closeAll("iframe");

            //parent.location.reload();
            setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                //刷新父页面
                parent.location.reload();
            },1000);
        },2000);
        return false;
    })
    //角色名唯一性校验
    $("#roleName").blur(function () {
            $.ajax({
                type:"get",
                url:ctx+"/admin/checkAddRoleName/"+$("#roleName").val(),
                success:function (data) {
                        if(data.code!=0)
                        {
                            top.layer.msg(data.msg);
                            $("#roleName").val("");
                            $("#roleName").focus();
                        }
                }
            });
    });
});

var menu = {
    setting: {
        view: {
            showIcon: false,
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "menuId",
                pIdKey: "parentId",
            },
            key: {
                name: "name"
            }
        },
        check: {
            enable: true
        }
    },
    loadMenuTree:function () {
        $.ajax({
            type:"post",
            url:ctx+"/admin/xtreedata",
            dataType:"json",
            success:function (data) {
                $.fn.zTree.init($("#xtree1"),menu.setting,data);
            }
        })
    }
};
$().ready(function () {
   menu.loadMenuTree();
});

function checkNode(e)
{
    var zTree=$.fn.zTree.getZTreeObj("xtree1");
    var type=e.data.type;
    var nodes=zTree.getSelectedNodes();
    if(type.indexOf("All")<0&&nodes.length==0)
    {
        alert("请先选择一个节点");
    }
    if(type=="checkAllTrue")
    {
        zTree.checkAllNodes(true);
    }
    else if(type=="checkAllFalse")
    {
        zTree.checkAllNodes(false);
    }
}

$("#checkAllTrue").bind("click",{type:"checkAllTrue"},checkNode);
$("#checkAllFalse").bind("click",{type:"checkAllFalse"},checkNode);








