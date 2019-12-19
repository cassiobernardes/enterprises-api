package ioasys.com.br.enterprisesapi.controllers;

import ioasys.com.br.enterprisesapi.models.Investor;
import ioasys.com.br.enterprisesapi.models.JwtRequest;
import ioasys.com.br.enterprisesapi.repositories.InvestorRepository;
import ioasys.com.br.enterprisesapi.security.JwtTokenUtil;
import ioasys.com.br.enterprisesapi.services.JwtUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final InvestorRepository investorRepository;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, InvestorRepository investorRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.investorRepository = investorRepository;
    }

    @PostMapping(value = "/users/auth/sign_in")
    public Investor createAuthenticationToken(@RequestBody JwtRequest authenticationRequest,
                                              HttpServletResponse response) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        response.addHeader("access-token", token);
        response.addHeader("uid", authenticationRequest.getEmail());
        return investorRepository.findInvestorByEmail(authenticationRequest.getEmail());
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
