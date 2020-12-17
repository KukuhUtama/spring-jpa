<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Group</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <table>
          <tr>
              <td>No.</td>
              <td>Group Name</td>
              <td>Action</td>
          </tr>
       <c:forEach items="${listOfGroup}" var="element" varStatus="counter"> 
          <tr>
           <td>${counter.count}</td>
           <td>${element.groupName}</td>
           <td>
           <c:if test="${element.listOfDepartement.size() lt 1}">
             <a href="${root}/group/delete-group-by-id.html?groupId=${element.id}">Delete</a> 
          </c:if>
          <c:if test="${element.listOfDepartement.size() gt 0}">
              <a href="javascript:void(0)">Delete</a> 
          </c:if>
            |<a href="${root}/group/update-group.html?groupId=${element.id}">Update</a> </td>
          </tr>
       </c:forEach>
     </table>
</body>
</html>