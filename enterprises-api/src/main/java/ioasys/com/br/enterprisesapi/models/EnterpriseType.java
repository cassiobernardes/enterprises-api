package ioasys.com.br.enterprisesapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "enterprise_type")
public class EnterpriseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "enterprise_type_name")
    private String enterprise_type_name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enterprise_has_enterprise_type", joinColumns = {@JoinColumn(name = "enterprise_type_id")}, inverseJoinColumns = {@JoinColumn(name = "enterprise_id")})
    private Set<Enterprise> enterpriseSet;

    public EnterpriseType() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterpriseType that = (EnterpriseType) o;
        return id.equals(that.id) &&
                enterprise_type_name.equals(that.enterprise_type_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enterprise_type_name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterprise_type_name() {
        return enterprise_type_name;
    }

    public void setEnterprise_type_name(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }

    public Set<Enterprise> getEnterpriseSet() {
        return enterpriseSet;
    }

    public void setEnterpriseSet(Set<Enterprise> enterpriseSet) {
        this.enterpriseSet = enterpriseSet;
    }
}
