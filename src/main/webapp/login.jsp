<%@include file="/WEB-INF/jspf/header.jspf"%>

<body>

	<%@include file="/WEB-INF/jspf/navbarFreeZone.jspf"%>
	
	<c:if test="${error}">
		<div class="alert alert-danger" role="alert">Please check your
			email and password.</div>
	</c:if>

	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<form action="controller?command=login" method="post">
						<div class="card">
							<div class="card-header">
								<h5 class="card-title align-middle">
									<fmt:message key="login.title" />
								</h5>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1"><fmt:message
											key="email" /></label> <input type="email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										name="email" value="${email}">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1"><fmt:message
											key="password" /></label> <input type="password"
										class="form-control" id="exampleInputPassword1"
										name="password">
								</div>
								<button type="submit" class="btn btn-primary">
									<fmt:message key="login.button" />
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