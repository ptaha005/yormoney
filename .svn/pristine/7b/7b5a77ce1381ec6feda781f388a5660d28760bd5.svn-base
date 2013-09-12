<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="welcome_video_ref1"   var="s_refVideo1"/>
<spring:message code="welcome_video_ref2"   var="s_refVideo2"/>
<spring:message code="welcome_video_ref3"   var="s_refVideo3"/>
<spring:message code="welcome_message1"     var="t_message1"/>
<spring:message code="welcome_a_next"       var="a_next"/>


<script type="text/javascript">

    $(document).ready(function(){
        $("videostep1").mediaelementplayer();
        $("videostep2").mediaelementplayer();
        $("videostep3").mediaelementplayer();
    });

   </script>

<style type="text/css">
</style>


<!DOCTYPE html>
<nav id="mainleftstep1">

</nav>
<section id="maincenterstep1">

    <a href="/registration/relationships">${a_next}</a>

</section>

<aside id="mainrightstep1">

    <h1>${t_message1}</h1>
    <video id="videostep1" poster="/resources/images/logo.png" width="300" height="250">
        <source type="video/youtube" src="${s_refVideo1}" />
    </video>
    <video id="videostep2" poster="/resources/images/logo.png" width="300" height="250">
        <source type="video/youtube" src="${s_refVideo2}" />
    </video>
    <video id="videostep3" poster="/resources/images/logo.png" width="300" height="250">
        <source type="video/youtube" src="${s_refVideo3}" />
    </video>
</aside>