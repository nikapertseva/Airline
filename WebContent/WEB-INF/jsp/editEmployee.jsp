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

					<form action="controller?command=editEmployee" method="post">
						<div class="card">
							<div class="card-header">
								<h5 class="card-title align-middle">
									<fmt:message key="edit.employee" />
								</h5>
							</div>
							<div class="card-body">
								<div class="modal-body">
									<div class="form-group">
										<label><fmt:message key="surname" /></label> <input
											type="text" class="form-control" name="surname"
											value="${employee.employeeSurname }">
									</div>
									<div class="form-group">
										<label><fmt:message key="firstname" /></label> <input
											type="text" class="form-control" name="firstname"
											value="${employee.employeeFirstname }">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<label class="input-group-text" for="inputGroupSelect01"><fmt:message
													key="occupation" /></label>
										</div>
										<select class="custom-select" id="inputGroupSelect01"
											name="occupation">
											<option value="${employee.employeeOccupation }" selected><fmt:message
													key="${employee.employeeOccupation }" /></option>
											<c:forEach var="occupation" items="${occupations}">
												<option value="${occupation }"><fmt:message
														key="${occupation }" /></option>
											</c:forEach>
										</select>
									</div>
									<input type="hidden" name="id" value="${employee.employeeId}">


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