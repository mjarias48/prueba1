package ec.edu.espe.banquitoactivos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Version;

import java.util.Objects;

@Entity
@Table(name = "GEO_COUNTRY")
public class GeoCountry {
    @Id
    @Column(name = "COUNTRY_ID", nullable = false)
    private String id;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Column(name = "PHONE_CODE", length = 4, nullable = false)
    private String phoneCode;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    public GeoCountry() {}

    public GeoCountry(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoCountry that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GeoCountry{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", version=" + version +
                '}';
    }
}
