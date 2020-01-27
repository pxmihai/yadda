<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
  <link href="<c:url value="/resources/css/normalize.css.css"/> " rel="stylesheet"/>
  <link href="<c:url value="/resources/css/skeleton.css"/> " rel="stylesheet"/>

  <title>Enter data</title>
</head>
<body>
<div align="center">
  <form:form action="request" method="post" commandName="requestForm">
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2>Summary data entry - Input your text <br></h2>Either enter the number of sentences you want to receive from the summariser or leave it to 0 and select a percent.</td>
        <td> </td>
      </tr>

      <tr>
        <td>Number:</td>
        <td><form:input path="num" value="0" /></td>
      </tr>
      <tr>
        <td>Percent:</td>
        <td><form:select path="procent" items="${procList}" /></td>
      </tr>
        <td>Text:</td>

        <td><form:textarea path="text" cssStyle="width: 500px; height: 250px ;text-align: left"/></td>

      </tr>

      <tr>
        <td colspan="2" align="center"><input type="submit" value="Request" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>