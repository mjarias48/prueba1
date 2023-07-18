package ec.edu.espe.banquitoactivos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Version;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinColumn;

import java.util.Objects;

@Entity
@Table(name = "GEO_LOCATION")
public class GeoLocation {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCATION_ID", nullable = false)
    private Integer id;
    @Column(name = "COUNTRY_ID", length = 3, nullable = false)
    private String countryId;
    @Column(name = "LEVEL_CODE", nullable = false)
    private Integer levelCode;
    @Column(name = "LOCATION_ID_PARENT")
    private Integer locationIdParent;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Column(name = "AREA_PHONE_CODE", length = 3)
    private String phoneCode;
    @Column(name = "ZIP_CODE", length = 10)
    private String zipCode;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = false, updatable = false),
        @JoinColumn(name = "LEVEL_CODE", referencedColumnName = "LEVEL_CODE", insertable = false, updatable = false)
    })
    private GeoStructure geoStructure;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID_PARENT", referencedColumnName = "LOCATION_ID", insertable = false, updatable = false)
    private GeoLocation geoLocation;

    public GeoLocation() {
    }

    public GeoLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getLocationIdParent() {
        return locationIdParent;
    }

    public void setLocationIdParent(Integer locationIdParent) {
        this.locationIdParent = locationIdParent;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public GeoStructure getGeoStructure() {
        return geoStructure;
    }

    public void setGeoStructure(GeoStructure geoStructure) {
        this.geoStructure = geoStructure;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoLocation that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "id=" + id +
                ", countryId='" + countryId + '\'' +
                ", levelCode=" + levelCode +
                ", locationIdParent=" + locationIdParent +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", version=" + version +
                ", geoStructure=" + geoStructure +
                ", geoLocation=" + geoLocation +
                '}';
    }
}
