/**

 jQuery的serialize()方法通过序列化表单值，创建URL编码文本字符串，
 我们就可以选择一个或多个表单元素，也可以直接选择form将其序列化，如：

 <form action="">
 First name: <input type="text" name="FirstName" value="Bill" /><br />
 Last name: <input type="text" name="LastName" value="Gates" /><br />
 </form>
 $(document).ready(function(){
    console.log($("form").serialize()); // FirstName=Bill&LastName=Gates
});
 这样，我们就可以把序列化的值传给ajax()作为url的参数，轻松使用ajax()提交form表单了，
 而不需要一个一个获取表单中的值然后传给ajax()
 */




var $;
layui.config({
    base:"/js/"
}).use(['form','layer','jquery'],function () {
    var form=layui.form,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.layPage;
    $=layui.jquery;
    form.on("submit(editRole)",function (data) {
        var treeObj=$.fn.zTree.getZTreeObj("xtree1");
        var list=treeObj.getCheckedNodes(true);//获取输入框被勾选的节点集合
        //菜单id
        var mStr="";
        for(var i=0;i<list.length;i++)
        {
            mStr+=list[i].menuId+","; //"1,2,3,4" 这种格式
        }
        //去除字符串尾部的 ，
        mStr=mStr.substring(0,mStr.length-1);
        var m=$("#m");
        m.val(mStr);//将字符串 写入隐藏的携带参数
        //弹出loading
        var index=top.layer.msg('数据提交中,请稍候',{icon:16,time:false,shade:0.8});
        setTimeout(function () {
            $.ajax({
                type: "POST",
                async:false,//当async属性的值为false时是同步的，Ajax请求将整个浏览器锁死，
                // 只有ajax请求返回结果后，才执行ajax后面的语句。当async属性的值为true时是异步的，
                // 即不会等待ajax请求返回的结果，会直接执行ajax后面的语句。
                url:ctx+"/admin/updateRole",
                data:$("#arf").serialize()//最上面有解释  用data.field 可以 但是只能将Role对应
                // 属性的值传过去 jsp中隐藏的m 不能传过去 即使 controller中updateRole(Role role,String m)
                //有参数m也不行  使用data:$("#arf").serialize() 可以将所有的参数传过去包括 m
                //如果非要使用data:data.field,  可以将m放在url后面 这样controller中函数取值参数也要变

            });
            top.layer.close(index);
            top.layer.msg("角色修改成功");
            layer.closeAll("iframe");
            //parent.location.reload();
            setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                //刷新父页面
                parent.location.reload();
            },1000);
        },2000);
        return false;
    })
    //角色名称唯一性校验
    $("#roleName").blur(function () {  //失去焦点 调用函数
        //layer.msg($("#roleName").val());
        $.ajax({
            type:"get",
            url:ctx+"/admin/checkRoleName/"+$("#roleName").val()+"/"+$("#roleId").val(),
            /*
            data:{    //controller接受的函数是 checkRoleName(String roleName,Long roleId)
                // 这里又不是form提交 所以不会自动检查参数同名赋值 用data.field 不行
                //这种方法 controller接受的函数也不一样
                roleName:$("#roleName").val(),
                roleId:$("#roleId").val()
            },
            */

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


var roleId=$("#roleId").val(); //loadMenuTree中ajax函数用到的参数
//这个menu是权限树的配置参数
var menu ={
    setting: {
        view:{
            showIcon: false, //不显示图标
        },
        data:{
            simpleData: {
                enable:true,//如果设置为 true，请务必设置 setting.data.simpleData
                // 内的其他参数: idKey / pIdKey / rootPId，并且让数据满足父子关系。
                idKey: "menuId",
                pIdKey: "parentId", //这两个参数都是我们Menu实体类的属性
            },
            key:{
                name:"name", //我们Menu实体类的属性 代表菜单名称 这里将菜单名称作为节点名称
            }
        },
        check:{
            enable:true //显示单选框或者复选框
        }
    },
    //获取菜单数据的ajax请求
    loadMenuTree:function () {
        $.ajax({
            type:"post",
            url:ctx+"/admin/xtreedata",
            data:{roleId:roleId}, //这个应该也是jsp种隐藏的请求参数 代表当前选中的角色 roleId
            dataType:"json",
            success:function (data) {
                $.fn.zTree.init($("#xtree1"),menu.setting,data); //初始化权限树
                // 执行后 权限树就可以显示出来 同时属于本角色的菜单处于选中状态
            }
        })
    }

};
$().ready(function (data) {
    menu.loadMenuTree(); //js一加载就调用此函数
});

function checkNode(e) {
    var zTree=$.fn.zTree.getZTreeObj("xtree1");
    type=e.data.type; //获得的是 $("#checkAllTrue").bind("click",{type:"checkAllTrue"},checkNode);中的type参数值
    nodes=zTree.getSelectedNodes();
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















