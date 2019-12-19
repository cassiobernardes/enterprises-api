package ioasys.com.br.enterprisesapi.repositories;

import ioasys.com.br.enterprisesapi.models.EnterpriseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseTypeRepository extends JpaRepository<EnterpriseType, Long> {

    EnterpriseType findEnterpriseTypeById(Long id);

}
