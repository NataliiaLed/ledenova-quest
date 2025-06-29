<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Привіт</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
</head>
<body>
    <h2>Привіт! Будь ласка, вкажи своє ім'я :</h2>
    <form method="post" action="${pageContext.request.contextPath}/enter">
        <input type="text" name="name" required autofocus />
        <button type="submit">Увійти</button>
    </form>
</body>
</html>
