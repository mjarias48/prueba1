package ec.edu.espe.banquitoactivos.repository;

import ec.edu.espe.banquitoactivos.model.GeoLocation;
import ec.edu.espe.banquitoactivos.model.GeoStructure;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoLocationRepository extends JpaRepository<GeoLocation, Integer> {


    List <GeoLocation> findByIdAndCountryId (Integer id, String countryId);
    List <GeoLocation> findByCountryIdAndNameOrderByCountryId(String countryId, String name);
    List <GeoLocation> findByIdAndNameOrderById(Integer id, String name);
    List<GeoStructure> findGeoLocationByCountryIdAndAndLevelCode(String id, Integer levelCode);
}
