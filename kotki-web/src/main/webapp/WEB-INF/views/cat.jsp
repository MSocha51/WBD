<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:main>
	<jsp:body>

		<span class="minititle"><strong>${cat.name}</strong></span>
			<br/>
			<div id="text">
			<div class="names">
				<span>Imię:</span>
				${cat.name }<br />
			</div>
			<div class=names>
				<span>Data urodzenia:</span>
				${cat.birthdayDate }<br />
			</div>
			<div class=names>
				<span>Płeć:</span>
				${cat.sex }<br />
			</div>
			<div class=names>
				<span>Komplet łapek:</span>
				${cat.pawns }<br />
			</div>
			<div class=names>
				<span>Sterylizacja:</span>
				${cat.sterizlization }<br />
			</div>
						<div class=names>
				<span>Wzrok:</span>
				${cat.sight }<br />
			</div>
			<div class=names>
			<span>Rasa:</span>
				<br />
			</div>
			<div class=names>
			<span>Nazwa oddziału:</span>
				<br />
			</div>
			<div class=names>
			<span>Klient:</span>
				<br />
			</div>
	<form class="button" action="/" method=post>
			<input type="submit" value="Edytuj" />
			</form>
			<form class="button" action="/" method=post>
			<input type="submit" value="Adoptuj" />
			</form>
			</div>
			

</jsp:body>
</t:main>
