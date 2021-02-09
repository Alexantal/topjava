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
<table border=1>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
    <tbody>
     <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>
     <c:forEach items="${mealsTo}" var="mea">
         <tr style=${mea.excess ? "color:red" : "color:green"}>
            <td><javatime:format value="${mea.dateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td><c:out value="${mea.description}"/></td>
            <td><c:out value="${mea.calories}"/></td>
         </tr>
     </c:forEach>
    </tbody>
</table>
</body>
</html>
