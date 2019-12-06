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
							class="btn btn-outline-dark btn-block"><fmt:message
								key="flights" /></a> <a href="controller?command=employeesAdmin"
							class="btn btn-outline-dark btn-block"><fmt:message
								key="employees" /></a> <a href="controller?command=requestsAdmin"
							class="btn btn-dark btn-block"><fmt:message key="requests" /></a>
						<a href="controller?command=usersAdmin"
							class="btn btn-outline-dark btn-block"><fmt:message
								key="users" /></a>
					</div>
				</div>
				<div class="col col-xl-9 col-md-8">
					<div class="table-responsive-lg">
						<table class="table table table-hover">
							<thead class="bg-dark text-light">
								<tr>
									<th scope="col" class="align-middle"><fmt:message
											key="user" /></th>
									<th scope="col" class="align-middle"><fmt:message
											key="flight" /></th>
									<th scope="col" class="align-middle"><fmt:message
											key="topic" /></th>
									<th scope="col" class="align-middle"><fmt:message
											key="date" /></th>
									<th scope="col" class="align-middle"><fmt:message
											key="status" /></th>
									<th scope="col" class="align-middle"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="request" items="${requests}">
									<tr>
										<td class="align-middle">${request.requestUser.userEmail}</td>
										<td class="align-middle">${request.requestFlight.flightNumber}</td>
										<td class="align-middle">${request.requestTopic}</td>
										<td class="align-middle">${request.requestDate}</td>
										<td class="align-middle"><fmt:message
												key="${request.requestStatus}" /></td>

										<td class="align-middle"><c:if
												test="${request.requestStatus == 'awaiting'}">
												<button type="button" class="btn btn-dark"
													data-toggle="modal"
													data-target="#Modal${request.requestId}">
													<fmt:message key="close.request" />
												</button>
												<div class="modal fade" id="Modal${request.requestId}"
													tabindex="-1" role="dialog"
													aria-labelledby="exampleModalCenterTitle"
													aria-hidden="true">

													<div class="modal-dialog modal-dialog-centered"
														role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">
																	<fmt:message key="request" />
																</h5>

															</div>
															<form action="controller?command=editRequestsStatus"
																method="post">
																<div class="modal-body">
																	<div class="form-group">
																		<label><fmt:message key="topic" /></label> <input
																			type="text" class="form-control" name="topic"
																			value="${request.requestTopic}" disabled />
																	</div>
																	<div class="form-group">
																		<label for="message-text" class="col-form-label"><fmt:message
																				key="message" /></label>
																		<textarea class="form-control" id="message-text"
																			name="message" disabled>${request.requestMessage}</textarea>

																	</div>
																	<input type="hidden" name="requestId"
																		value="${request.requestId}">


																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">
																		<fmt:message key="close" />
																	</button>
																	<button type="submit" class="btn btn-primary"
																		name="status" value="rejected">
																		<fmt:message key="reject" />
																	</button>
																	<button type="submit" class="btn btn-primary"
																		name="status" value="done">
																		<fmt:message key="done.button" />
																	</button>
																</div>
															</form>
														</div>
													</div>
												</div>
											</c:if></td>


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