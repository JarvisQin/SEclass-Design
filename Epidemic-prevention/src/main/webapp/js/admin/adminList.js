/**
 * 简单来说： == 代表相同， ===代表严格相同, 为啥这么说呢，

 这么理解： 当进行双等号比较时候： 先检查两个操作数数据类型，
 如果相同， 则进行===比较， 如果不同， 则愿意为你进行一次类型转换，
 转换成相同类型后再进行比较， 而===比较时， 如果类型不同，直接就是false.
 *
 * */

layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function () {
    var form=layui.form,table=layui.table;
    layer=parent.layer===undefined ? layui.layer:parent.layer,
    laypage=layui.laypage;
    $=layui.jquery;
    //表格数据
    table.render({
            id: 'adminList',
            elem: '#adminList',//指定原始 table 容器的选择器或 DOM，方法渲染方式必填
            url:ctx+'/admin/getAdminList',

            cellMinWidth:80,

            limit:10, //每页显示的条数
            limits:[10,20,30,40], //每页条数的选择项
            cols:[[ //设置表头 值是一个二维数组
                 //允许排序
                {field:'username',title:'用户名',align:'center'},
                {field:'adminId',title:'ID',align:'center'},
                {field:'nickname',title:'昵称',align:'center'},
                {field:'email',title:'邮箱',align:'center'},
                {field:'sex',title:'性别',templet:'#sexTpl', align:'center'},//templet 自定义列模板 #sexTpl是绑定的选择器
                {field:'phone',title:'联系方式',align:'center'},
                {field:'roleName',title:'角色',align:'center'},
                {title:'操作',toolbar:'#barEdit', align:'center'}
            ]],
            page:true //开启分页
        });
        //监听工具条
        table.on('tool(test)',function (obj) { //test 是 table 原始容器的属性 lay-filter="对应的值
            var data=obj.data, adminId=$("#adminId").val();//data获得当前行数据
            if(obj.event==='del')
            {
                if(data.id==adminId)
                {
                    layer.msg("不允许删除自己!",{icon:5});
                    return ;
                }
                alert(adminId);
                alert(data.admin_id);
                layer.confirm('真的删除吗？',function (index) {
                    $.ajax({
                        url:ctx+"/admin/delAdminById/"+data.admin_id, // 发送的是/admin/delAdminById/7
                        type:"get",
                        success:function (d) {
                                if(d.code==0) //删除成功
                                {
                                    table.reload('adminList',{})

                                }
                                else
                                {
                                    layer.msg("权限不足,联系超管！",{icon:5});
                                }
                        }
                    })
                    layer.close(index); //删除上面的确认窗口index是function的参数
                });
            }
            else if(obj.event==='edit')
            {
                if(data.admin_id=='1')
                {
                    layer.msg("不允许编辑此用户！",{icon:5});
                    return;
                }
                if(data.admin_id==adminId)
                {
                    layer.msg("不允许编辑自己！",{icon:5});
                    return;
                }
                layer.open({ //发送请求 controller返回一个jsp页面 加载在这个open的弹出窗口中
                    type:2,
                    title:"编辑角色",
                    area:['380px','560px'],
                    content:ctx+"/admin/editAdmin/"+data.admin_id  // 发送的是/admin/editAdmin/4
                })
            }
            });
        //添加角色 通过选择样式 选择

    //添加角色
    $(".adminAdd_btn").click(function(){
        var index = layer.open({
            title : "添加管理员",
            type : 2,
            content : ctx+"/admin/addAdmin",
            area: ['450px', '570px'],

        })

        $(window).resize(function(){
            layui.layer.full(index);
        })
    })
});

