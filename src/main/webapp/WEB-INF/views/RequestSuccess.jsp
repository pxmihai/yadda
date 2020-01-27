<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="application/javascript" src="<c:url value="/resources/javascript/pxgradient-1.0.3.js"/>"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/normalize.css"/> " rel="stylesheet"/>
    <link href="<c:url value="/resources/css/skeleton.css"/> " rel="stylesheet"/>


  <title>Summary Succeeded!</title>
</head>
<body>

<div align="center">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2 class="text">Summary Succeeded!</h2></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <h3>Thank you for using this service! Here is the result:</h3>
      </td>
    </tr>
      <tr >
          <td >The summary :</td>
          <td >
              <c:forEach var="i" items="${splitList}" varStatus="loopCounter">
                  <c:choose><c:when test="${splitList2.contains(i)}">
                      <SPAN style="BACKGROUND-COLOR: #ffff00"><c:out value="${i}"/><c:out value="[${loopCounter.count}]"/> </SPAN>
                  </c:when><c:otherwise>
                      <c:out value="${i}"/>
                  </c:otherwise></c:choose>
              </c:forEach>

          </td>
      </tr>
      <tr>
          <td>Sentences the text has:</td>
          <td>${snum}</td>
      </tr>
    <tr>
      <td>Sentences requested:</td>
      <td>${requestForm.num}</td>
    </tr>

      <tr>
          <td>Percent requested:</td>
          <td>${requestForm.procent}</td>
      </tr>
    <tr>
        <td>Original Text:</td>
        <td >
              <c:forEach var="i" items="${splitList}" end="${snum}">
              <c:out value="${i}"/>
              </c:forEach>
        </td>
      </tr>

      <script></script>
      <script>
          $(".text").pxgradient({ // any jQuery selector
              step: 10,
              colors: ["#fc0","#0fc","#00f"], // hex (#4fc05a or #333)
              dir: "x" // direction. x or y
          });
      </script>

  </table>

    <form action="/request">
        <input type="submit" value="Go back and try again">
    </form>

</div>
</body>
</html>