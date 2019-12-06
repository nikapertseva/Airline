
<%@ include file="/WEB-INF/jspf/header.jspf"%>
<body>
	<c:choose>
		<c:when test="${role == 'administrator'}">
			<%@ include file="/WEB-INF/jspf/navbarAdmin.jspf"%>
		</c:when>
		<c:when test="${role == 'dispatcher'}">
			<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/jspf/navbarFreeZone.jspf"%>
		</c:otherwise>
	</c:choose>

	<div class="text-center">
		<img src="res/images/error.gif" class="img-fluid rounded"
			alt="Responsive image">
	</div>



	<%@include file="/WEB-INF/jspf/scripts.jspf"%>
</body>
</html>