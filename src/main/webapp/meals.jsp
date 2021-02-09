<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
    <h2>Meals page</h2>
<table border=1>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
    <tbody>
    <!--<tr>
        <td>Date</td>
        <td>Descript</td>
        <td>Calories</td>
    </tr> -->

     <c:forEach items="${pageScope.mealsTo}" var="mea">
         <tr>
            <td><c:out value="${mea.dateTime}"/></td>
            <td><c:out value="${mea.description}"/></td>
            <td><c:out value="${mea.calories}"/></td>
         </tr>
     </c:forEach>
    </tbody>
</table>
</body>
</html>
