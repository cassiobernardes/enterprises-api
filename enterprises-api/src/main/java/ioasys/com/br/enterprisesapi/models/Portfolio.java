package ioasys.com.br.enterprisesapi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "enterprises_number")
    private Integer enterprises_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", referencedColumnName = "id")
    private Investor investor;

    @OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY)
    private Set<Enterprise> enterpriseSet;

    public Portfolio() {
        this.enterpriseSet = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnterprises_number() {
        return enterprises_number;
    }

    public void setEnterprises_number(Integer enterprises_number) {
        this.enterprises_number = enterprises_number;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Set<Enterprise> getEnterpriseSet() {
        return enterpriseSet;
    }

    public void setEnterpriseSet(Set<Enterprise> enterpriseSet) {
        this.enterpriseSet = enterpriseSet;
    }
}
