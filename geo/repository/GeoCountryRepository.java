package ec.edu.espe.banquitoactivos.repository;

import ec.edu.espe.banquitoactivos.model.GeoCountry;
import ec.edu.espe.banquitoactivos.model.Holiday;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoCountryRepository extends JpaRepository<GeoCountry, String> {
    
    //List <Holiday>  findByIdAndCountryId (Integer id, String countryId);
    //List <GeoCountry> findByIdAndNameOrderById(Integer id, String name);

}