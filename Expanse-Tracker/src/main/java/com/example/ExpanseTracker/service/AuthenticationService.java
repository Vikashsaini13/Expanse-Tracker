package com.example.ExpanseTracker.service;


import com.example.ExpanseTracker.model.AuthenticationToken;
import com.example.ExpanseTracker.repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    @Autowired
    IAuthTokenRepo iAuthTokenRepo;
    public boolean authenticate(String email,String authTokenValue){

        AuthenticationToken authToken=iAuthTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken==null){
            return false;
        }

        String tokenConnectedEmail= authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

}
