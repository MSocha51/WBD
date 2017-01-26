<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:main>
<jsp:body>
			<span class="minititle"><strong>Schronisko dla zwierząt</strong></span><br/><br/>
			Nasze schronisko działa od wielu lat. Odmieniliśmy losy setek kotów. Pomogliśmy im dojść do zdrowia i znaleźliśmy domy pełne miłości.<br/> 
			Ty również możesz podarować szczęście zwierzakowi, przygarniając jednego z naszych podopiecznych.
						<br/><br/><br/><br/><br/>
			<div id="logo">
			
			<img src="<c:url value="/resources/cats.png"/>" alt="cats" id="cats"/>
			</div>
</jsp:body>
</t:main>
	
