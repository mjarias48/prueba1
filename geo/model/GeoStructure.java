package ec.edu.espe.banquitoactivos.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.util.Objects;

@Entity
@Table(name = "GEO_STRUCTURE")
public class GeoStructure {
    @EmbeddedId
    private GeoStructurePK pk;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = false, updatable = false)
    private GeoCountry geoCountry;

    public GeoStructure() {
    }

    public GeoStructure(GeoStructurePK pk) {
        this.pk = pk;
    }

    public GeoStructurePK getPk() {
        return pk;
    }

    public void setPk(GeoStructurePK pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public GeoCountry getGeoCountry() {
        return geoCountry;
    }

    public void setGeoCountry(GeoCountry geoCountry) {
        this.geoCountry = geoCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GeoStructure that))
            return false;
        return Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk);
    }

    @Override
    public String toString() {
        return "GeoStructure{" +
                "pk=" + pk +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", geoCountry=" + geoCountry +
                '}';
    }

    

    
}
