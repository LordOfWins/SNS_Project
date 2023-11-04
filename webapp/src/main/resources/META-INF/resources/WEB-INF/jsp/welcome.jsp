<%--@elvariable id="name" type="java.lang.String"--%>
<%@ include file="common/header.jspf" %>
<title>Welcome</title>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Welcome ${name}</h1>
    <div><a href="list">Manage</a> your todos</div>
</div>
</body>
</html>