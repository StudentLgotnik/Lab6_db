package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COUNTRIESEMPLOYER", schema = "SYSTEM")
public class CountriesemployerEntity implements Serializable {
    private String countries;
    private String unemployed;
    private CountriesEntity countriesEntity;
    public static List<CountriesemployerEntity> countriesemployers = new ArrayList<CountriesemployerEntity>();

    public CountriesemployerEntity() {
    }

    public CountriesemployerEntity(String countries, String unemployed) {
        this.countries = countries;
        this.unemployed = unemployed;
        if(!countriesemployers.contains(this)) countriesemployers.add(this);
    }

    @Id
    @Column(name = "COUNTRIES", nullable = false, length = 30)
    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    @Basic
    @Column(name = "UNEMPLOYED", nullable = true, length = 30)
    public String getUnemployed() {
        return unemployed;
    }

    public void setUnemployed(String unemployed) {
        this.unemployed = unemployed;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "country", columnDefinition = "varchar2(30)"),
            @JoinColumn(name = "mainland", columnDefinition = "varchar2(30)"),
            @JoinColumn(name = "capital", columnDefinition = "varchar2(30)"),
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

        CountriesemployerEntity that = (CountriesemployerEntity) o;

        if (countries != null ? !countries.equals(that.countries) : that.countries != null) return false;
        if (unemployed != null ? !unemployed.equals(that.unemployed) : that.unemployed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countries != null ? countries.hashCode() : 0;
        result = 31 * result + (unemployed != null ? unemployed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountriesemployerEntity{" +
                "countries='" + countries + '\'' +
                ", unemployed='" + unemployed + '\'' +
                '}';
    }
}
