<%@ include file="common/header.jspf" %>
<title>Login</title>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Login</h1>
    <pre>${error}</pre>
    <form method="post">
        <label>
            Name :
            <input type="text" name="name">
        </label>
        <label>
            Password :
            <input type="password" name="password">
        </label>
        <input type="submit">
    </form>
</div>
</body>
</html>