
function navBar(strData){
    var data;
    if(typeof(strData) == "string")
    {
        var data = JSON.parse(strData); //如果用户解析出来的是字符串

    }else {
        data = strData;
    }
    var ulHtml = '<ul class="layui-nav layui-nav-tree">'; //这里相当于jsp中的页面元素编写 拼接过程
    for(var i=0;i<data.length;i++)
    {
        if(data[i].spread) //true 表明这个菜单要展开
        {
            ulHtml += '<li class="layui-nav-item">';
        }else
        {
            ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
        }
        if(data[i].children != undefined && data[i].children.length > 0) //此菜单有子菜单
        {
            ulHtml += '<a href="javascript:;">';
            if(data[i].icon != undefined && data[i].icon != '')
            {
                //icon表示图标 之前版本都是用unicode 字符表示图标 如 &#xe66f; 代表用户图标
                //后来版本 可以这样定义一个笑脸图标
                //<i className="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #1E9FFF;"></i>
                if(data[i].icon.indexOf("icon-") != -1) //fontClass方式
                {
                   // ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                    ulHtml += '<i class="layui-icon  '+data[i].icon+'"></i>';
                }else //unicode定义图标
                {
                    ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';

                }
            }
            ulHtml += '<cite>'+data[i].name+'</cite>';  //菜单名称
            ulHtml += '<span class="layui-nav-more"></span>';
            ulHtml += '</a>';
            ulHtml += '<dl class="layui-nav-child">';  //开始添加子菜单
            for(var j=0;j<data[i].children.length;j++)
            {
                //显然children里面没有target属性 这里不会报错 只会提示undefined 继续执行
                //如果data[i]为空 才会报错
                if(data[i].children[j].target == "_blank")
                {
                    ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'" target="'+data
                        [i].children[j].target+'">';
                }else
                {
                    ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'">';
                }
                if(data[i].children[j].icon != undefined && data[i].children[j].icon != '')
                {
                    if(data[i].children[j].icon.indexOf("icon-") != -1)
                    {
                        ulHtml += '<i class="layui-icon  '+data[i].children[j].icon+'"></i>';
                    }else
                    {
                        ulHtml += '<i class="layui-icon" data-icon="'+data[i].children[j].icon+'">'+data
                            [i].children[j].icon+'</i>';

                    }
                }
                ulHtml += '<cite>'+data[i].children[j].name+'</cite></a></dd>'; //子菜单名称
            }
            ulHtml += "</dl>";
        }
        else //如果没有子菜单
        {
            if(data[i].target == "_blank")
            {
                ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'" target="'+data[i].target+'">';
            }
            else
            {
                ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'">';
            }
            if(data[i].icon != undefined && data[i].icon != '')
            {
                if(data[i].icon.indexOf("icon-") != -1)
                {
                    ulHtml += '<i class="layui-icon  '+data[i].icon+'"></i>';
                }
                else
                {
                     ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';

                }
            }
            ulHtml += '<cite>'+data[i].name+'</cite></a>';
        }
        ulHtml += '</li>';
    }
    ulHtml += '</ul>';
    return ulHtml;
}


