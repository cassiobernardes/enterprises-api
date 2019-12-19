package ioasys.com.br.enterprisesapi.controllers;

import ioasys.com.br.enterprisesapi.models.Enterprise;
import ioasys.com.br.enterprisesapi.models.EnterpriseType;
import ioasys.com.br.enterprisesapi.repositories.EnterpriseRepository;
import ioasys.com.br.enterprisesapi.repositories.EnterpriseTypeRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@RestController
public class EnterpriseController {

    private final EnterpriseRepository enterpriseRepository;

    private final EnterpriseTypeRepository enterpriseTypeRepository;

    public EnterpriseController(EnterpriseRepository enterpriseRepository, EnterpriseTypeRepository enterpriseTypeRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseTypeRepository = enterpriseTypeRepository;
    }

    @ResponseBody
    @PostMapping("/enterprises")
    public Enterprise saveEnterprises(@Valid @RequestBody Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @ResponseBody
    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id,
                                        HttpServletResponse response,
                                        HttpServletRequest request) {

        response.addHeader("access-token", request.getHeader("access-token"));
        response.addHeader("uid", request.getHeader("uid"));

        return enterpriseRepository.findEnterpriseById(id);
    }

    @ResponseBody
    @GetMapping("/enterprises")
    public List<Enterprise> listEnterprisesByNameAndTypes(@RequestParam(required = false, value = "name") String name,
                                                          @RequestParam(required = false, value = "enterprise_types") String enterpriseTypesList,
                                                          HttpServletResponse response,
                                                          HttpServletRequest request) {

        List<Enterprise> enterpriseList = new ArrayList<>(enterpriseRepository.findAll());
        List<Enterprise> enterpriseListResult;
        List<EnterpriseType> enterpriseTypesSet = new ArrayList<>();

        if (enterpriseTypesList == null && name != null) {
            enterpriseListResult = new ArrayList<>();
            for (Enterprise enterprise : enterpriseList) {
                if (enterprise.getEnterpriseName().regionMatches(true, 0, name, 0, name.length())) {
                    enterpriseListResult.add(enterprise);
                }
            }
        } else if (enterpriseTypesList != null && name == null) {
            String[] typesIdList = enterpriseTypesList.split(",");
            enterpriseListResult = new ArrayList<>();

            for (String id : typesIdList) {
                enterpriseTypesSet.add(enterpriseTypeRepository.findEnterpriseTypeById(Long.valueOf(id)));
            }

            for (Enterprise enterprise : enterpriseList) {
                if (enterprise.getEnterpriseTypes().containsAll(enterpriseTypesSet)) {
                    enterpriseListResult.add(enterprise);
                }
            }
        } else if (enterpriseTypesList != null && name != null) {
            String[] typesIdList = enterpriseTypesList.split(",");
            enterpriseListResult = new ArrayList<>();

            for (String id : typesIdList) {
                enterpriseTypesSet.add(enterpriseTypeRepository.findEnterpriseTypeById(Long.valueOf(id)));
            }

            for (Enterprise enterprise : enterpriseList) {
                if (enterprise.getEnterpriseName().regionMatches(true, 0, name, 0, name.length()) &&
                        enterprise.getEnterpriseTypes().containsAll(enterpriseTypesSet)) {
                    enterpriseListResult.add(enterprise);
                }
            }
        } else {
            enterpriseListResult = new ArrayList<>(enterpriseRepository.findAll());
        }

        response.addHeader("access-token", request.getHeader("access-token"));
        response.addHeader("uid", request.getHeader("uid"));

        return enterpriseListResult;

    }
}
