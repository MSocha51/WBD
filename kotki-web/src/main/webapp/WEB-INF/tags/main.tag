<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Schronisko dla kotów" />
<meta name="keywords" content="koty, adpocje" />
<title>CATS</title>
</head>
<body>
		<div id="logo">
		<a href="<c:url value="/"/>">
			<img src="<c:url value="/resources/title.png"/>"  alt="title" id="title"/>
		</a>
	</div>
	<div id="contener">

		<div id="menu">
			<span> 
				<a href="<c:url value="/cats"/>">
					<strong>
						Koty
					</strong>
				</a>
			</span>
			<span>
				<a href="<c:url value="/contact"/>">
					<strong>
						Kontakt
					</strong>
				</a>
			</span>
			<span>
				<a href="<c:url value="/login"/>">
					<strong>
						Zaloguj się
					</strong>
				</a>
			</span>
			<span>
				<a href="<c:url value="/"/>">
					<strong>
						Moje konto
					</strong>
				</a>
			</span>
			<span>
				<a href="<c:url value="/addCat"/>">
					<strong>
						Dodaj kota
					</strong>
				</a>
			</span>
		</div>
		<div id="content">
		<jsp:doBody></jsp:doBody>
		</div>
	<footer> Schronisko dla zwierząt </footer>
	</div>
</body>
</html>
