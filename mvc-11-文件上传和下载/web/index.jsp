<%--
  Created by IntelliJ IDEA.
  User: 25301
  Date: 2020/7/29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>文件上传</h1>
  <form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>
  <h1>文件上传2</h1>
  <form action="${pageContext.request.contextPath}/upload2.do" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>
  <h1>文件下载</h1>
  <a href="${pageContext.request.contextPath}/download.do">点击下载</a>
  </body>
</html>
