<%@ page import="com.taobao.api.domain.TransitStepInfo" %>
<html>
<head>
    <title>买啥了</title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<c:forEach items="${traceList}" var="a">
${a.statusTime} : ${a.statusDesc}<br>
</c:forEach>
${status}

</body>
</html>