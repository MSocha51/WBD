<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:main>
<jsp:body>
<span class="minititle"><strong>Logowanie</strong></span><br/>
			${message}<br />
			<form:form action="login" method="post">
				<input type="text" name="MAIL" placeholder="Email" /><br/>
   				<input type="password" name="HASLO" placeholder="Password" /><br/>
				<input type="submit" value="Login!" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br/>
				<a href="<c:url value="/"/>"> Nie masz konta? Zarejestruj się!</a>
			</form:form>
			<br/><br/><br/><br/><br/>
			<div id="logo">
			
			<img src="<c:url value="/resources/cats.png"/>" alt="cats" id="cats"/>
			</div>
</jsp:body>
</t:main>