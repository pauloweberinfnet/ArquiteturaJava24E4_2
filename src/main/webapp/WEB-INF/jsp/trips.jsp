<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Frota - Viagens</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mb-4 text-center">Gerenciamento de Frota - Viagens</h1>
        <a href="/" class="btn btn-primary mb-3">🏠 Início</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Início</th>
                    <th>Distância (km)</th>
                    <th>Duração</th>
                    <th>Consumo</th>
                    <th>Motorista</th>
                    <th>Veículo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trips}" var="trip">
                    <tr>
                        <td>${trip.startTime}</td>
                        <td><fmt:formatNumber value="${trip.distance}" type="number" minFractionDigits="2" maxFractionDigits="2" pattern="#,##0.00"/></td>
                        <td>${trip.tripDuration}</td>
                        <td><fmt:formatNumber value="${trip.fuelConsumption}" type="number" minFractionDigits="2" maxFractionDigits="2" pattern="#,###0.0"/> ${trip.vehicle.vehicleType == 'Eletric' ? 'Wh' : 'l'}</td>
                        <td>${trip.driver.name}</td>
                        <td>${trip.vehicle.model}/${trip.vehicle.modelYear} - ${trip.vehicle.licensePlate}</td>
                      </tr>
                </c:forEach>
            </tbody>
        </table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
