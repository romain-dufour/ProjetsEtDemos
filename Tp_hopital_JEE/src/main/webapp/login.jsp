<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Inclusion du CSS de Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Inclusion du JavaScript de Bootstrap (avec les dépendances nécessaires) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <title>Login</title>
</head>
<body>
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <h2> Login </h2>
    <form action="user" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input type="text" class="form-control" id="email" name="email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>

    </form>
</div>
<c:if test="${not empty sessionScope.loginError}">
    <div class="modal" tabindex="-1" role="dialog" id="errorModal">
        <div class="modal-dialog " role="document">
            <div class="modal-content">
                <div class="modal-header bg-danger">
                    <h5 class="modal-title">Erreur de Connexion</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>${sessionScope.loginError}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('#errorModal').modal('show');
            <% session.removeAttribute("loginError"); %>
        });
    </script>
</c:if>

</body>
</html>
