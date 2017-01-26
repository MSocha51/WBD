<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:main>
<jsp:body>

		<span class="minititle"><strong>Koty do adopcji</strong></span>

		<c:forEach var="cat" items="${unnCats}">
		<a href="<c:url value="/cats/cat-${cat.id}"/>">
			<div id="cat">
				<strong>${cat.name}</strong>::  ::${cat.race.raceName }::  
				<c:if test="${cat.sex eq 'M'.charAt(0)}">
				::Samiec
				</c:if>
				<c:if test="${cat.sex eq 'K'.charAt(0)}">
				::Samica
				</c:if><br />
			</div>
		</a>
		</c:forEach>

</jsp:body>
</t:main>
	
