<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Schedule Page</title>
</head>
<body>

</body>
</html>

<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>eZoo <small>Add Animal</small></h1>
		<hr class="schedule">
		
		<form action="assignSchedule" method="post" class="form-horizontal">
		
		  <div class="form-group">
		    <label for="animalid" class="col-sm-4 control-label">AnimalID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="animalid" name="animalid" placeholder="AnimalID" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="scheduleid" class="col-sm-4 control-label">ScheduleID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="scheduleid" name="scheduleid" placeholder="ScheduleID" required="required"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		  <div class="col-sm-offset-4 col-sm-1">
		    <button type="submit" class="btn btn-primary">Assign</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
