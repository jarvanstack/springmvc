
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--1.导入包jquery--%>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script>
  function test01(){
    var name = $("#username").val();
    $.ajax({
      url:"${pageContext.request.contextPath}/test01" ,
      data:{'name':name},
      type:"post",
      success:function (data) {
        alert(data);
      },
      error:function (data) {
        alert(data);
      }
    });//这个分号一定能要记得加上..
  }
 //============test02=================
  function test02(){
    var tbody = document.getElementById("tbody");
    $.ajax({
      url:"${pageContext.request.contextPath}/test02" ,
      type:"post",
      success:function (data) {
        console.log(data);
        var content = "";
        for (let i = 0; i < data.length; i++) {
          content += "<tr>" +
                  "<td>"+data[i].name+"</td>"
                  "<td>"+data[i].age+"</td>"
                  "</tr>";
        }
        console.log(content)
        //写入到HTML里面
        $("#tbody").html(content);
      },
      error:function (data) {
        alert(data);
      }
    });
  }
</script>
<html>
  <head>
    <title>Ajax</title>
  </head>
  <body>
  <h2>1.ajax初体验，失去焦点验证</h2>
  <input type="text" placeholder="用户" name = "username" id="username" value="管理员" onblur="test01()">

  <h1>=========test02=========</h1>
  <h2>点击按钮 遍历数据输出</h2>
  <button value="点击" onclick="test02()">点击</button>
  <table width="80%" align="center">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
    </tr>
    <tbody id="tbody">

    </tbody>
  </table>
<%--  //<h2>==========狂神代码无修改==========</h2>--%>
  <h2>==========狂神代码无修改==========</h2>
  <input type="button" id="btn" value="获取数据"/>
  <table width="80%" align="center">
    <tr>
      <td>姓名</td>
      <td>年龄</td>
    </tr>
    <tbody id="content">
    </tbody>
  </table>
  <script>

    $(function () {
      $("#btn").click(function () {
        $.post("${pageContext.request.contextPath}/a2",function (data) {
          console.log(data)
          var html="";
          for (var i = 0; i <data.length ; i++) {
            html+= "<tr>" +
                    "<td>" + data[i].name + "</td>" +
                    "<td>" + data[i].age + "</td>" +
                    "</tr>"
          }
          $("#content").html(html);
        });
      })
    })
  </script>
  </body>
</html>
