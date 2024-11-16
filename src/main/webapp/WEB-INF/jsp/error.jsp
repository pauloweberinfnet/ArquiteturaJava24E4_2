
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Error</title>
    <style>
        .error-container {
            width: 80%;
            margin: 50px auto;
            text-align: center;
            font-family: Arial, sans-serif;
        }
        .error-code {
            font-size: 72px;
            color: #e74c3c;
            margin-bottom: 20px;
        }
        .error-message {
            font-size: 24px;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        .home-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .home-link:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-code">
            <h1>${pageContext.errorData.statusCode}</h1>
        </div>
        <div class="error-message">
            <c:choose>
                <c:when test="${pageContext.errorData.statusCode == 404}">
                    The page you're looking for could not be found.
                </c:when>
                <c:when test="${pageContext.errorData.statusCode == 403}">
                    Access to this resource is forbidden.
                </c:when>
                <c:when test="${pageContext.errorData.statusCode == 500}">
                    An internal server error occurred.
                </c:when>
                <c:otherwise>
                    An unexpected error has occurred.
                </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${not empty pageContext.exception}">
            <div class="error-details">
                Error details: ${pageContext.exception.message}
            </div>
        </c:if>
        <a href="<c:url value='/'/>" class="home-link">Return to Home</a>
    </div>
</body>
</html>
