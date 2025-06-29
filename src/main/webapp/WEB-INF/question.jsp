<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Question ${node.id}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
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