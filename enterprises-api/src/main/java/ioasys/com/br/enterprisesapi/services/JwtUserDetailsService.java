package ioasys.com.br.enterprisesapi.services;

import ioasys.com.br.enterprisesapi.models.Investor;
import ioasys.com.br.enterprisesapi.repositories.InvestorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final InvestorRepository investorRepository;

    public JwtUserDetailsService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Investor investor = investorRepository.findInvestorByEmail(email);
        if (investor == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(investor.getUsername(), investor.getPassword(),
                new ArrayList<>());
    }

}
