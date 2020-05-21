layui.use(['form','layer','jquery','table'],function () {
    var layer=layui.layer;
    var $=layui.jquery;
    var form=layui.form;
    var table=layui.table;
    table.render({
      id:'logList',
      elem:'#adminLogList',
      url:ctx+"/admin/getAdminLogList",
      limit:10,
      limits:[10,20,30,40,],
      cols:[[
          {field:'id',title:'ID',fixed:'left',width:80,sort:true},
          {field:'adminUsername',title:'登录名',align:'center'},
          {field:'loginIp',title:'登录IP',align:'center'},

          {field:'loginTime', title: '登录时间' ,align: 'center',templet : '<div>{{ formatTime(d.loginTime,0,"yyyy-MM-dd hh:mm:ss")}}</div>' },
          {field:'logoutTime', title: '退出时间' ,align: 'center',templet : '<div>{{ formatTime(d.logoutTime,d.loginTime,"yyyy-MM-dd hh:mm:ss")}}</div>' },

          {field:'isSafeExit',title:'是否安全退出',templet:'#isSafeExitTpl',align:'center'},

      ]],
        page:true,
        loading:true
    });

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