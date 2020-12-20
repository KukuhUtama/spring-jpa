<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Add User</title>

</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Add New User</h2>
        <form:form action="${root}/user/add-user.html"  modelAttribute="user" method="post">
            <table border="0" cellpadding="1">
                <tr>
                    <td>User Name: </td>
                    <td><input id="userName" name="userName" value="${user.userName}"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" id="password" name="password" value="${user.password}"></td>
                </tr>    
                <tr>
                    <td>Confirm Password: </td>
                    <td><input type="password" id="passwordConfirm" name="passwordConfirm" value="${user.passwordConfirm}"></td>
                </tr>  
                <tr>
                     <td>Is Active</td>
                     <td><input type="checkbox" id="isActive" name="isActive" value="true"> </td>
                </tr>
                <tr>
                     <td colspan="2"><input type="submit" value="save"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>