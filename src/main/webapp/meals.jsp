<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>Meals</h2>
    <h3><a href="">Add meal</a></h3>
<table border=1>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
     <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>
     <c:forEach items="${mealsTo}" var="meal">
         <tr style=color:${meal.excess ? "red" : "green"}>
            <td><javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="">Update</a></td>
            <td><a href="">Delete</a></td>
         </tr>
     </c:forEach>
    </tbody>
</table>
</body>
</html>
