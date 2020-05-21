
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery','excel','laypage','table'],function () {
    var form=layui.form,table=layui.table,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
    $=layui.jquery;
    var excel=layui.excel;



    //数据表格
    table.render({
        id:'fixList',
        elem:'#fixList',
        url:ctx+"/fix/getFixList", //数据接口
        cellMinWidth:80,
        //toolbar:true,
        //title:'打扫记录表',
        //totalRow:true,
        limit:10,//每页条数
        limits:[10,20,30,40],
        cols:[[ //表头
            {field:'id',title:'ID',sort:true,align:'center',width:120},

            {field:'fixTime', title: '维修时间' ,align: 'center',templet : '<div>{{ formatTime(d.fixTime,0,"yyyy-MM-dd hh:mm:ss")}}</div>' },

            {field:'dormitoryNumber',title:'宿舍名称',align:'center',templet: '<div>{{d.dormitory.dormitoryNumber}}</div>'},
            {field:'username',title:'维修人员姓名',align:'center',templet: '<div>{{d.admin.username}}</div>'},
            {field:'fixStatus',title:'维修状况',align:'center',width:110,templet:'#fixTpl'},
            {field:'fixNote',title:'维修内容',align:'center',width:120},
            {title:'操作',toolbar:'#barEdit',align:'center'}
        ]],
        page:true
    });
    //监听工具条
    table.on('tool(fixList)',function (obj) {
        var data=obj.data;
        if(obj.event=='del')
        {

            layer.confirm('真的删除吗？',function (index) {
                $.ajax({
                    url:ctx+"/fix/delFix/"+data.id,
                    type:"get",
                    success:function (d) {
                        if(d.code==0)
                        {
                            table.reload('fixList',{});//重新发送请求 表格重载
                        }
                        else
                        {
                            layer.msg("查看sql输出，有错误",{icon:5});
                        }
                    },
                    error:function (jqXHR, textStatus, errorThrown) {
                        layer.alert("获取数据失败! 先检查sql 及 Tomcat Localhost Log 的输出");
                    }
                })
                layer.close(index); //删除上面的确认窗口index是function的参数
            });
        }
        else if(obj.event=='edit')
        {
            layer.open({
                type:2,
                title:"编辑角色",
                area:['380px','600px'],
                content:ctx+"/fix/editFix/"+data.id
            })
        }
    });
    //添加记录
    $(".fixAdd_btn").click(function () {
        var index=layer.open({
            title:"添加维修记录",
            type:2,
            content:ctx+"/fix/addFix",
            area:['380px','550px']
        });
        //改变窗口大小时 重置窗口的高度 防止超出可视区域 如F12调出debig操作
        $(window).resize(function () {
            layui.layer.full(index);
        })
    });


    /*
        layui excel的导出 要求后台传过来的不能是联表查询的结果 否则有些数据是转换不过来的
        比如这里的宿舍名称 对应的clean实体类里只有dormitoryId 然后根据这个ID再查宿舍名称
        这样的数据 没法导出excel

        //导出excel表格 这里是导出全部 不是导出当前页
        $("#exportexcel").click(function(){

            loading = layer.load(1, {shade: [0.3, '#fff']});

            $.ajax({
                url: ctx+"/clean/getAllCleanList",
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function(data) {
                    layer.close(loading);
                   // layer.msg(res.msg);
                    // 假如返回的 res.data 是需要导出的列表数据
                    // 重点！！！如果后端给的数据顺序和映射关系不对，请执行梳理函数后导出
                    //限定能出现的字段
                    var dt = excel.filterExportData(data, [
                        'id'
                        ,'cleanTime'
                        ,'dormitoryNumber'
                        ,'username'
                        ,'cleanLevel'
                    ]);
                    // 重点2！！！一般都需要加一个表头，表头的键名顺序需要与最终导出的数据一致
                    // 1. 数组头部新增表头
                    dt.unshift({id: '记录ID',cleanTime: '打扫时间',dormitoryNumber:'宿舍名称',
                        username:'打扫学生姓名',cleanLevel:'打扫评分'});
                    // 3. 执行导出函数，系统会弹出弹框
                    // 重点！！！如果后端给的数据顺序和映射关系不对，请执行梳理函数后导出


                    var timestart = Date.now();
                    excel.exportExcel({
                        sheet1: dt
                    }, '打扫记录.xlsx', 'xlsx');
                    var timeend = Date.now();
                    var spent = (timeend - timestart) / 1000;
                    layer.alert('单纯导出耗时 '+spent+' s');
                },
                error:function(){
                    layer.close(loading);
                    layer.msg("出错，请检查ajax");
                }
            });

        })
    */

});


//格式化时间 后台穿过来的是 CST时间格式 前台转化成yyyy-MM-dd hh:mm:ss 格式
function formatTime(datetime,datetime1, fmt) {
    if(datetime==datetime1) //因为登录后 loginTime 和logoutTime一样 这样 转换logoutTime的时候显示为空
    {
        return "";
    }
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime)
    {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+" : datetime.getMonth() + 1, // 月份
        "d+" : datetime.getDate(), // 日
        "h+" : datetime.getHours(), // 小时
        "m+" : datetime.getMinutes(), // 分
        "s+" : datetime.getSeconds(), // 秒
        "q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
        "S" : datetime.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                    .substr(("" + o[k]).length)));
    return fmt;
}