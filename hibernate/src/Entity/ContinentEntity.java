package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CONTINENT", schema = "SYSTEM")
public class ContinentEntity implements Serializable {
    private String continent;
    private String climate;
    private Set<CountriesEntity> countriesEntities = new HashSet<>();
    public static List<ContinentEntity> continents = new ArrayList<ContinentEntity>();

    public ContinentEntity() {
    }

    public ContinentEntity(String continent, String climate) {
        this.continent = continent;
        this.climate = climate;
        if(!continents.contains(this))continents.add(this);
    }

    @Id
    @Column(name = "CONTINENT", nullable = false, length = 30)
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Basic
    @Column(name = "CLIMATE", nullable = true, length = 30)
    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }



    @OneToMany(fetch = FetchType.EAGER, targetEntity = CountriesEntity.class, cascade = CascadeType.ALL, mappedBy = "continentEntity")
    public Set<CountriesEntity> getCountriesEntities() {
        return countriesEntities;
    }

    public void setCountriesEntities(Set<CountriesEntity> countriesEntities) {
        this.countriesEntities = countriesEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentEntity that = (ContinentEntity) o;

        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;
        if (climate != null ? !climate.equals(that.climate) : that.climate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continent != null ? continent.hashCode() : 0;
        result = 31 * result + (climate != null ? climate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContinentEntity{" +
                "continent='" + continent + '\'' +
                ", climate='" + climate + '\'' +
                '}';
    }
}
