<%@include file="/WEB-INF/jspf/header.jspf"%>

<body>
	<%@include file="/WEB-INF/jspf/navbar.jspf"%>
	<%@include file="/WEB-INF/jspf/errorAlert.jspf"%>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<div class="table-responsive-lg">
					<table class="table table table-hover table-sm">
						<thead class="bg-primary text-light">
							<tr>
								<th scope="col" class="align-middle"><fmt:message
										key="number" /></th>
								<%@include file="/WEB-INF/jspf/flightsTable.jspf"%>
								<th scope="col" class="align-middle"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<flights:flightsTable id="${flightId }"></flights:flightsTable>
								<td class="align-middle"><fmt:message key="${flightStatus}" /></td>
								<td><button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#exampleModalCenter">
										<fmt:message key="change.status" />
									</button>
									<div class="modal fade" id="exampleModalCenter" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalCenterTitle"
										aria-hidden="true">

										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">
												<form action="controller?command=editFlightsStatus"
													method="post">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalCenterTitle">
															<fmt:message key="change.status" />
														</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">

														<div class="custom-control custom-radio">
															<input type="radio" id="${flightStatus }" name="status"
																class="custom-control-input" value="${flightStatus }"
																checked /> <label class="custom-control-label"
																for="${flightStatus }"><fmt:message
																	key="${flightStatus }" /></label>
														</div>
														<c:forEach var="status" items="${statuses}">
															<div class="custom-control custom-radio">
																<input type="radio" id="${status }" name="status"
																	class="custom-control-input" value="${status }">
																<label class="custom-control-label" for="${status }"><fmt:message
																		key="${status }" /></label>
															</div>
														</c:forEach>

													</div>
													<input type="hidden" name="flightId" value="${flightId}">
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">
															<fmt:message key="close" />
														</button>
														<button type="submit" class="btn btn-primary">
															<fmt:message key="change.status" />
														</button>
													</div>
												</form>
											</div>
										</div>

									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="card  col-md-6">
					<div class="card-body">
						<h5 class="ceard-title">
							<fmt:message key="pilots" />
						</h5>

						<ol>
							<c:forEach var="pilot" items="${pilots}">
								<tags:crew crew="${pilot }" flightId="${flightId }" />
							</c:forEach>
						</ol>

						<div class="text-center">
							<a class="badge badge-link" data-target="#exampleModal1"
								data-toggle="modal" href="" role="button" id="dropdownMenuLink"><img
								class="rounded" src="res/images/plus.png" width="40" height="40"
								class="d-inline-block align-top" alt=""> </a>
						</div>
						<div class="modal fade" id="exampleModal1" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel1"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											<fmt:message key="available.pilots" />
										</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="controller?command=addCrew" method="post">
										<div class="modal-body">
											<c:forEach var="availablePilot" items="${availablePilots}">
												<input type="checkbox" name="employeesId"
													value="${availablePilot.employeeId}"> ${availablePilot.employeeSurname} ${availablePilot.employeeFirstname}<br>
											</c:forEach>
											<input type="hidden" name="flightId" value="${flightId}">
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
				<div class="card  col-md-6">
					<div class="card-body">
						<h5 class="ceard-title">
							<fmt:message key="radio_operators" />
						</h5>

						<ol>
							<c:forEach var="radioOperator" items="${radioOperators}">
								<tags:crew crew="${radioOperator }" flightId="${flightId }" />
							</c:forEach>
						</ol>

						<div class="text-center">
							<a class="badge badge-link" data-target="#exampleModal2"
								data-toggle="modal" href="" role="button" id="dropdownMenuLink"><img
								class="rounded" src="res/images/plus.png" width="40" height="40"
								class="d-inline-block align-top" alt=""> </a>
						</div>
						<div class="modal fade" id="exampleModal2" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel2"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											<fmt:message key="available.radio_operators" />
										</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="controller?command=addCrew" method="post">
										<div class="modal-body">
											<c:forEach var="availableRadioOperator"
												items="${availableRadioOperators}">
												<input type="checkbox" name="employeesId"
													value="${availableRadioOperator.employeeId}"> ${availableRadioOperator.employeeSurname} ${availableRadioOperator.employeeFirstname}<br>
											</c:forEach>
											<input type="hidden" name="flightId" value="${flightId}">
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
				<div class="card  col-md-6">
					<div class="card-body">
						<h5 class="ceard-title">
							<fmt:message key="navigators" />
						</h5>

						<ol>
							<c:forEach var="navigator" items="${navigators}">
								<tags:crew crew="${navigator }" flightId="${flightId }" />
							</c:forEach>
						</ol>

						<div class="text-center">
							<a class="badge badge-link" data-target="#exampleModal3"
								data-toggle="modal" href="" role="button" id="dropdownMenuLink"><img
								class="rounded" src="res/images/plus.png" width="40" height="40"
								class="d-inline-block align-top" alt=""> </a>
						</div>
						<div class="modal fade" id="exampleModal3" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel3"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											<fmt:message key="available.navigators" />
										</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="controller?command=addCrew" method="post">
										<div class="modal-body">
											<c:forEach var="availableNavigator"
												items="${availableNavigators}">
												<input type="checkbox" name="employeesId"
													value="${availableNavigator.employeeId}"> ${availableNavigator.employeeSurname} ${availableNavigator.employeeFirstname}<br>
											</c:forEach>
											<input type="hidden" name="flightId" value="${flightId}">
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
				<div class="card  col-md-6">
					<div class="card-body">
						<h5 class="ceard-title">
							<fmt:message key="stewardesses" />
						</h5>

						<ol>
							<c:forEach var="stewardess" items="${stewardesses}">
								<tags:crew crew="${stewardess }" flightId="${flightId }" />
							</c:forEach>
						</ol>

						<div class="text-center">
							<a class="badge badge-link" data-target="#exampleModal4"
								data-toggle="modal" href="" role="button" id="dropdownMenuLink"><img
								class="rounded" src="res/images/plus.png" width="40" height="40"
								class="d-inline-block align-top" alt=""> </a>
						</div>
						<div class="modal fade" id="exampleModal4" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel4"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											<fmt:message key="available.stewardesses" />
										</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="controller?command=addCrew" method="post">
										<div class="modal-body">
											<c:forEach var="availableStewardess"
												items="${availableStewardesses}">
												<input type="checkbox" name="employeesId"
													value="${availableStewardess.employeeId}"> ${availableStewardess.employeeSurname} ${availableStewardess.employeeFirstname}<br>
											</c:forEach>
											<input type="hidden" name="flightId" value="${flightId}">
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
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-3">
				<button type="button" class="btn btn-primary col-12" data-toggle="modal"
					data-target="#exampleModal5">
					<fmt:message key="view.requests" />
				</button>
			</div>
			<div class="modal fade" id="exampleModal5" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel5"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">
								<fmt:message key="requests" />
							</h5>
						</div>

						<div class="modal-body">
							<ol>
								<c:forEach var="request" items="${requests}">
									<li>${request.requestTopic}(${request.requestDate}): <fmt:message
											key="${request.requestStatus}" />
									</li>
								</c:forEach>
							</ol>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">
								<fmt:message key="close" />
							</button>
						</div>

					</div>
				</div>
			</div>
			<div class="col offset-md-6 col-md-3">
				<button type="button" class="btn btn-primary col-md-12" data-toggle="modal"
					data-target="#exampleModal6">
					<fmt:message key="send.request" />
				</button>
			</div>
			<div class="modal fade" id="exampleModal6" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel6"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">
								<fmt:message key="new.request" />
							</h5>
						</div>
						<form action="controller?command=addRequest" method="post">
							<div class="modal-body">
								<div class="form-group">
									<label><fmt:message key="topic" /></label> <input type="text"
										class="form-control" name="topic" />
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label"><fmt:message
											key="message" /></label>
									<textarea class="form-control" id="message-text" name="message"></textarea>
									<input type="hidden" name="flightId" value="${flightId}">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">
									<fmt:message key="close" />
								</button>
								<button type="submit" class="btn btn-primary">
									<fmt:message key="send.request" />
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/jspf/scripts.jspf"%>
</body>
</html>