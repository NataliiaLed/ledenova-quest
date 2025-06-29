<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Win ${node.id}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" /></head>
<body>
    <h2>Congratulations! ${node.text}</h2>
    <a href="${pageContext.request.contextPath}/quests/${questId}?nodeId=start">Try again</a>
</body>
</html>
