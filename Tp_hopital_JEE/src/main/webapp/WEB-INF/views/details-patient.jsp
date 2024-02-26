<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dossier médical</title>
    <jsp:include page="../../includes/head.jsp"/>

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Dossier médical de monsieur ${patient.getLastName()}</h2>
    </center>

    <div class="m-4">
    <a href="newConsultation" class="btn btn-success text-start">Ajouter une consultation </a>

</div>
    <center>


        <table border="1" cellpadding="5" class="table table-dark text-center">
            <caption><h2>Liste des consultations</h2></caption>
            <tr>
                <th>Id</th>
                <th>Date de consultation</th>
                <th>Nom du docteur</th>
                <th>Liste des prescriptions</th>
                <th>Liste des fiches de soins</th>
            </tr>

            <tr>
                <td>${consultation.getId()}</td>
                <td>${consultation.getConsultDate()}</td>
                <td>${consultation.getDoctorName()}</td>
                <c:forEach items="${consultation}" var="consultation">
            <tr>
                <td>${consultation.getBirthDate()}</td>

                <td>
                    <a href="detailsPatient?id=${patient.getId()}" class="btn btn-primary">Details</a>
                </td>
            <td>
                <a href="newConsultation?id=${consultation.getId()}" class="btn btn-info">Ajouter une prescription</a>
                <a href="newFicheDeSoin?id=${consultation.getId()}" class="btn btn-secondary">Ajouter une fiche de soin</a>
            </td>
            </tr>
            </c:forEach>


            </tr>
        </table>
    </center>

</div>


</body>
</html>
