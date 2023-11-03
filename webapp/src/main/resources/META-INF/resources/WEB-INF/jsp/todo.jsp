<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css"
          rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Add Todo Page</title>
</head>
<body>
<div id="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        Description: <form:input type="text" path="description" required="required"/>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="isDone"/>
        <input type="submit" class="btn btn-success"/>
    </form:form>
</div>
<script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.4\jquery.min.js"></script>
</body>
</html>