package ec.edu.espe.banquitoactivos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.banquitoactivos.repository.GeoCountryRepository;
import jakarta.transaction.Transactional;
import ec.edu.espe.banquitoactivos.model.GeoCountry;

@Service
public class GeoCountryService {

    private final GeoCountryRepository geoCountryRepository;

    public GeoCountryService(GeoCountryRepository geoCountryRepository) {
        this.geoCountryRepository = geoCountryRepository;
    }

    public List<GeoCountry> listAllCountries() {
        return this.geoCountryRepository.findAll();
    }

    @Transactional
    public GeoCountry create(GeoCountry geoCountry) {

        Optional<GeoCountry> geoCountryOpt = geoCountryRepository.findById(geoCountry.getId());
        if (geoCountryOpt.isPresent()) {
            throw new RuntimeException("Pais ya existe.");
        } else {
            return this.geoCountryRepository.save(geoCountry);
        }

    }

    @Transactional
    public GeoCountry update(GeoCountry geoCountry) {
        Optional<GeoCountry> geoCountryOpt = geoCountryRepository.findById(geoCountry.getId());
        if (geoCountryOpt.isPresent()) {
            GeoCountry geocountryTmp = geoCountryOpt.get();
            geocountryTmp.setId(geoCountry.getId());
            geocountryTmp.setPhoneCode(geoCountry.getPhoneCode());
            geocountryTmp.setName(geoCountry.getName());
            return this.geoCountryRepository.save(geocountryTmp);
        } else {
            throw new RuntimeException("Pais no existente.");
        }
    }

    @Transactional
    public void delete(String geoCountryId) {

        try {
             Optional<GeoCountry> geoCountryOpt = geoCountryRepository.findById(geoCountryId);
        if (geoCountryOpt.isPresent()) {
            this.geoCountryRepository.delete(geoCountryOpt.get());
        } else {
            throw new RuntimeException("País no existente: "+geoCountryId);
        }
        } catch (RuntimeException rte) {
          throw new RuntimeException("País no puede ser eliminado: "+geoCountryId,rte);
        }
       
    }

}
