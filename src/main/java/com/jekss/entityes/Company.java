package com.jekss.entityes;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jekss on 05.10.15.
 */
@Entity
public class Company {

    private int id;
    private String nameCompany;
    private int tellCompany;
    private String mailCompany;

    private User user;
    private Set<AdressCompany> adressCompanySet;
    private Sales sales;
    private Set<Services> servicesSet;

    public Company() {
    }

    public Company(String nameCompany, int tellCompany, String mailCompany, User user, Sales sales) {
        this.nameCompany = nameCompany;
        this.tellCompany = tellCompany;
        this.mailCompany = mailCompany;
        this.user = user;
        this.sales = sales;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "nameCompany")
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Column(name = "tellCompany")
    public int getTellCompany() {
        return tellCompany;
    }

    public void setTellCompany(int tellCompany) {
        this.tellCompany = tellCompany;
    }

    @Column(name = "mailCompany")
    public String getMailCompany() {
        return mailCompany;
    }

    public void setMailCompany(String mailCompany) {
        this.mailCompany = mailCompany;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    public Set<AdressCompany> getAdressCompanySet() {
        return adressCompanySet;
    }

    public void setAdressCompanySet(Set<AdressCompany> adressCompanySet) {
        this.adressCompanySet = adressCompanySet;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "sales_id", nullable = false)
    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    public Set<Services> getServicesSet() {
        return servicesSet;
    }

    public void setServicesSet(Set<Services> servicesSet) {
        this.servicesSet = servicesSet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append(", nameCompany='").append(nameCompany).append('\'');
        sb.append(", tellCompany=").append(tellCompany);
        sb.append(", mailCompany='").append(mailCompany).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (tellCompany != company.tellCompany) return false;
        if (mailCompany != null ? !mailCompany.equals(company.mailCompany) : company.mailCompany != null) return false;
        if (nameCompany != null ? !nameCompany.equals(company.nameCompany) : company.nameCompany != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCompany != null ? nameCompany.hashCode() : 0);
        result = 31 * result + tellCompany;
        result = 31 * result + (mailCompany != null ? mailCompany.hashCode() : 0);

        return result;
    }
}
