<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeManagementApplication-form</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10 main-container">
  <!--  <h2 class="text-center">Employee Registration Form</h2> -->
   
    <div class="panel-body general-info-container">
     <form:form action="/EmployeeManagementApplication/v1/employees" cssClass="form-horizontal"
      method="post" modelAttribute="employeeDTO">
	
      <%-- <!-- need to associate this data with customer id -->
      <form:hidden path="id" /> --%>
	<div class="col-md-6">
	<h3 class="text-center panel-heading">General information</h3>
      
	<div class="form-group">
       <div class="col-md-12">
        <form:input path="firstName" cssClass="form-control input-field-general-info" placeholder="First Name"/>
        <form:errors path="firstName" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>

	<div class="form-group">
       <div class="col-md-12">
        <form:input path="lastName" cssClass="form-control input-field-general-info" placeholder="Last Name"/>
        <form:errors path="lastName" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
     </div>
      
       <div class="form-group">
       <div class="col-md-12">
        <form:input path="email" cssClass="form-control input-field-general-info" placeholder="email" />
        <form:errors path="email" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>
	</div>
	<div class="col-md-6 contact-container">
	<h3 class="text-center panel-heading-contact">Contact details</h3>
	<div class="form-group">
       <div class="col-md-12">
        <form:input path="doorNumber" cssClass="form-control input-field" placeholder="Door Number"/>
         <form:errors path="doorNumber" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>

	<div class="form-group">
       <div class="col-md-12">
        <form:input path="street" cssClass="form-control input-field" placeholder="Street"/>
        <form:errors path="street" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
     </div>
      
       <div class="form-group">
       <div class="col-md-12">
        <form:input path="state" cssClass="form-control input-field" placeholder="State" />
        <form:errors path="state" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>
      
      <div class="form-group">
       <div class="col-md-12">
        <form:input path="country" cssClass="form-control input-field" placeholder="Country" />
        <form:errors path="country" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>
      
      <div class="form-group">
       <div class="col-md-12">
        <form:input path="zipCode" cssClass="form-control input-field" placeholder="Zip Code" />
        <form:errors path="zipCode" cssStyle="color:#ff0000;font-style: italic;font-weight: bold;"></form:errors>
       </div>
      </div>
      
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-12">
        <form:button class="btn btn-secondary">Submit</form:button>
       </div>
     </div>
     
	</div>
     </form:form>
    </div>
   
  </div>
 </div>
</body>
</html>