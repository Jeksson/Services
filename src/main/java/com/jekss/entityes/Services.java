package com.jekss.entityes;

import javax.persistence.*;

/**
 * Created by jekss on 10.10.15.
 */
@Entity
public class Services {
    private int id;
    private String name;
    private String description;

    private Company company;

    public Services() {
    }

    public Services(String name, String description, Company company) {
        this.name = name;
        this.description = description;
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "company_id", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Services{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Services services = (Services) o;

        if (id != services.id) return false;

        if (description != null ? !description.equals(services.description) : services.description != null)
            return false;
        if (name != null ? !name.equals(services.name) : services.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);

        return result;
    }
}
