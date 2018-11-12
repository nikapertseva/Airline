<%@include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<%@include file="/WEB-INF/jspf/navbarAdmin.jspf"%>
	<%@include file="/WEB-INF/jspf/errorAlert.jspf"%>
	<div class="album py-5 bg-light">
		<div class="container-fluid">
			<div class="row">
				<div class="col col-xl-2 col-md-3 col-sm-12">
					<%@include file="/WEB-INF/jspf/navAdmin.jspf"%>
				</div>
				<div class="col col-md-6 offset-md-1">

					<form action="controller?command=editFlight" method="post">
						<div class="card">
							<div class="card-header">
								<h5 class="card-title align-middle">
									<fmt:message key="edit.flight" />
								</h5>
							</div>
							<div class="card-body">
								<div class="modal-body">
									<div class="form-group">
										<label><fmt:message key="number" /></label> <input
											type="text" class="form-control" name="number"
											value="${flight.flightNumber }">
									</div>
									<div class="form-group">
										<label><fmt:message key="name" /></label> <input type="text"
											class="form-control" name="name"
											value="${flight.flightName }">
									</div>
									<div class="form-group">
										<label><fmt:message key="from.city" /></label> <input
											type="text" class="form-control" name="cityFrom"
											value="${flight.flightCityFrom }">
									</div>
									<div class="form-group">
										<label><fmt:message key="to.city" /></label> <input
											type="text" class="form-control" name="cityTo"
											value="${flight.flightCityTo }">
									</div>
									<div class="form-group">
										<label><fmt:message key="date.departure" /></label> <input
											class="form-control form-control-lg" type="date" name="dateDeparture"
											value="${flight.flightDateDeparture }" />
									</div>
									<div class="form-group">
										<label><fmt:message key="time.departure" /></label> <input
											class="form-control form-control-lg" type="time" name="timeDeparture"
											value="${flight.flightTimeDeparture }" />
									</div>
									<div class="form-group">
										<label><fmt:message key="date.arrival" /></label> <input
											class="form-control form-control-lg" type="date" name="dateArrival"
											value="${flight.flightDateArrival }" />
									</div>
									<div class="form-group">
										<label><fmt:message key="time.arrival" /></label> <input
											class="form-control form-control-lg" type="time" name="timeArrival"
											value="${flight.flightTimeArrival }" />
									</div>
									<input type="hidden" name="id" value="${flight.flightId}">


								</div>


								<button type="submit" class="btn btn-dark">
									<fmt:message key="edit" />
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jspf/scripts.jspf"%>
</body>
</html>