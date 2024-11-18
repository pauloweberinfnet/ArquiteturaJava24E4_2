<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Frota - Veículos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mb-4 text-center">Gerenciamento de Frota - Veículos</h1>
        <a href="/" class="btn btn-primary mb-3">🏠 Início</a>
        <table class="table table-striped">
          <thead>
            <th>ID</th>
            <th>Modelo</th>
            <th>Ano</th>
            <th>Placa</th>
            <th>Tipo</th>
            <th>Odometro</th>
            <th>Bateria Nominal / Combustível</th>
            <th>Bateria (kWh) / Nível Tanque (l)</th>
            <th>Bateria (%) / Capacidade Tanque (l)</th>
          </thead>
          <tbody id="vehiclesBody">
            <!-- O código abaixo refere-se ao carregamento via AppController -->
            <!-- <c:forEach items="${vehicles}" var="vehicle">
              <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.modelYear}</td>
                <td>${vehicle.licensePlate}</td>
                <td>${vehicle.vehicleType}</td>
                <td>${vehicle.odometer}</td>
                <td>${vehicle.vehicleType == 'Eletric' ? vehicle.batteryNominalCapacity : vehicle.fuelType}</td>
                <td>${vehicle.vehicleType == 'Eletric' ? vehicle.batteryCurrentCapacity : vehicle.fuelLevel}</td>
                <td>${vehicle.vehicleType == 'Eletric' ? vehicle.batteryHealth : vehicle.fuelTankCapacity}</td>
              </tr>
            </c:forEach> -->
          </tbody>
        </table>
        <div class="btn-group" role="group" aria-label="Filtrar Veículos">
            <a href="/vehicles/eletric" class="btn btn-outline-primary">Veículos Elétricos</a>
            <a href="/vehicles/combustion" class="btn btn-outline-primary">Veículos à Combustão</a>
        </div>

      </div>

      <script>
        fetch('/api/vehicles')
            .then(response => response.json())
            .then(vehicles => {
                const vehiclesBody = document.getElementById('vehiclesBody');
                vehicles.forEach(vehicle => {
                    const row = document.createElement('tr');

                    batteryCapacityOrFuelType = vehicle.vehicleType == 'Eletric' ? vehicle.batteryNominalCapacity : vehicle.fuelType;
                    batteryLevelOrFuelLevel = vehicle.vehicleType == 'Eletric' ? vehicle.batteryCurrentCapacity : vehicle.fuelLevel;
                    batteryHealthOrTankCapacity = vehicle.vehicleType == 'Eletric' ? vehicle.batteryHealth.toLocaleString('pt-BR') : vehicle.fuelTankCapacity;

                    row.innerHTML = '<td>' +  vehicle.id + '</td>' +
                    '<td>' + vehicle.model + '</td>' +
                    '<td>' + vehicle.modelYear + '</td>' +
                    '<td>' + vehicle.licensePlate + '</td>' +
                    '<td>' + vehicle.vehicleType + '</td>' +
                    '<td>' + vehicle.odometer.toLocaleString('pt-BR') + '</td>' +
                    '<td>' + batteryCapacityOrFuelType + '</td>' +
                    '<td>' + batteryLevelOrFuelLevel.toLocaleString('pt-BR') + '</td>' +
                    '<td>' + batteryHealthOrTankCapacity.toLocaleString('pt-BR') + '</td>';
                    console.log(row);
                    vehiclesBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error loading vehicles:', error));
    </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>