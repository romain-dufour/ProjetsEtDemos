<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une consultation</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Ajouter une consultation </h2>
    </center>
    </center>
    <div>
        <form action="insert_consultation" method="post">
            <div class="form-row">

                    <input type="hidden" name="patientId" value="<c:out value='${patient.getId()}' />" />

                <div class="form-group col-md-6">
                    <label for="inputConsultDate">Date de la consultation</label>
                    <input type="date" class="form-control" id="inputConsultDate" name="consultDate">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputDoctorName">Nom du docteur</label>
                    <input type="text" class="form-control" id="inputDoctorName" name="doctorName" >
                </div>

            </div>
            <div class="form-row">
                <div class="mb-3">
                    <a href="newPrescription" class="btn btn-secondary text-start">Ajouter une prescription </a>
                    <a href="newFicheDeSoin" class="btn btn-primary text-start">Ajouter une fiche de soin </a>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Valider</button>
        </form>
    </div>
</div>
</body>
</html>
