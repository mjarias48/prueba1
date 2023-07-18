package ec.edu.espe.banquitoactivos.controller.geo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.banquitoactivos.model.geo.GeoLocation;
import ec.edu.espe.banquitoactivos.service.geo.GeoLocationService;

@RequestMapping("/geo/locations")
public class GeoLocationController {
    private final GeoLocationService locationService;

    public GeoLocationController(GeoLocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<GeoLocation> getLocationById(@PathVariable("locationId") int locationId) {
        try {
            GeoLocation response = this.locationService.findLocationById(locationId);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/location")
    public ResponseEntity postLocation(@RequestBody() GeoLocation location) {
        try {
            this.locationService.createLocation(location);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/location/{locationId}")
    public ResponseEntity putLocation(
            @PathVariable("locationId") int locationId,
            @RequestBody() GeoLocation location) {
        try {
            this.locationService.updateLocation(locationId, location);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/location/{locationId}")
    public ResponseEntity deleteLocation(@PathVariable("locationId") int locationId) {
        try {
            this.locationService.deleteLocation(locationId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
