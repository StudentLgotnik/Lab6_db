package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TIMEZONE", schema = "SYSTEM")
public class TimezoneEntity implements Serializable {
    private String timezone;
    private String goverment;
    private Set<CountriesEntity> countriesEntities = new HashSet<>();
    public static List<TimezoneEntity> timezones = new ArrayList<TimezoneEntity>();



    public TimezoneEntity() {
    }

    public TimezoneEntity(String timezone, String goverment) {
        this.timezone = timezone;
        this.goverment = goverment;
        if(!timezones.contains(this)) timezones.add(this);
    }

    @Id
    @Column(name = "TIMEZONE", nullable = false, length = 30)
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Basic
    @Column(name = "GOVERMENT", nullable = false, length = 30)
    public String getGoverment() {
        return goverment;
    }

    public void setGoverment(String goverment) {
        this.goverment = goverment;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = CountriesEntity.class, cascade = CascadeType.ALL, mappedBy = "timezoneEntity")

    public Set<CountriesEntity> getCountriesEntities() {
        return countriesEntities;
    }

    public void setCountriesEntities(Set<CountriesEntity> countriesEntities) {
        this.countriesEntities = countriesEntities;
    }
    /*@ManyToMany(mappedBy = "timezoneEntities")
    private Set<CountriesEntity> countriesEntities = new HashSet<>();

    public Set<CountriesEntity> getCountriesEntities() {
        return countriesEntities;
    }

    public void setCountriesEntities(Set<CountriesEntity> countriesEntities) {
        this.countriesEntities = countriesEntities;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimezoneEntity that = (TimezoneEntity) o;

        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
        if (goverment != null ? !goverment.equals(that.goverment) : that.goverment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timezone != null ? timezone.hashCode() : 0;
        result = 31 * result + (goverment != null ? goverment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimezoneEntity{" +
                "timezone='" + timezone + '\'' +
                ", goverment='" + goverment + '\'' +
                '}';
    }
}
