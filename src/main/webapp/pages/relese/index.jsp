<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
        <title>Y&ouml;r  - Registration</title>

<c:choose>
    <c:when test="${env == 'dev'}">
        <link rel="stylesheet" type="text/css" href="/pages/css/main.css">
    </c:when>
    <c:otherwise>
        <link rel="stylesheet" type="text/css" href="/pages/relese/css/main.css">
    </c:otherwise>
</c:choose>


	</head>
	<body class="body loding">
        <img class="loding" src="/pages/img/loding.gif">
    <!-- ko with : content -->
		<!-- ko template : { html : template } -->
		<!-- /ko -->
        <!-- /ko -->
            <!-- ko with : popup -->
        <!-- ko template : { html : template } -->
        <!-- /ko -->
    <!-- /ko -->
	</body>

    <c:choose>
        <c:when test="${env == 'dev'}">
            <script data-main="/pages/app/main" src="/pages/app/lib/require/require.js" type="text/javascript"></script>
        </c:when>
        <c:otherwise>
            <script data-main="/pages/relese/app/main" src="/pages/relese/app/main.js" type="text/javascript"></script>  
        </c:otherwise>
    </c:choose>

</html>