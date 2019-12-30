<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/15
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
    <script src="../static/js/jquery-3.4.1.min.js"></script>
    <script src="../static/js/jquery.form.js"></script>
</head>
<body>
<form action="" method="post" enctype="multipart/form-data" id="img">
    <input type="file" name="file" onchange="upload()"> <br>
    <img src="" id="src">
</form>

<script type="text/javascript">
       function upload() {
           console.log("图片上传");
           var formData = new FormData(document.getElementById("img"));
           $.ajax({
               url:"/image/upload",
               type:"post",
               data:formData,
               cache:false,
               contentType:false,
               processData: false,
               success:function (data){
                   var data = JSON.parse(data);
                   console.log(data.img)
                   $("#src").attr("src",data.img)
               }
           })

       }

</script>
</body>
</html>
