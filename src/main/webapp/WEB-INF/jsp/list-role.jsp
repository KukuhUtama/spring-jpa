<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Role</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <table>
          <tr>
              <td>No.</td>
              <td>Role Name</td>
              <td>Action</td>
          </tr>
       <c:forEach items="${listOfRole}" var="element" varStatus="counter"> 
          <tr>
           <td>${counter.count}</td>
           <td>${element.roleName}</td>
           <td><a href="${root}/role/delete-role-by-id.html?roleId=${element.id}">Delete</a> | <a href="${root}/role/update-role.html?roleId=${element.id}">Update</a> </td>
          </tr>
       </c:forEach>
     </table>
</body>
</html>