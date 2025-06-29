<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String userName = (String) session.getAttribute("userName");
%>
<html>
<head>
<title>Привіт</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
</head>
<body>
    <h1>Привіт, <%= userName != null ? userName : "незнайомець" %>!</h1>
    <p>Обери свій квест</p>
    <ul>
        <li><a href="quests/kira-quest">Зимні пригоди в Хогвардсі (UA)</a></li>
        <li><a href="quests/elara-quest">Elara (ES)</a></li>
    </ul>
</body>
</html>
