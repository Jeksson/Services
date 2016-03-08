package com.jekss.entityes;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jekss on 10.10.15.
 */
@Entity
public class City {
    private int id;
    private String cityName;
    private String region;
    private String territory;

    private Set <AdressCompany> adressCompanySet;

    public City() {
    }

    public City(String cityName, String region, String territory, Set<AdressCompany> adressCompanySet) {
        this.cityName = cityName;
        this.region = region;
        this.territory = territory;
        this.adressCompanySet = adressCompanySet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "city")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "territory")
    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    public Set<AdressCompany> getAdressCompanySet() {
        return adressCompanySet;
    }

    public void setAdressCompanySet(Set<AdressCompany> adressCompanySet) {
        this.adressCompanySet = adressCompanySet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", territory='").append(territory).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;
        if (region != null ? !region.equals(city.region) : city.region != null) return false;
        if (territory != null ? !territory.equals(city.territory) : city.territory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (territory != null ? territory.hashCode() : 0);
        return result;
    }
}

