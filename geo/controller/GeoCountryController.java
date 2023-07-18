package ec.edu.espe.banquitoactivos.controller;

import ec.edu.espe.banquitoactivos.model.GeoCountry;
import ec.edu.espe.banquitoactivos.service.GeoCountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geo-country")
public class GeoCountryController {
    private final GeoCountryService geoCountryService;

    public GeoCountryController(GeoCountryService geoCountryService) {
        this.geoCountryService = geoCountryService;
    }

    @GetMapping
    public ResponseEntity<List<GeoCountry>> listCountries() {
        List<GeoCountry> geoCountries = this.geoCountryService.listAllCountries();
        return ResponseEntity.ok(geoCountries);
    }

    @PostMapping
    public ResponseEntity<GeoCountry> create(@RequestBody GeoCountry geoCountry) {
        try {
            GeoCountry geoCountryRS = this.geoCountryService.create(geoCountry);
            return ResponseEntity.ok(geoCountryRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<GeoCountry> update(@RequestBody GeoCountry geoCountry) {
        try {
            GeoCountry geoCountryRS = this.geoCountryService.update(geoCountry);
            return ResponseEntity.ok(geoCountryRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        try {
            this.geoCountryService.delete(id);
        } catch (RuntimeException rte) {
            throw new RuntimeException("País no puede ser eliminado: " + id, rte);
        }
    }

}
