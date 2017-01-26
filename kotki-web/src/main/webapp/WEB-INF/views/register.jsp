<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:main>
	<jsp:body>
		<form:form action="register" method="post" modelAttribute="registerDto">
		
		
			<form:input path="firstName" id="firstName" placeholder="Imie"></form:input>
 			<form:errors path="firstName" cssclass="error" />
 			<br />
			<form:input path="surname" id="surname" placeholder="Nazwisko"></form:input>
			<form:errors path="surname" cssclass="error" />
			<br />
			<form:input path="mail" id="mail" placeholder="Mail"></form:input>
			<form:errors path="mail" cssclass="error" />
			<br />
			<form:input path="password" id="password" placeholder="Nazwisko"></form:input>
			<form:errors path="password" cssclass="error" />
			<br />
			<form:input path="pesel" id="pesel" placeholder="PESEL"></form:input>
 			<form:errors path="pesel" cssclass="error" />
 			<br />
			<form:input path="street" id="street" placeholder="Ulica"></form:input>
			<form:errors path="street" cssclass="error" />
			<br />
			<form:input path="city" id="city" placeholder="Miasto"></form:input>
 			<form:errors path="city" cssclass="error" />
 			<br />
 			<form:input path="localNumber" id="localNumber" placeholder="Numer Lokalu"></form:input>
 			<form:errors path="localNumber" cssclass="error" />
 			<br />
			<form:input path="postCode" id="postCode" placeholder="Kod pocztowy"></form:input>
			<form:errors path="postCode" cssclass="error" />
			<br />
			<form:input path="phone" id="phone" placeholder="Telefon"></form:input>
			<form:errors path="phone" cssclass="error" />
			<br />
			<input type="submit" value="Załóż konto" />

		
		</form:form>
	</jsp:body>
</t:main>