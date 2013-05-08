<%@ page contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Whiteboard Blueprint Xml Web App - Foo</title>
    </head>
    <body>
    <h1>Foo - Hello World</h1>
    <img height="200" width="200" src="images/foo_wallpaper.sized.jpg"/><br/>

    <a href="./servlet/Foo">FooServlet</a>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <p>The Date is: <fmt:formatDate type="both"
                                           dateStyle="long" timeStyle="long"
                                           value="${now}" /></p>
    </body>
</html>