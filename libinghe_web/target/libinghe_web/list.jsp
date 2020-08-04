<%@ page import="com.xiaohe.service.TypeService" %>
<%@ page import="com.xiaohe.service.impl.TypeServiceImpl" %>
<%@ page import="com.xiaohe.pojo.Type" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>页面展示</title>
</head>
<%
//    TypeServiceImpl typeService = new TypeServiceImpl();
//    List<Type> typeList = typeService.findAll();
//    request.setAttribute("typeList", typeList);
%>
<script type="application/javascript" src="/js/jquery-1.8.3.js"></script>
<body>
        <form>
            文档分类:<select required="required" >
            <option>全部</option>
            <c:forEach items="${files}" var="file">
                <option value="${file.type_id}">${file.type.type_name}</option>
            </c:forEach>
        </select>
            <input type="submit" value="查询">
        </form>
        <form action="file/upload" method="post" enctype="multipart/form-data">
            <button value="新增电子文档" onclick=""></button>
        </form>
        <table border="1px" align="center">
            <h2 align="center">电子文档列表</h2>
            <tr>
                <th>文档编号</th>
                <th>文档名称</th>
                <th>文档摘要</th>
                <th>上传人</th>
                <th>上传时间</th>
                <th>文档类型</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${files}" var="file">
                <tr>
                    <td>${file.id}</td>
                    <td>${file.file_name}</td>
                    <td>${file.content}</td>
                    <td>${file.upload_name}</td>
                    <td>${file.upload_date}</td>
                    <td>${file.type.type_name}</td>
                    <td><a href="/file/deleteById?id=${file.id}" onclick="if(confirm('是否确定删除'+'${file.file_name}'+'？')==false)return false">删除</a>   更新</td>
                </tr>
            </c:forEach>
        </table>

</body>
<script>
   function showTypeName(){

    }
</script>
</html>
