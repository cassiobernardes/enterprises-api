package ioasys.com.br.enterprisesapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("email_enterprise")
    @Column(name = "email_enterprise")
    private String emailEnterprise;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "phone")
    private String phone;

    @JsonProperty("own_enterprise")
    @Column(name = "own_enterprise")
    private Boolean ownEnterprise;

    @JsonProperty("enterprise_name")
    @Column(name = "enterprise_name")
    private String enterpriseName;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "value")
    private Double value;

    @Column(name = "shares")
    private Double shares;

    @JsonProperty("share_price")
    @Column(name = "share_price")
    private Double sharePrice;

    @JsonProperty("own_shares")
    @Column(name = "own_shares")
    private Double ownShares;

    @JsonProperty("enterprise_type")
    @ManyToMany(mappedBy = "enterpriseSet", targetEntity = EnterpriseType.class, fetch = FetchType.LAZY)
    private Set<EnterpriseType> enterpriseTypes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id")
    private Portfolio portfolio;

    public Enterprise() {
        this.enterpriseTypes = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", email_enterprise='" + emailEnterprise + '\'' +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", phone='" + phone + '\'' +
                ", own_enterprise=" + ownEnterprise +
                ", enterprise_name='" + enterpriseName + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", value=" + value +
                ", share_price=" + sharePrice +
                ", enterpriseTypeSet=" + enterpriseTypes +
                ", portfolio=" + portfolio +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailEnterprise() {
        return emailEnterprise;
    }

    public void setEmailEnterprise(String email_enterprise) {
        this.emailEnterprise = email_enterprise;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getOwnEnterprise() {
        return ownEnterprise;
    }

    public void setOwnEnterprise(Boolean own_enterprise) {
        this.ownEnterprise = own_enterprise;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterprise_name) {
        this.enterpriseName = enterprise_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double share_price) {
        this.sharePrice = share_price;
    }

    public Set<EnterpriseType> getEnterpriseTypes() {
        return enterpriseTypes;
    }

    public void setEnterpriseTypes(Set<EnterpriseType> enterpriseTypeSet) {
        this.enterpriseTypes = enterpriseTypeSet;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Double getOwnShares() {
        return ownShares;
    }

    public void setOwnShares(Double ownShares) {
        this.ownShares = ownShares;
    }
}
