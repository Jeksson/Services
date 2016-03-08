package com.jekss.entityes;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jekss on 10.10.15.
 */
@Entity
public class Sales {
    private int id;
    private String salesName;

    private Set<Company> companySet;

    public Sales() {
    }

    public Sales(String salesName) {
        this.salesName = salesName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "salesName")
    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sales")
    public Set<Company> getCompanySet() {
        return companySet;
    }

    public void setCompanySet(Set<Company> companySet) {
        this.companySet = companySet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sales{");
        sb.append(", salesName='").append(salesName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sales sales = (Sales) o;

        if (id != sales.id) return false;
        if (companySet != null ? !companySet.equals(sales.companySet) : sales.companySet != null) return false;
        if (salesName != null ? !salesName.equals(sales.salesName) : sales.salesName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (salesName != null ? salesName.hashCode() : 0);
        result = 31 * result + (companySet != null ? companySet.hashCode() : 0);
        return result;
    }
}
