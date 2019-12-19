package ioasys.com.br.enterprisesapi.models;

import com.fasterxml.jackson.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "investor")
public class Investor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "investor_name")
    private String investor_name;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "photo")
    private Double photo;

    @Column(name = "portfolio_value")
    private Double portfolio_value;

    @Column(name = "first_access")
    private Boolean first_access;

    @Column(name = "super_angel")
    private Boolean super_angel;

    @JsonProperty("portfolio")
    @OneToMany(mappedBy = "investor", fetch = FetchType.LAZY)
    private Set<Portfolio> portfolioSet;

    public Investor() {
        this.portfolioSet = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvestor_name() {
        return investor_name;
    }

    public void setInvestor_name(String investor_name) {
        this.investor_name = investor_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPhoto() {
        return photo;
    }

    public void setPhoto(Double photo) {
        this.photo = photo;
    }

    public Double getPortfolio_value() {
        return portfolio_value;
    }

    public void setPortfolio_value(Double portfolio_value) {
        this.portfolio_value = portfolio_value;
    }

    public Boolean getFirst_access() {
        return first_access;
    }

    public void setFirst_access(Boolean first_access) {
        this.first_access = first_access;
    }

    public Boolean getSuper_angel() {
        return super_angel;
    }

    public void setSuper_angel(Boolean super_angel) {
        this.super_angel = super_angel;
    }

    public Set<Portfolio> getPortfolioSet() {
        return portfolioSet;
    }

    public void setPortfolioSet(Set<Portfolio> portfolioSet) {
        this.portfolioSet = portfolioSet;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
