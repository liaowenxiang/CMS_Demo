<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html charset=utf-8" >
    <meta name="Keywords" content="批量导入">
    <meta name="Description" content="大数据批量导入">
    <title>大数据批量导入</title>
    <style type="text/css">
        *{margin: 0px}
        body{font-size: 12px;font-family: 微软雅黑;color: #666}
        /*S title*/
        .title{text-align: center;line-height: 100px;font-size: 24px}
        /*E title*/

        /*S content*/
        .content{width: 800px;margin: 0 auto;}
        .content .c-upload{width: 140px;height: 38px;display: block;color: #fff;
            background: #6cf;line-height: 38px;text-decoration: none;text-align: center;
            border-radius: 3px}
        .content .c-upload:hover{background: #3cf}
        .content .c-box{width: 800px;margin: 30px 0; border-top: 1px solid #e5e5e5;
            border-bottom: 1px solid #e5e5e5}
        .content .c-box .c-list{margin: 20px 0;padding-left: 10px}
        .content .c-box .c-list p{ line-height: 45px;font-size: 14px}
        .content .c-box .c-list:hover{background: #f2f2f2;}
        /*E content*/
    </style>
</head>
<body>
    <!--S title-->
    <h1 class="title">大数据批量导入</h1>
    <!--E title-->
    <!--S content-->
    <div class="content">
        <a href="#" class="c-upload">上传批量数据</a>
        <div class="c-box">
            <div class="c-list">
                <p class="c-title">第一节课的名称</p>
                <p class="c-desc">第一节课的描述</p>
            </div>
            <div class="c-list">
                <p class="c-title">第一节课的名称</p>
                <p class="c-desc">第一节课的描述</p>
            </div>
            <div class="c-list">
                <p class="c-title">第一节课的名称</p>
                <p class="c-desc">第一节课的描述</p>
            </div>
        </div>
    </div>
    <!--E content-->
    <script type="text/javascript" src="js/jquery-3.2.0.slim.min.js"></script>
    <script>
        $(function () {
            $(".c-upload").click(function (e) {
                $.ajax({
                    type:"post",
                    beforeSend:function (data) {
                        //解析中...
                    },
                    url:"",
                    success:function () {
                        alert("success");
                    }
                })
            })
        })
    </script>
</body>
</html>