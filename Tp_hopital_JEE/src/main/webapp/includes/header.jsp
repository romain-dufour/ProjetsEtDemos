
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp" />
    <title></title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#">M2I Hospital</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="patientList">Accueil <span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${user != null }">
            <li class="nav-item">
                    <a href="newPatient" class="btn btn-success text-start">Ajouter un Patient </a>
            </li>
            </c:if>
        </ul>
        <div class="form-inline  gx-4 my-lg-0 text-center ">
            <c:if test="${not empty sessionScope.name}">
                <div class="mx-4">
                    <i class="bi bi-person-circle"></i><br>
                    <span>${sessionScope.name}</span>
                </div>
            </c:if>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="user">Logout</a>
        </div>
    </div>
</nav>
</body>
</html>
