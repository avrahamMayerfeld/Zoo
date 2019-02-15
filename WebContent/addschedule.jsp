/*<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Schedule Page</title>
</head>
<body>

</body>
</html> */


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
	
		<h1>eZoo <small>Create Schedule</small></h1>
		<hr class="wottodo">
		
		
		<form action="addschedule" method="post" class="form-horizontal">
		
		  <div class="form-group">
		    <label for="recurrence" class="col-sm-4 control-label">Recurrence</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" recurrence="recurrence" name="recurrence" placeholder="Recurrence" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="food" class="col-sm-4 control-label">Food</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="food" name="food" placeholder="Food" required="required"/>
		    </div>
		  </div>
		 <div class="form-group">
		    <label for="notes" class="col-sm-4 control-label">Notes</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="notes" name="notes" placeholder="Notes" />
		    </div>
		  </div>
		     <div class="form-group">
		    <label for="id" class="col-sm-4 control-label">Schedule ID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="id" name="id" placeholder="ScheduleID" required="required"/>	                           
		      </div>
		  </div>
		     <div class="form-group">
		    <label for="time" class="col-sm-4 control-label">Feeding Time</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="time" name="time" placeholder="FeedingTime" required="required"/>
		    </div>
		  </div><button type="submit" class="btn btn-primary">Create</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />
