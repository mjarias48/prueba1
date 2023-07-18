package ec.edu.espe.banquitoactivos.service;

import ec.edu.espe.banquitoactivos.model.GeoLocation;
import ec.edu.espe.banquitoactivos.model.GeoStructure;
import ec.edu.espe.banquitoactivos.repository.GeoLocationRepository;
import ec.edu.espe.banquitoactivos.repository.GeoStructureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoLocationService {
    private final GeoLocationRepository geoLocationRepository;
    private final GeoStructureRepository geoStructureRepository;

    public GeoLocationService(GeoLocationRepository geoLocationRepository, GeoStructureRepository geoStructureRepository) {
        this.geoLocationRepository = geoLocationRepository;
        this.geoStructureRepository = geoStructureRepository;
    }

    public List<GeoLocation> listGeoLocations() {
        return geoLocationRepository.findAll();
    }

    public GeoLocation createGeoLocation(GeoLocation geoLocation, GeoStructure geoStructure) {
        GeoStructure geoStructureTmp = this.geoStructureRepository.findGeoStructureByGeoCountry_IdAndLevelCode(geoStructure.getPk().getCountryId(), geoStructure.getPk().getLevelCode());
        if (geoStructureTmp == null) {
            geoLocation.setGeoStructure(geoStructureTmp);
            return this.geoLocationRepository.save(geoLocation);
        }else {
            throw new RuntimeException("No existe la estructura geográfica para el país: " + geoStructure.getPk().getCountryId() + " con nivel: " + geoStructure.getPk().getLevelCode());
        }

    }

}
