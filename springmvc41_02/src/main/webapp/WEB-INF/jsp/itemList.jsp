﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<a href="/logout.action">退出系统</a>
<form action="${pageContext.request.contextPath }/queryItem.action" method="post">
    查询条件：
    <table width="100%" border=1>
       <tr>
           <td>根据id查询<input type="text" name="id"/></td>
       </tr>
       <tr>
           <td>根据name查询<input type="text" name="item.name"/></td>
       </tr>
        <tr>
              <td><input type="submit" value="查询"/></td>
           <%-- <td><input type="submit" value="批量删除"/></td>--%>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <!--
            varStatus 可以获取循环的状态信息:
                index属性 0
                count个数
        -->
        <c:forEach items="${itemList }" var="item" varStatus="st">
            <tr>
                <td><input type="checkbox" name="ids" value="${item.id}" /></td>
                <td>
                    <input type="hidden" value="${item.id }" name="list[${st.index}].id" />
                    <input type="text" value="${item.name }" name="list[${st.index}].name" /></td>
                <td><input type="text" value="${item.price }" name="list[${st.index}].price" /></td>
                <td><input type="text"   name="list[${st.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /> </td>
                <td><input type="text" value="${item.detail }" name="list[${st.index}].detail" /></td>
                <td><a href="${pageContext.request.contextPath }/itemEdit.action?abc=${item.id}">修改</a>
                        <%--<a href="${pageContext.request.contextPath }/itemEdit/${item.id}">修改</a>--%>
                </td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>