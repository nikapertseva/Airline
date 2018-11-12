<%@include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<%@include file="/WEB-INF/jspf/navbarAdmin.jspf"%>
	<%@include file="/WEB-INF/jspf/errorAlert.jspf"%>
	<div class="album py-5 bg-light">
		<div class="container-fluid">
			<div class="row">
				<div class="col col-xl-2 col-md-3 col-sm-12">
					<div class="btn-group-vertical  btn-group-lg col-lg-12" role="group"
						aria-label="Vertical button group">
						<a href="controller?command=flightsAdmin"
							class="btn btn-dark btn-block"><fmt:message key="flights" /></a>
						<a href="controller?command=employeesAdmin"
							class="btn btn-outline-dark btn-block"><fmt:message
								key="employees" /></a> <a href="controller?command=requestsAdmin"
							class="btn btn-outline-dark btn-block"><fmt:message
								key="requests" /></a> <a href="controller?command=usersAdmin"
							class="btn btn-outline-dark btn-block"><fmt:message
								key="users" /></a>
					</div>
				</div>
				<div class="col col-xl-9 col-md-8">
					<div class="table-responsive-lg">
						<table class="table table table-hover table-sm">
							<thead class="bg-dark text-light">
								<tr>
									<th scope="col" class="align-middle"><fmt:message
											key="number" /></th>
									<%@include file="/WEB-INF/jspf/flightsTable.jspf"%>
									<th scope="col" class="align-middle"></th>
									<th scope="col" class="align-middle"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="flight" items="${flights}">
									<tr>
										<flights:flightsTable id="${flight.flightId }"></flights:flightsTable>
										<td class="align-middle"><fmt:message
												key="${flight.flightStatus}" /></td>
										<td class="align-middle"><a class="badge badge-link"
											href="controller?command=pageEditFlight&id=${flight.flightId}"
											role="button" id="dropdownMenuLink"><img
												src="res/images/arrowDark.png" width="30" height="30"
												class="d-inline-block align-top" alt=""> </a></td>
										<td><form action="controller?command=removeFlight"
												method="post">
												<input type="hidden" name="id" value="${flight.flightId}">
												<button type="submit" class="btn btn-link">
													<img src="res/images/rubbish.png" width="35" height="35"
														class="d-inline-block align-top" alt="">
												</button>

											</form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="text-center">
						<a class="badge badge-link" data-target="#exampleModal1"
							data-toggle="modal" href="" role="button" id="dropdownMenuLink"><img
							class="rounded" src="res/images/plusDark.png" width="40"
							height="40" class="d-inline-block align-top" alt=""> </a>
					</div>
					<div class="modal fade" id="exampleModal1" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel1"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">
										<fmt:message key="new.flight" />
									</h5>

								</div>
								<form action="controller?command=addFlight" method="post">
									<div class="modal-body">
										<div class="form-group">
											<label><fmt:message key="number" /></label> <input
												type="text" class="form-control" name="number">
										</div>
										<div class="form-group">
											<label><fmt:message key="name" /></label> <input type="text"
												class="form-control" name="name">
										</div>
										<div class="form-group">
											<label><fmt:message key="from.city" /></label> <input
												type="text" class="form-control" name="cityFrom">
										</div>
										<div class="form-group">
											<label><fmt:message key="to.city" /></label> <input
												type="text" class="form-control" name="cityTo">
										</div>
										<div class="form-group">
											<label><fmt:message key="date.departure" /></label> <input
												class="form-control form-control-lg" type="date"
												name="dateDeparture" />
										</div>
										<div class="form-group">
											<label><fmt:message key="time.departure" /></label> <input
												class="form-control form-control-lg" type="time"
												name="timeDeparture" />
										</div>
										<div class="form-group">
											<label><fmt:message key="date.arrival" /></label> <input
												class="form-control form-control-lg" type="date"
												name="dateArrival" />
										</div>
										<div class="form-group">
											<label><fmt:message key="time.arrival" /></label> <input
												class="form-control form-control-lg" type="time"
												name="timeArrival" />
										</div>


									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">
											<fmt:message key="close" />
										</button>
										<button type="submit" class="btn btn-primary">
											<fmt:message key="add" />
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jspf/scripts.jspf"%>
</body>
</html>