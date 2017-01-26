<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:main>
	<jsp:body>

		<span class="minititle"><strong>${cat.name}</strong></span>
		<span class="minititle"><strong>${message}</strong></span>
			<br/>
			<div id="text">
			<div class="names">
				<span>Imię:</span>
				${cat.name }<br />
			</div>
			<div class=names>
				<span>Data urodzenia:</span>
				<fmt:formatDate  value="${cat.birthdayDate }" pattern="dd-MMM-yyyy"/>
			</div>
			<div class=names>
				<span>Płeć:</span>
				<c:if test="${cat.sex eq 'M'.charAt(0)}">
				samiec
				</c:if>
				<c:if test="${cat.sex eq 'K'.charAt(0)}">
				samica
				</c:if>
				<br />
			</div>
			<div class=names>
				<span>Komplet łapek:</span>
				<c:if test="${cat.paws eq 'T'.charAt(0)}">
				Tak
				</c:if>
				<c:if test="${cat.paws eq 'N'.charAt(0)}">
				Nie
				</c:if>
			</div>
			<div class=names>
				<span>Sterylizacja:</span>
				<c:if test="${cat.sterizlization  eq 'T'.charAt(0)}">
				Tak
				</c:if>
				<c:if test="${cat.sterizlization  eq 'N'.charAt(0)}">
				Nie
				</c:if>
			</div>
			<div class=names>
				<span>Wzrok:</span>
				<c:if test="${cat.sight   eq 'T'.charAt(0)}">
				Tak
				</c:if>
				<c:if test="${cat.sight   eq 'N'.charAt(0)}">
				Nie
				</c:if>
			</div>
			<div class=names>
			<span>Rasa:</span>
				${cat.race.raceName}<br />
			</div>
			<spring:url value="./cat-${cat.id}" var="url" />
			<form:form class="button" action="${url}/delete" method="post">
				<input type="submit" value="Usuń" />
			</form:form>
			<form:form class="button" action="${url}/edit" method="get">
				<input type="submit" value="Edytuj" />
			</form:form>
			<form:form class="button" action="${url }/adopt" method="post">
				<input type="submit" value="Adoptuj" />
			</form:form>
			</div>
			

</jsp:body>
</t:main>
