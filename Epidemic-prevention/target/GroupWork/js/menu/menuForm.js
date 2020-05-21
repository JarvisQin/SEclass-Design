var $;
var $form;
var form;
layui.config({
    base : "/js/" //必须是 /js/ 两个/ / 都有 否则 js下的iconPicker加载不成功
}).use(['form','layer','jquery','laydate','iconPicker'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate,iconPicker = layui.iconPicker;
    $ = layui.jquery;
    form = layui.form;

    iconPicker.render({
        // 选择器，推荐使用input
        elem: '#iconPicker',
        // 数据类型：fontClass/unicode，推荐使用fontClass
        type: 'fontClass',
        // 是否开启搜索：true/false
        search: true,
        // 是否开启分页
        page: true,
        // 每页显示数量，默认12
        limit: 12,
        // 点击回调
        click: function (data) {
            console.log(data);
        }
    });
    /**
     * 选中图标
     * @param filter lay-filter
     * @param iconName 图标名称，自动识别fontClass/unicode
     */
    //弹出时 显示的默认图标 如果没有点击 选择图标 那么数据库中此菜单就没有图标 不是绑定默认图标
    iconPicker.checkIcon('iconPicker', 'layui-icon-rate-solid');




    $("#sorting").blur(function () {

        var menuLevel=parseInt($("#menuLevel").val()); //parseInt将内容转换成数字
        var sort=parseInt($("#sorting").val());

        /*
        layer.confirm('菜单级别'+$("#menuLevel").val()+'排序值'+$("#sorting").val(),function (index) {
            layer.close(index);
            $("#sorting").val('');
        });
        */
        switch (menuLevel) {
            case 1:
                if(sort>99)
                {
                    //confirm中两个function依次是确定 取消的处理函数
                    layer.confirm('一级菜单排序1-99',function (index) {
                            layer.close(index);
                            $("#sorting").val('');
                        },
                        function (index) {
                            layer.close(index);
                            $("#sorting").val('');
                        });

                }
                break;
            case 2:
                if(sort>999||sort<111)
                {
                    layer.confirm('二级菜单排序111-999',function (index) {
                            layer.close(index);
                            $("#sorting").val('');
                        },
                        function (index) {
                            layer.close(index);
                            $("#sorting").val('');
                        });
                }
                break;
            case 3:
                    if(sort>9999||sort<1111 )
                    {
                        layer.confirm('三级菜单排序1111-9999',function (index) {
                            layer.close(index);
                            $("#sorting").val('');
                        },
                            function (index) {
                                layer.close(index);
                                $("#sorting").val('');
                            });
                    }
                    break;
            default:break;
        }

    });

    form.on("submit(menuForm)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg="发生错误！",flag=false;
        $.ajax({
            type: "post",
            url: ctx+"/admin/menuForm",
            data:data.field,
            dataType:"json",
            async:false,
            success:function(d){
                msg=d.msg;
            },
            error:function() {
                flag=true;
                top.layer.close(index);
                $("#menuF")[0].reset();
                layer.msg("发生错误，请检查输入！"); }
        });
        setTimeout(function(){
            if(!flag){
                top.layer.close(index);
                top.layer.msg(msg);
                layer.closeAll("iframe");

                //添加菜单的时候 会自动刷新 但是编辑菜单的时候不会自动刷新！！！？？？？？？why？？？
                //应该是menuList.js中 $("#editMenu") $("#addMenu")中layer.open函数不同
                //现在编辑菜单也能自动刷新了 跟之前那个窗口不在最上层一样 估计是电脑反应慢的原因！！！！！！！！！！！！！！！
                setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                    //刷新父页面
                    top.location.reload();
                },1000);

            }
        },2000);
        return false;
    })
})