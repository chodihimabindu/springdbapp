<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <!--  To display Employee details on the console -->
  
<h1>Employees List</h1>  
<table border="1" width="70%" cellpadding="1">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   <!-- repeating the item list using foreach loop -->
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   
   <td><a href="editemp/${emp.id}">Edit</a></td>  <!-- This is the hyper link for Edit the Employee -->
   <td><a href="deleteemp/${emp.id}">Delete</a></td>   <!-- This is the hyper link for Edit the Employee -->
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>     <!-- This is the hyper link for the Adding New Employee -->

</body>
</html>