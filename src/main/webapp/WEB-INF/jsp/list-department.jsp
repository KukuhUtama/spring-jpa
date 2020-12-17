<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Department</title>
</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <table>
          <tr>
              <td>No.</td>
              <td>Department Name</td>
              <td>Action</td>
          </tr>
       <c:forEach items="${listOfDepartment}" var="element" varStatus="counter"> 
          <tr>
           <td>${counter.count}</td>
           <td>${element.departmentName}</td>
           <td>
             <a href="${root}/department/delete-department-by-id.html?departmentId=${element.id}">Delete</a> 
            |<a href="${root}/department/update-department.html?departmentId=${element.id}">Update</a> </td>
          </tr>
       </c:forEach>
     </table>
</body>
</html>