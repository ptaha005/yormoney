<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertAttribute name="plugin"/>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Y&ouml;r  - <tiles:insertAttribute name="title" ignore="true"/></title>
    </head>
    <body>
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="main"/>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>