<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Url</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Update Url</h2>
        <form:form action="${root}/url/update-url.html"  modelAttribute="url" method="post">
        <input type="hidden" "id" name="id" value="${url.id}">
            <table border="0" cellpadding="1">
                <tr>
                    <td>Url Address: </td>
                    <td><input id="urlAddress" name="urlAddress" value="${url.urlAddress}"></td>
                </tr>  
                <tr>
                    <td colspan="2"><input type="submit" value="Update"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>