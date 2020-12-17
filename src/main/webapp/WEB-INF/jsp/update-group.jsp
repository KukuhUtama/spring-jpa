<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:if test = "${isUpdate eq true}">
<title>Update Group</title>
</c:if>
<c:if test = "${isUpdate eq false}">
<title>Add Group</title>
</c:if>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Update Group</h2>
        <form:form action="${root}/group/update-group.html"  modelAttribute="group" method="POST">
            <input type="hidden" "id" name="id" value="${group.id}">
            <table border="0" cellpadding="1">
                <tr>
                    <td>Group Name: </td>
                    <td><input id="groupName" name="groupName" value="${group.groupName}"></td>
                </tr>  
                <tr>
                     <td colspan="2"><input type="submit" value="Update"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>