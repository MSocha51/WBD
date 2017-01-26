<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:main>
<jsp:body>
			<sec:authorize access="isAuthenticated()">
   				Informacja tylko dla zalogowanych
			</sec:authorize>
</jsp:body>
</t:main>
	
