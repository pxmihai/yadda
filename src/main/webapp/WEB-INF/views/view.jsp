<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Yadda Yadda Yadda</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/normalize.css.css"/> " rel="stylesheet"/>
    <link href="<c:url value="/resources/css/skeleton.css"/> " rel="stylesheet"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/images/favicon.png"/>">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="one-half column" style="margin-top: 25%">
            <h4>Welcome!</h4>

            <p>This is the home for an App. It's goal is to summarize text.<br>

            <br>It was built in Intellij IDEA and is using Apache Tomcat and Spring MVC.
            The App uses some API's that use <a href="http://www.nltk.org/" target="_blank">NLTK</a> to process the text and return its summary.
            The summary is then highlighted in the original text.
            The idea is to aid in finding information that might be relevant, faster.<br>

            <br>
            The website name is a reference to <a href="https://en.wikipedia.org/wiki/The_Yada_Yada" target="_blank">the yada yada</a>, an episode from Seinfeld.
            "George's new girlfriend Marcy (Suzanne Cryer) likes to say "yada yada yada" to shorten her stories."
            <br>
            Note: The extra <strong>d</strong> was added because <strong>yada</strong> was not available.

            <form action="/request">
            <input type="submit" value="Go to App">
        </form>

        </p>

        </div>
    </div>
</div>

</body>
</html>