<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:main>
	<jsp:body>

		<span class="minititle"><strong>Twoje konto</strong></span>
			<br/>
			<div id="text">
			<div class="names">
				<span>Imię:</span>
				${client.firstName }<br />
			</div>
			<div class="names">
				<span>Nazwisko:</span>
				${client.surname }<br />
			</div>
			
			<div class="names">
				<span>Mail:</span>
				${client.mail}<br />
			</div>
			<div class="names">
				<span>PESEL:</span>
				${client.pesel }<br />
			</div>
			<div class="names">
				<span>Ulica:</span>
				${client.street }<br />
			</div>
			<div class="names">
				<span>Miasto:</span>
				${client.city}<br />
			</div>
			<div class="names">
				<span>Numer lokalu:</span>
				${client.localNumber}<br />
			</div>
			<div class="names">
				<span>Kod pocztowy:</span>
				${client.postCode }<br />
			</div>
			<div class="names">
				<span>Telefon:</span>
				${client.phone }<br />
			</div>
		</div>

</jsp:body>
</t:main>
