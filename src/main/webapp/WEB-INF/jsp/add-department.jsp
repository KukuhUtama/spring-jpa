<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Add Department</title>

</head>
<body>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <div align="center">
        <h2>Add New Department</h2>
        <form:form action="${root}/department/add-department.html"  modelAttribute="department" method="post">
            <table border="0" cellpadding="1">
                <tr>
                    <td>Department Name: </td>
                    <td><input id="departmentName" name="departmentName" value=""></td>
                </tr>
                <tr>
                    <td>Group Name: </td>
                    <td>
                       <select id="idGroup" name="idGroup">
                        <c:forEach items="${listOfGroup}" var="group">
                              <option value="0"  selected="selected">-Group Name-</option> 
                              <option value="${group.id}" ${group.id == department.groupId ? 'selected' : ''} >${group.groupName}</option>
                        </c:forEach>
                       </select>
                    </td>
                </tr>    
       
                <tr>
                     <td colspan="2"><input type="submit" value="save"></td>
                </tr>                    
            </table>
        </form:form>
    </div>
</body>
</html>