<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Role</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Update Role</h2>
        <form:form action="${root}/role/update-role.html"  modelAttribute="role" method="post">
        <input type="hidden" "id" name="id" value="${role.id}">
            <table border="0" cellpadding="1">
                <tr>
                    <td>Role Name: </td>
                    <td><input id="roleName" name="roleName" value="${role.roleName}"></td>
                </tr>  
                <tr>
                  <td>Url Address: </td>
                  <td>
                  <c:forEach items="${listOfUrl}" var="url">
						<c:set var="currUrlId" value="${url.id}"></c:set>
						<c:set var="isSelected" value="0"></c:set>
						<c:forEach items="${listUrlSelected}" var="urlSelected">
							<c:if test="${urlSelected == currUrlId}">
								<c:set var="isSelected" value="1"></c:set>
							</c:if>
						</c:forEach>
						<input type="checkbox" name="urlsSelected" value="${url.id}" ${isSelected == 1 ? 'checked' : ''}>${url.urlAddress}<br>
					</c:forEach>
					</td>
				</tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Update"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>