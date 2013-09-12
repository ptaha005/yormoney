<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="registration_header" var="l_header"/>
<spring:message code="registration_firstname" var="l_firstname"/>
<spring:message code="registration_lastname" var="l_lastname"/>
<spring:message code="registration_address" var="l_adress"/>
<spring:message code="registration_postcode" var="l_postcode"/>
<spring:message code="registration_email" var="l_email"/>
<spring:message code="registration_dob" var="l_dob"/>
<spring:message code="registration_occupation" var="l_occupation"/>
<spring:message code="registration_username" var="l_username"/>
<spring:message code="registration_password" var="l_password"/>
<spring:message code="registration_repassword" var="l_repassword"/>
<spring:message code="registration_label_activateCode" var="l_activationCode"/>
<spring:message code="registration_button_activateCode" var="b_activationCode"/>
<spring:message code="registration_label_messageMail" var="l_messageACode"/>
<spring:message code="registration_video_ref" var="s_refVideo"/>
<spring:message code="registration_message1" var="t_message1"/>
<spring:message code="registration_button_submit" var="b_submit"/>
<spring:message code="registration_checkbox_terms" var="cb_terms"/>
<spring:message code="registration_button_terms" var="b_terms"/>

<div id="all_body">
    <div id="header">
        <div id="logo"><a href="#"></a></div>
        <div id="exit"><a class="exit" href="#"></a></div>
    </div>
    <div id="content">
        <div class="title_form"><span>Y&ouml;r - Start-up Wizard</span></div>
        <div id="left_content_register">
            <div class="title_left_content">
                <span class="image"></span>
                <span class="title_left_main">${l_header}</span>
            </div>
            <div id="form_registration">
                <form:form action="#" method="post" id="reg_form" modelAttribute="registrationForm">
                    <div class="left_form">
                        <div class="inputs">
                            <form:label path="firstname" for="name" class="name_field_input">${l_firstname}</form:label>
                            <form:input path="firstname" type="text" value="" id="name" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <form:label path="lastname" for="lname" class="name_field_input">${l_lastname}</form:label>
                            <form:input path="lastname" id="lname" type="text" value="" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <form:label path="address1" for="address" class="name_field_input">${l_adress}</form:label>
                            <form:input path="address1" id="address" type="text" value="" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <label class="name_field_input"></label>
                            <form:input path="address2" type="text" value="" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <label class="name_field_input"></label>
                            <form:input path="address3" type="text" value="" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <form:label path="postcode1" for="pcode" class="name_field_input">${l_postcode}</form:label>
                            <form:input path="postcode1" id="pcode" type="text" value="" class="input_field_small input_field first" maxlength="5"/>
                            <form:input path="postcode2" type="text" value="" class="input_field_small input_field second" maxlength="5"/>
                        </div>
                        <div class="inputs">
                            <form:label path="email" for="email" class="name_field_input">${l_email}</form:label>
                            <form:input path="email" id="email" type="text" value="" class="input_field" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <form:label path="dateOfBirth" for="dob" class="name_field_input">${l_dob}</form:label>
                            <form:input path="dateOfBirth" id="dob" type="text" value="" class="input_field"/>
                        </div>
                        <div class="inputs">
                            <form:label path="occup" for="occup" class="name_field_input">${l_occupation}</form:label>
                            <form:input path="occup" id="occup" type="text" value="" class="input_field" maxlength="150"/>
                        </div>
                    </div>
                    <div class="right_form">
                        <div class="inputs">
                            <form:label path="username" for="username" class="name_field_input">${l_username}</form:label>
                            <form:input path="username" id="username" type="text" value="" class="input_field" placeholder="desired username" maxlength="30"/>
                        </div>
                        <div class="inputs">
                            <form:label path="password" for="pass" class="name_field_input">${l_password}</form:label>
                            <form:input path="password" id="pass" type="text" value="" class="input_field" placeholder="desired password" maxlength="20"/>
                        </div>
                        <div class="inputs button">
                            <input type="submit" class="button_inp" value="${b_activationCode}" />
                        </div>
                        <div class="title_active_code">${l_activationCode}</div>
                        <div class="inputs active_code">
                            <form:input path="activationCode1" type="text" value="" class="input_field_small_right input_field" maxlength="5"/>
                            <form:input path="activationCode2" type="text" value="" class="input_field_small_right sec input_field" maxlength="5"/>
                            <form:input path="activationCode3" type="text" value="" class="input_field_small_right sec input_field" maxlength="5"/>
                            <form:input path="activationCode4" type="text" value="" class="input_field_small_right sec input_field" maxlength="5"/>
                        </div>
                        <div class="inputs button">
                            <input type="submit" class="button_inp" value="Click here to activate" />
                        </div>
                        <div class="inputs radio">
                            <form:checkbox path="agree" id="agree" class="button_rad" value="1"/>
                            <span class="terms_conditions" for="agree">${cb_terms}</span>
                        </div>
                        <div class="inputs button">
                            <input type="submit" class="button_inp_terms" value="${b_terms}" />
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div id="right_content_register">
            <div class="title_video_text_right_content">
                <span class="title_right_main">How to?</span>
                <div class="block_title_text_right">
                    <span class="title_block">How to fill in this form...</span>
                    <span class="text_block">Input all your details in the fields opposite. Please note; all fields are mandatory.</span>
                </div>
                <div class="block_title_text_right">
                    <span class="title_block">How to activate...</span>
                    <span class="text_block">Place your activation code in the input field and read the terms and conditions. If you are happy to then proceed, agree to the terms and click the button to activate.</span>
                </div>
                <div class="block_title_text_right">
                    <span class="title_block">How to purchase an activation code...</span>
                    <span class="text_block">Simply click the 'Purchase an activation code' button and our system will take you through to  a secure payment page.</span>
                </div>
                <div class="video_youtube">
                    <span class="title_right_main">Help Video</span>
                    <div class="video"></div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
    </div>
    </d