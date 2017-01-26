<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE >
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Schronisko dla kotów" />
<meta name="keywords" content="koty, adpocje" />
<title>CATS</title>
</head>
<body>
	<div id="logo">
		<a href="<c:url value="/index"/>"> <img
			src="<c:url value="/resources/title.png"/>" alt="title" id="title" />
		</a>
	</div>
	<div id="contener">

		<div id="menu">
			<span> <a href="<c:url value="/"/>"><strong>Koty</strong></a>
			</span> <span> <a href="<c:url value="/"/>"><strong>Kontakt</strong></a>
			</span> <span> <a href="<c:url value="/"/>"><strong>Zaloguj
						się</strong></a>
			</span>
		</div>
		<div id="content">
			${message}<br />
			<form:form action="login" method="post">
				<input type="text" name="MAIL" placeholder="Email" /><br/>
   				<input type="password" name="HASLO" placeholder="Password" /><br/>
				<input type="submit" value="Login!" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form:form>
		</div>
		<footer> Schronisko dla zwierząt </footer>
	</div>

</body>
</html>