<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Frota - Motoristas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mb-4 text-center">Gerenciamento de Frota - Motoristas</h1>
        <a href="/" class="btn btn-primary mb-3">🏠 Início</a>
        <table class="table table-striped">
            <thead>
              <th>ID</th>
              <th>Nome</th>
              <th>CNH</th>
            </thead>
            <tbody id="driversBody">
              <!-- O código abaixo refere-se ao carregamento via AppController -->
              <!-- <c:forEach items="${drivers}" var="driver">
                <tr>
                  <td>${driver.id}</td>
                  <td>${driver.name}</td>
                  <td>${driver.licenseId}</td>
                </tr>
              </c:forEach> -->
            </tbody>
        </table>

        </div>
        <script>
          fetch('/api'+location.pathname+location.search)
              .then(response => response.json())
              .then(drivers => {
                  const driversBody = document.getElementById('driversBody');
                  drivers.forEach(driver => {
                      const row = document.createElement('tr');
                      row.innerHTML = '<td>' +  driver.id + '</td>' +
                      '<td>' + driver.name + '</td>' +
                      '<td>' + driver.licenseId + '</td>' ;
                      driversBody.appendChild(row);
                  });
              })
              .catch(error => console.error('Error loading drivers:', error));
      </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>