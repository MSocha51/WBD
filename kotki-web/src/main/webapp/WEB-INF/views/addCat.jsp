<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:main>
	<jsp:body>

		<span class="minititle"><strong>Dodaj kota</strong></span>
			<br/>
			<div id="text">
			<form:form action="/addCat" modelAttribute="catDTO" method="post" id="form">
				
				<div class=names>
					<span>Imię:</span>
					<form:input path="name" id="name"></form:input>
					<form:errors path="name" cssclass="error" />
				</div>
			<div class=names>
				
					<span>Data urodzenia:</span>
					<form:input path="birthdayDate" id="birthdayDate" type="date" ></form:input>
					<form:errors path="birthdayDate" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Płeć</span>
	 				<form:input path="sex" id="sex" ></form:input>
					<form:errors path="sex" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Komplet łapek:</span>
	 				<form:input path="paws" id="paws" ></form:input>
					<form:errors path="paws" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Sterylizacja:</span>	
					<form:input path="sterizlization" id="sterizlization" ></form:input>
					<form:errors path="sterizlization" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Wzrok:</span>	
					<form:input path="sight" id="sight" ></form:input>
					<form:errors path="sight" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Rasa:</span>	
					<form:input path="race" id="race" ></form:input>
					<form:errors path="race" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Nazwa oddziału:</span>	
					<form:input path="origin" id="origin" ></form:input>
					<form:errors path="origin" cssclass="error" />
				</div>
				<div class=names>
					<span>Klient:</span>	
					<form:input path="origin" id="origin" ></form:input>
					<form:errors path="origin" cssclass="error" />
				</div>
				<div class=names>
				</div>

				<input type="submit" value="Zapisz" />

			</form:form>

</jsp:body>
</t:main>
