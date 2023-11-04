<%@ include file="common/header.jspf" %>
<title>List Todo</title>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div id="container">
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="todos" type="com.springstudy.webapp.todo.Todo"--%>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.isDone}</td>
                <td><a href="update?id=${todo.id}" class="btn btn-outline-success">Update</a></td>
                <td><a href="delete?id=${todo.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>
