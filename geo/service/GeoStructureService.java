package ec.edu.espe.banquitoactivos.service;

import ec.edu.espe.banquitoactivos.model.GeoStructure;
import ec.edu.espe.banquitoactivos.repository.GeoStructureRepository;
import ec.edu.espe.banquitoactivos.repository.GeoCountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoStructureService {
    private final GeoStructureRepository geoStructureRepository;
    private final GeoCountryRepository geoCountryRepository;

    public GeoStructureService(GeoStructureRepository geoStructureRepository, GeoCountryRepository geoCountryRepository) {
        this.geoStructureRepository = geoStructureRepository;
        this.geoCountryRepository = geoCountryRepository;
    }

    public List<GeoStructure> listGeoStructures() {
        return geoStructureRepository.findAll();
    }

}
