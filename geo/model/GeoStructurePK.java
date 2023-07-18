
package ec.edu.espe.banquitoactivos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GeoStructurePK implements Serializable {

    @Column(name = "COUNTRY_ID", length = 2, nullable = false)
    private String countryId;

    @Column(name = "LEVEL_CODE", nullable = false, columnDefinition = "NUMERIC(1)")
    private Integer levelCode;

    public GeoStructurePK() {
    }

    public GeoStructurePK(String countryId, Integer levelCode) {
        this.countryId = countryId;
        this.levelCode = levelCode;
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

    @Override
    public String toString() {
        return "GeoStructurePK{" + "countryId='" + countryId + '\'' + ", levelCode=" + levelCode + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GeoStructurePK that))
            return false;
        return Objects.equals(countryId, that.countryId) && Objects.equals(levelCode, that.levelCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, levelCode);
    }

}
