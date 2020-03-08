package com.vincendp.RedditClone.Controller;

import com.vincendp.RedditClone.Dto.LoginRequest;
import com.vincendp.RedditClone.Dto.LoginResponse;
import com.vincendp.RedditClone.Model.MyUserDetails;
import com.vincendp.RedditClone.Utility.JWTUtility;
import com.vincendp.RedditClone.Utility.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller()
@RequestMapping("auth")
public class AuthenticationController {

    AuthenticationManager authenticationManager;
    JWTUtility jwtUtility;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JWTUtility jwtUtility){
        this.authenticationManager = authenticationManager;
        this.jwtUtility = jwtUtility;
    }


    @PostMapping(value = "/login")
    ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) throws Exception{


        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        }
        catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        String jws = jwtUtility.generateJWS(myUserDetails.getUsername());

        Cookie cookie = new Cookie("jws", jws);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(new SuccessResponse(200, "Success: Logged in", new LoginResponse(jws)));
    }
}
