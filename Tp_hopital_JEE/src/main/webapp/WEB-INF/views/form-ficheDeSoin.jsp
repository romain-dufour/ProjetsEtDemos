<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire fiche de soin</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Ajouter un fiche de soin</h2>
    </center>
    </center>
    <div>
        <form action="insert_fiche_de_soin" method="post">
            <div class="form-row">
                <input type="hidden" name="consultationId" value="<c:out value='${consultation.getId()}' />" />

                <div class="form-group col-md-6">
                    <label for="inputTypeOfCare">Type de soin</label>
                    <input type="text" class="form-control" id="inputTypeOfCare" name="inputTypeOfCare">
                </div>
                <div class="form-group col-md-6">
                    <label for="InputDuration">Durée des soins (en jours)</label>
                    <input type="number" class="form-control" id="InputDuration" name="duration" >
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
    </div>
</div>
</body>
</html>
