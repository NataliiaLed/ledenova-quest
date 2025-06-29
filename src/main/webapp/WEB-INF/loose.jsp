<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Ви програли ${node.id}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
    <div class="nav-left">
        <span>👋 Привіт, ${sessionScope.userName}!</span>
    </div>
    <div class="nav-right">
        <a href="${pageContext.request.contextPath}/enter">📜 Повернутися до квестів</a>
        <a href="${pageContext.request.contextPath}/quests/${questId}">🔁 Почати квест спочатку</a>
    </div>
    <h2>О ні! ${node.text}</h2>
    <a href="${pageContext.request.contextPath}/quests/${questId}?nodeId=start">Спробувати знов</a>
</body>
</html>
