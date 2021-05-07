<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmployeeManagementApplication-EmployeeList</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-12" style="margin-top:20px">
   <input type="button" value="Add Employee"
    onclick="window.location.href='employees/new'; return false;"
    class="btn btn-dark" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading" style="background-color:#2e2eb8">
     <div class="panel-title" style="color:white; font-size:22px">Employee List</div>
    </div>
    <div class="panel-body" style="height: 450px;
    overflow-y: scroll;">
     <table class="table table-striped table-bordered">
      <tr>
       <th>First Name</th>
       <th>Last Name</th>
       <th>Email</th>
       <th>Door Number</th>
       <th>Street</th>
       <th>State</th>
       <th>Country</th>
       <th>Zip Code</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="emp" items="${employees}">
		
       <!-- construct an "update" link with customer id -->
       <%-- <c:url var="updateLink" value="/v1/employees/${emp.id}">
        <c:param name="employeeId" value="${emp.id}" />
       </c:url> --%>

       <!-- construct an "delete" link with customer id -->
<%--        <c:url var="deleteLink" value="/v1/employees/${emp.id}">
        <c:param name="employeeId" value="${emp.id}" />
       </c:url> --%>

       <tr>
        <td>${emp.firstName}</td>
        <td>${emp.lastName}</td>
        <td>${emp.email}</td>
        <td>${emp.doorNumber}</td>
        <td>${emp.street}</td>
        <td>${emp.state}</td>
        <td>${emp.country}</td>
        <td>${emp.zipCode}</td>
        <td>
        <input type="button" class="btn btn-primary" value="Edit"
    onclick="window.location.href='employees/${emp.id}/update'; return false;"/>
        <input type="button" class="btn btn-danger" value="Delete"
    onclick="window.location.href='employees/${emp.id}/delete'; return false;"/>
         <!-- display the update link --> <%-- <a href="${updateLink}">Update</a> --%>
         <%-- | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> --%>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>