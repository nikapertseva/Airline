<%@include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<%@include file="/WEB-INF/jspf/navbar.jspf"%>
	<%@include file="/WEB-INF/jspf/errorAlert.jspf"%>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form method="get">
						<div class="form-row">
							<div class="col-md-3 col-sm-12">
								<select class="form-control form-control-lg" name="cityFrom">
									<option value=""><fmt:message key="from.city" /></option>
									<c:forEach var="cityFrom" items="${citiesFrom}">
										<option value="${cityFrom}">${cityFrom}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3 col-sm-12">
								<select class="form-control form-control-lg" name="cityTo">
									<option value=""><fmt:message key="to.city" /></option>
									<c:forEach var="cityTo" items="${citiesTo}">
										<option value="${cityTo}">${cityTo}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3 col-sm-12">
								<input class="form-control form-control-lg" type="date"
									name="date" />
							</div>
							<div class="col-md-3 col-sm-12">
								<button type="submit" class="btn btn-primary btn-lg"
									name="command" value="selection">
									<fmt:message key="show" />
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
					<div class="table-responsive-lg">
						<table class="table table table-hover table-sm">
							<thead class="bg-primary text-light">
								<tr>
									<th scope="col">
										<div class="dropdown">
											<a class="navbar-brand dropdown-toggle" href="" role="button"
												id="dropdownMenuLink" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false"> <img
												src="res/images/sort.png" width="20" height="20"
												class="d-inline-block align-top" alt="">
											</a>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
												<a class="dropdown-item" href="${url}&sort=ascendingNumbers"><fmt:message
														key="ascending" /></a> <a class="dropdown-item"
													href="${url}&sort=descendingNumbers"><fmt:message
														key="descending" /></a>
											</div>
										</div>
									</th>
									<th scope="col" class="align-middle text-left"><fmt:message
											key="number" /></th>
									<th scope="col">
										<div class="dropdown">
											<a class="navbar-brand dropdown-toggle" href="" role="button"
												id="dropdownMenuLink" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false"> <img
												src="res/images/sort.png" width="20" height="20"
												class="d-inline-block align-top" alt="">

											</a>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
												<a class="dropdown-item" href="${url}&sort=ascendingNames"><fmt:message
														key="ascending" /></a> <a class="dropdown-item"
													href="${url}&sort=descendingNames"><fmt:message
														key="descending" /></a>
											</div>
										</div>
									</th>
									<%@include file="/WEB-INF/jspf/flightsTable.jspf"%>
									<th scope="col" class="align-middle"></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="flight" items="${flights}">
									<tr>
										<tags:flight flight="${flight }" />
										<td class="align-middle"><fmt:message
												key="${flight.flightStatus}" /></td>
										<td><a class="badge badge-link"
											href="controller?command=flightInfo&id=${flight.flightId}"
											role="button" id="dropdownMenuLink"><img
												src="res/images/arrow.png" width="30" height="30"
												class="d-inline-block align-top" alt=""> </a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/jspf/scripts.jspf"%>
</body>
</html>