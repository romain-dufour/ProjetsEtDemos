<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire prescription</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Ajouter une prescription</h2>
    </center>
    </center>
    <div>
        <form action="insert_prescription" method="post">
            <div class="form-row">
                <input type="hidden" name="consultationId" value="<c:out value='${consultation.getId()}' />" />

                <div class="form-group col-md-6">
                    <label for="inputMedicType">Type de médicament</label>
                    <input type="text" class="form-control" id="inputMedicType" name="medicType">
                </div>
                <div class="form-group col-md-6">
                    <label for="InputDuration">Durée de la prescription (en jours)</label>
                    <input type="number" class="form-control" id="InputDuration" name="duration" >
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
    </div>
</div>
</body>
</html>
