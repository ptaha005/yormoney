<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<spring:message code="signin_forgotusername" var ="a_fusername"/>
<spring:message code="signin_forgotpassword" var ="a_fpassword"/>
<spring:message code="signin_registration"   var="a_reg"/>
<spring:message code="signin_extra" var ="a_extra"/>
<spring:message code="signin_username" var="l_username"/>
<spring:message code="signin_password" var="l_password"/>
<spring:message code="signin_button" var ="b_text"/>

<!DOCTYPE html>
<div class="login_page">
    <div class="logo">
        <a href="#"><img src="/pages/img/logo_login.png" alt="logo"/></a>
    </div>

    <form class="login_form">
        <div class="names">
            <label for="uname" class="label">${l_username}</label>
            <input type="text" value="" id="uname" class="inputs"/>
        </div>

        <div class="names">
            <label for="name" class="label">${l_password}</label>
            <input type="text" value="" id="name" class="inputs"/>
        </div>
    </form>

<div class="forgot">
        <div class="forg_uname">
            <a href="/pages/index.html">${a_reg}</a>
            <a href="#">${a_fusername} - ${a_extra}</a>
        </div>
        <div class="forg_pass">
            <a href="#">${a_fpassword} - ${a_extra}</a>
        </div>
    </div>

    <div class="social">
        <a href="#" class=""><img src="/pages/img/facebook.png" alt="facebook"></a>
        <a href="#" class="icons"><img src="/pages/img/tweet.png" alt="facebook"></a>
        <a href="#" class="icons"><img src="/pages/img/inn.png" alt="facebook"></a>
        <a href="#" class="icons"><img src="/pages/img/youtube.png" alt="facebook"></a>
    </div>

</div>
