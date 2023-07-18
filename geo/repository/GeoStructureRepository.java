package ec.edu.espe.banquitoactivos.repository;

import ec.edu.espe.banquitoactivos.model.GeoCountry;
import ec.edu.espe.banquitoactivos.model.GeoStructure;
import ec.edu.espe.banquitoactivos.model.GeoStructurePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeoStructureRepository extends JpaRepository<GeoStructure, GeoStructurePK> {
    List<GeoCountry> findGeoStructureByGeoCountry_Id(String id);

    GeoStructure findGeoStructureByGeoCountry_IdAndLevelCode(String id, Integer levelCode);

}
