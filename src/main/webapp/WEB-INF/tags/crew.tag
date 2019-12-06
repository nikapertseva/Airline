<%@tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="crew" required="true"
	type="ua.khnucea.csit.cs.pertseva.airline.entity.Crew"%>
<%@ attribute name="flightId" required="true"%>
<li><form action="controller?command=removeCrew" method="post">${crew.crewEmployee.employeeSurname}&#160;
		${crew.crewEmployee.employeeFirstname} <input type="hidden"
			name="crewId" value="${crew.crewId}"> <input type="hidden"
			name="flightId" value="${flightId}">
		<button type="submit" class="btn btn-link">
			<img class="rounded" src="res/images/minus.png" width="15"
				height="15" class="d-inline-block align-top" alt="">
		</button>
	</form></li>