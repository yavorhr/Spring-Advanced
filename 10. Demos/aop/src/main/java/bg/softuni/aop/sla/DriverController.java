package bg.softuni.aop.sla;

import java.util.List;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

  @TrackLatency(latency = "local_operation")
  @GetMapping("/drivers")
  public ResponseEntity<List<Driver>> allDrivers() {
    return ResponseEntity.ok(List.of(
        new Driver().setName("Pesho").setLicenceCategory("C"),
        new Driver().setName("Lucho").setLicenceCategory("A")
    ));
  }

  @TrackLatency(latency = "remote_operation")
  @GetMapping("/sync-drivers")
  public ResponseEntity<List<Driver>> remoteDrivers() {

    try {
      Thread.sleep(new Random().nextInt(2000));
    } catch (InterruptedException e) {
      Thread.interrupted();
    }

    return ResponseEntity.ok(List.of(
        new Driver().setName("Pesho").setLicenceCategory("C"),
        new Driver().setName("Lucho").setLicenceCategory("A")
    ));
  }

}
