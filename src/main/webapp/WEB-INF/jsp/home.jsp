<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Frota</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mb-4 text-center">Gerenciamento de Frota</h1>

        <div class="d-flex flex-column flex-md-row align-items-center justify-content-center">
            <div class="list-group mb-3">
                <a href="/trips" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
                    <span class="d-flex align-items-center text-body-emphasis text-decoration-none" style="font-size: 3rem;">🗺️</span>
                    <div class="¨d-flex w-100 justify-content-between">
                        <h5 class="mb-0">Viagens <small class="badge text-bg-primary rounded-pill">${tripCount}</small></h6>
                        <p class="mb-0 opacity-75">Listar todas viagens</p>
                    </div>
                </a>
                <a href="/drivers" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
                    <span class="d-flex align-items-center text-body-emphasis text-decoration-none" style="font-size: 3rem;">🧑</span>
                    <div class="¨d-flex w-100 justify-content-between">
                        <h5 class="mb-0">Motoristas <small class="badge text-bg-primary rounded-pill">${driverCount}</small></h6>
                        <p class="mb-0 opacity-75">Listar todos motoristas</p>
                    </div>
                </a>
                <a href="/vehicles" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
                    <span class="d-flex align-items-center text-body-emphasis text-decoration-none" style="font-size: 3rem;">🚙</span>
                    <div class="¨d-flex w-100 justify-content-between">
                        <h5 class="mb-0">Veículos <small class="badge text-bg-primary rounded-pill">${vehicleCount}</small></h6>
                        <p class="mb-0 opacity-75">Listar todos veículos</p>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
