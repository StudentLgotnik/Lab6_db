package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES", schema = "SYSTEM")
public class CountriesEntity implements Serializable {
    private String country;
    private String mainland;
    private Long population;
    private String councapital;
    private String timezone;
    private TimezoneEntity timezoneEntity;
    private Set<CapitalEntity> capitalEntities = new HashSet<>();
    private Set<CountriesemployerEntity> countriesemployerEntities = new HashSet<>();
    private ContinentEntity continentEntity;
    public static List<CountriesEntity> countries = new ArrayList<CountriesEntity>();




    public CountriesEntity() {
    }

    public CountriesEntity(String country, String mainland, Long population, String councapital, String timezone) {
        this.country = country;
        this.mainland = mainland;
        this.population = population;
        this.councapital = councapital;
        this.timezone = timezone;
        if(!countries.contains(this)) countries.add(this);
    }

    @Id
    @Column(name = "COUNTRY", nullable = true, length = 30)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Id
    @Column(name = "MAINLAND", nullable = true, length = 30)
    public String getMainland() {
        return mainland;
    }

    public void setMainland(String mainland) {
        this.mainland = mainland;
    }

    @Basic
    @Column(name = "POPULATION", nullable = true, precision = 0)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Id
    @Column(name = "CAPITAL", nullable = true, length = 30)
    public String getCapital() {
        return councapital;
    }

    public void setCapital(String capital) {
        this.councapital = capital;
    }

    @Id
    @Column(name = "COUNTIMEZONE", nullable = true, length = 30)
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = CapitalEntity.class, cascade = CascadeType.ALL, mappedBy = "countriesEntity")
    public Set<CapitalEntity> getCapitalEntities() {
        return capitalEntities;
    }

    public void setCapitalEntities(Set<CapitalEntity> capitalEntities) {
        this.capitalEntities = capitalEntities;
    }



    @OneToMany(fetch = FetchType.EAGER, targetEntity = CountriesemployerEntity.class, cascade = CascadeType.ALL, mappedBy = "countriesEntity")
    public Set<CountriesemployerEntity> getCountriesemployerEntities() {
        return countriesemployerEntities;
    }

    public void setCountriesemployerEntities(Set<CountriesemployerEntity> countriesemployerEntities) {
        this.countriesemployerEntities = countriesemployerEntities;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "continent", columnDefinition = "varchar2(30)")
    public ContinentEntity getContinentEntity() {
        return continentEntity;
    }

    public void setContinentEntity(ContinentEntity continentEntity) {
        this.continentEntity = continentEntity;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timezone", columnDefinition = "varchar2(30)")
    public TimezoneEntity getTimezoneEntity() {
        return timezoneEntity;
    }

    public void setTimezoneEntity(TimezoneEntity timezoneEntity) {
        this.timezoneEntity = timezoneEntity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (mainland != null ? !mainland.equals(that.mainland) : that.mainland != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        if (councapital != null ? !councapital.equals(that.councapital) : that.councapital != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (mainland != null ? mainland.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (councapital != null ? councapital.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountriesEntity{" +
                "country='" + country + '\'' +
                ", mainland='" + mainland + '\'' +
                ", population=" + population +
                ", capital='" + councapital + '\'' +
                ", counttimezone='" + timezone + '\'' +
                ", capitalEntity=" + timezone +
                '}';
    }
}
