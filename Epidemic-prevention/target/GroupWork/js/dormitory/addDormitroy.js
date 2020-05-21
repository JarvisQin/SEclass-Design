
var $;
var $form;
var form;
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery','upload'],function () {
    var layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
    $=layui.jquery;
    upload = layui.upload;
    form=layui.form;


    upload.render({  //这里是上传一张图片
        elem:"#SingleUpload",
        url:ctx+"/dormitory/singleUpload",
        done: function(res, index, upload){
            //假设code=0代表上传成功
            if(res.code == 0){
                layer.msg("文件异步加载成功！",{icon:1});
                $("#simpleImg").attr("src",res.image);
                $("#SingleUpload").addClass("layui-btn-disabled");
                $("#SingleUpload").off("click");
            }
        }
    });


    var demoListView = $('#detailsList')
        ,uploadListIns = upload.render({ //这里是上传多张图片
        elem: '#MultipleUpload'
        ,url:ctx+ "/dormitory/MultipleUpload"
        ,accept: 'file'
        ,multiple: true
        ,auto: false
        ,bindAction: '#testListAction'
        ,choose: function(obj){
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function(index, file, result){
                var tr = $(['<tr id="upload-'+ index +'">'
                    ,'<td>'+ file.name +'</td>'
                    ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                    ,'<td>等待上传</td>'
                    ,'<td>'
                    ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                    ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                    ,'</td>'
                    ,'</tr>'].join(''));

                //单个重传
                tr.find('.demo-reload').on('click', function(){
                    obj.upload(index, file);
                });

                //删除
                tr.find('.demo-delete').on('click', function(){
                    delete files[index]; //删除对应的文件
                    tr.remove();
                    uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                });

                demoListView.append(tr);
            });
        }
        ,done: function(res, index, upload){
            if(res.code == 0){ //上传成功
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html(''); //清空操作
                return delete this.files[index]; //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        }
        ,error: function(index, upload){
            var tr = demoListView.find('tr#upload-'+ index)
                ,tds = tr.children();
            tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    });





    $("#dormitoryNumber").blur(function () {
        $.ajax({
            type:"get",
            url:ctx+"/dormitory/checkDormitoryNumber/"+$("#dormitoryNumber").val(),
            success:function (data) {
                if(data.code!=0)
                {
                    top.layer.msg(data.msg);//top.layer 表示在最顶层弹出窗口
                    $("#dormitoryNumber").val(""); //清空原来的输入
                    $("#dormitoryNumber").focus();//焦点重新定位到username
                }
            }
        });
    });
    form.on("submit(addDormitory)",function (data) {
        var index=top.layer.msg('数据提交中，请稍候。',{icon:16,time:false,shade:0.8});
        var msg;
        $.ajax({
            type: "post",
            url:ctx+"/dormitory/insDormitory",
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
            /*
            top.layer.close(index);
            layer.closeAll("iframe");
            setTimeout(function () {  //添加一个 延时 否则接着刷新 看不到提示的信息
                //刷新父页面
                top.location.reload();
            },1000);
            */
            top.layer.msg("添加成功", { shift: -1, time: 2000 },function () {
                parent.location.reload();  //shift: -1表示提示信息不抖动 2秒后调用回调函数
            });
        },2000);  //在点击提交后2秒执行 setTimeout中的function函数

        return false;
    })
});


