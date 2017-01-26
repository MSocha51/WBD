<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Schronisko dla kotów" />
<meta name="keywords" content="koty, adpocje" />
<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700" rel="stylesheet">
<title>CATS</title>
</head>
<body>
	<div id="logo">
		<a href="<c:url value="/"/>"> <img
			src="<c:url value="/resources/title.png"/>" alt="title" id="title" />
		</a>
	</div>
	<div id="contener">

		<div id="menu">
			<a href="<c:url value="/cats"/>">
				<div class="menu-item">
					<strong> Koty </strong>
				</div>
			</a> <a href="<c:url value="/contact"/>">
				<div class="menu-item">
					<strong> Kontakt </strong>
				</div>
			</a>
			<sec:authorize access="isAnonymous()">
				<a href="<c:url value="/login"/>">
					<div class="menu-item">
						<strong> Zaloguj się </strong>
					</div>
				</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<a href="<c:url value="/profile"/>">
					<div class="menu-item">
						<strong> Moje konto </strong>
					</div>
				</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_WORKER')">
				<a href="<c:url value="/addCat"/>">
					<div class="menu-item">
						<strong> Dodaj kota </strong>
					</div>
				</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value="/logout"/>">
					<div class="menu-item">
						<strong> Wyloguj się </strong>
					</div>
				</a>
			</sec:authorize>
		</div>
		<div class="clear"></div>
		<div id="content">
			<jsp:doBody></jsp:doBody>
		</div>
		<footer> Schronisko dla zwierząt </footer>
	</div>
</body>
</html>
