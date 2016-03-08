package com.jekss.entityes;

import javax.persistence.*;

/**
 * Created by jekss on 10.10.15.
 */
@Entity
public class AdressCompany {
    private int id;
    private String street;
    private int numberHouse;
    private int numberRoom;

    private City city;
    private Company company;

    public AdressCompany() {
    }

    public AdressCompany(String street, int numberHouse, int numberRoom, City city, Company company) {
        this.street = street;
        this.numberHouse = numberHouse;
        this.numberRoom = numberRoom;
        this.city = city;
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

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "numberHouse")
    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    @Column(name = "numberRoom")
    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "company_id", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "city_id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdressCompany{");
        sb.append(", street='").append(street).append('\'');
        sb.append(", numberHouse=").append(numberHouse);
        sb.append(", numberRoom=").append(numberRoom);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdressCompany that = (AdressCompany) o;

        if (id != that.id) return false;
        if (numberHouse != that.numberHouse) return false;
        if (numberRoom != that.numberRoom) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + numberHouse;
        result = 31 * result + numberRoom;

        return result;
    }
}
