package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAPITAL", schema = "SYSTEM", catalog = "")
public class CapitalEntity implements Serializable{
    private String capital;
    private String governor;
    private Long population;
    private CountriesEntity countriesEntity;
    public static List<CapitalEntity> capitals = new ArrayList<>();

    public CapitalEntity() {
    }

    public CapitalEntity( String capital, String governor, Long population) {
        this.governor = governor;
        this.capital = capital;
        this.population = population;
        if(!capitals.contains(this)) capitals.add(this);
    }

    @Id
    @Column(name = "CAPITAL", nullable = false, length = 30)
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "GOVERNOR", nullable = true, length = 30)
    public String getGovernor() {
        return governor;
    }

    public void setGovernor(String governor) {
        this.governor = governor;
    }

    @Basic
    @Column(name = "POPULATION", nullable = true, precision = 0)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "country", columnDefinition = "varchar2(30)"),
            @JoinColumn(name = "mainland", columnDefinition = "varchar2(30)"),
            @JoinColumn(name = "councapital", columnDefinition = "varchar2(30)"),
            @JoinColumn(name = "timezone", columnDefinition = "varchar2(30)"),
    })
    public CountriesEntity getCountriesEntity() {
        return countriesEntity;
    }

    public void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CapitalEntity that = (CapitalEntity) o;

        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (governor != null ? !governor.equals(that.governor) : that.governor != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = capital != null ? capital.hashCode() : 0;
        result = 31 * result + (governor != null ? governor.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CapitalEntity{" +
                "capital='" + capital + '\'' +
                ", governor='" + governor + '\'' +
                ", population=" + population +
                ", countriesEntity=" + countriesEntity +
                '}';
    }
}
