<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="relationships_video_ref1"     var="s_refVideo1"/>
<spring:message code="relationships_t_message1"       var="t_message1"/>
<spring:message code="relationships_t_message2"       var="t_message2"/>
<spring:message code="relationships_t_message3"       var="t_message3"/>


<script type="text/javascript">

    $(document).ready(function(){
        $("videostep1").mediaelementplayer();
    });

</script>

<style type="text/css">
</style>


<!DOCTYPE html>
<nav id="mainleftstep1">

</nav>
<section id="maincenterstep1">


</section>

<aside id="mainrightstep1">

    <h1>${t_message3}</h1>
    <video id="videostep1" poster="/resources/images/logo.png" width="300" height="250">
        <source type="video/youtube" src="${s_refVideo1}" />
    </video>
</aside>