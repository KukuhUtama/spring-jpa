<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Update User</h2>
        <form:form action="${root}/user/update-user.html"  modelAttribute="user" method="post">
        <input type="hidden" "id" name="id" value="${user.id}">
            <table border="0" cellpadding="1">
                <tr>
                    <td>User Name: </td>
                    <td><input id="userName" name="userName" value="${user.userName}"></td>
                </tr>  
                <tr>
                    <td>Password: </td>
                    <td><input id="password" name="password" value="${user.password}"></td>
                </tr> 
                <tr>
                    <td colspan="2"><input type="submit" value="Update"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>