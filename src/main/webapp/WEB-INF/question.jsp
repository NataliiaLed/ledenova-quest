<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Обери ${node.id}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
<div class="navbar">
    <div class="nav-left">
        <span>👋 Привіт, ${sessionScope.userName}!</span>
    </div>
    <div class="nav-right">
        <a href="${pageContext.request.contextPath}/enter">📜 Повернутися до квестів</a>
        <a href="${pageContext.request.contextPath}/quests/${questId}">🔁 Почати квест спочатку</a>
    </div>
</div>
    <h2>${node.text}</h2>
    <ul>
        <c:forEach var="decision" items="${node.decisionOptions}">
            <li>
                <a href="${pageContext.request.contextPath}/quests/${questId}?nodeId=${decision.questItemId}">
                    ${decision.decision}
                </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>