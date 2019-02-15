<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Display</title>
</head>
<body>
    <!-- Header -->
    <jsp:include page="header.jsp" />

    <!-- JSTL includes -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

    <!--     Just some stuff you need -->
    <header>
    <div class="container">
        <table>
            <tr>
                <th>Schedule_ID</th>
                <th>Feeding_Time</th>
                <th>Recurrence</th>
                <th>Food</th>
                <th>Notes</th>
            </tr>
            <c:forEach var="Schedule" items="${SchedList}">
                <tr>
                    <td><c:out value="${Schedule.getID()}" /></td>
                    <td><c:out value="${Schedule.getTime()}" /></td>
                    <td><c:out value="${Schedule.getRecurrence()}" /></td>
                    <td><c:out value="${Schedule.getFood()}" /></td>
                    <td><c:out value="${Schedule.getNotes()}" /></td>
                    <td><form method="post" action="DeleteScheduleServlet">
                            <button type="submit" name="delete">Delete</button>
                            <input type="hidden" name="id" value="${schedule.id}" />
                        </form></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="container">
        <table>
            <tr>
                <th>Animal_ID</th>
                <th>Schedule_ID</th>
                <c:forEach var="Assignment" items="${AssignmentList}">
                    <tr>
                        <td><c:out value="${Assignment.animalID}" /></td>
                        <td><c:out value="${Assignment.scheduleID}" /></td>
                        <td><form method="post" action="cancelSchedServlet">
                                <button type="submit" name="cancel">Cancel</button>
                                <input type="hidden" name="ida"
                                    value="${AssignmentList.getAnimalID()}" /> <input type="hidden"
                                    name="idb" value="${AssignmentList.getScheduleID()}" />
                            </form></td>
                    </tr>
                </c:forEach>
        </table>
    </div>
    </header>
</body>
</html>