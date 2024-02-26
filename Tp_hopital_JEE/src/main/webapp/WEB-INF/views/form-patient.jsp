<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add patient</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <center>
            <h2>Ajouter un patient </h2>
    </center>
    </center>
    <div>
        <form action="insert_patient" method="post" enctype="multipart/form-data">
            <div class="form-row">

                <div class="form-group col-md-6">
                    <label for="inputName">Nom</label>
                    <input type="text" class="form-control" id="inputName" name="lastName">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputFirstName">Prenom</label>
                    <input type="text" class="form-control" id="inputFirstName" name="firstName" >
                </div>
                <div class="form-group col-md-6">
                    <label for="inputBirthDate">Date de naissance</label>
                    <input type="date" class="form-control" id="inputBirthDate" name="birthDate">
                </div>
            </div>
            <div class="form-row">
                <div class="mb-3">
                    <label for="formFile" class="form-label">Photo</label>
                    <input class="form-control" type="file" id="formFile" name="picture" accept=".jpg" >
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
    </div>
</div>
</body>
</html>
