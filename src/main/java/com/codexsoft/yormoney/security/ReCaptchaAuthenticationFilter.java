package com.codexsoft.yormoney.security;

import net.tanesha.recaptcha.ReCaptchaImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter implements InitializingBean {

    protected Logger log = Logger.getLogger("filter");
    private final String CAPTCHA_CHALLENGE_FIELD = "recaptcha_challenge_field";
    private final String CAPTCHA_RESPONSE_FIELD = "recaptcha_response_field";
    private final ReCaptchaImpl reCaptcha;
    private String privateKey;

    public ReCaptchaAuthenticationFilter() {
        this.reCaptcha = new ReCaptchaImpl();
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public void afterPropertiesSet(){
        if (StringUtils.isEmpty(this.privateKey)){
            throw new IllegalArgumentException("The 'privateKey' should be set for the bean type 'ReCaptchaAuthenticationFilter'");
        } else {
            reCaptcha.setPrivateKey(this.privateKey);
        }
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String reCaptchaChallenge = request.getParameter(CAPTCHA_CHALLENGE_FIELD);
        String reCaptchaResponse = request.getParameter(CAPTCHA_RESPONSE_FIELD);
        String remoteAddress = request.getRemoteAddr();
        HttpSession session = request.getSession();

        return super.attemptAuthentication(request, response);
    }


    private void reCaptchaError(HttpServletRequest request, HttpServletResponse response, String errorMsg){
        log.error("ReCaptcha failed : " + errorMsg);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/signin?param.error=bad_captcha");
            request.setAttribute("captch","ok");
            dispatcher.forward(request, response);
        } catch (ServletException e){
            throw new AuthenticationServiceException("ReCaptcha failed : " + errorMsg);
        } catch (IOException e){
            throw new AuthenticationServiceException("Recaptcha failed : " + errorMsg);
        }
    }
}