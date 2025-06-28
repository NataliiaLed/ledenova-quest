<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Loose ${node.id}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
    <h2>Oh no! ${node.text}</h2>
    <a href="${pageContext.request.contextPath}/quests/${questId}?nodeId=start">Intentar otra vez</a>
</body>
</html>
