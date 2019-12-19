package ioasys.com.br.enterprisesapi.repositories;

import ioasys.com.br.enterprisesapi.models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    Investor findInvestorByEmail(String email);
}
