<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Liste des patients</h2>
    </center>
    <div class="m-4">
        <a href="newPatient" class="btn btn-success text-start">Ajouter un Patient </a>
        <c:if test="${user != null }">
            <a href="newPatient" class="btn btn-success text-start">Ajouter un Patient </a>
        </c:if>
    </div>

    <center>
        <div>
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="search">Search</label>
                        <input type="search" class="form-control" id="search" name="search" >
                    </div>
                </div>
            </form>
        </div>


        <table border="1" cellpadding="5" class="table table-dark text-center" >
            <caption><h2>Liste des Patients</h2></caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de naissance</th>
            </tr>

            <c:forEach items="${patient}" var="patient">
                <tr>
                    <td>${patient.getId()}</td>
                    <td> <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image du patient"></td>
                    <td>${patient.getLastName()}</td>
                    <td>${patient.getFirstName()}</td>
                    <td>${patient.getBirthDate()}</td>

                    <td>
                        <a href="detailsPatient?id=${patient.getId()}" class="btn btn-primary">Details</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>

</div>


</body>
</html>
