package ioasys.com.br.enterprisesapi.repositories;

import ioasys.com.br.enterprisesapi.models.Enterprise;
import ioasys.com.br.enterprisesapi.models.EnterpriseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Enterprise save(Enterprise enterprise);
    Enterprise findEnterpriseById(Long id);
    List<Enterprise> findEnterpriseByEnterpriseNameAndEnterpriseTypesIsIn(String name, List<EnterpriseType> types);
}
