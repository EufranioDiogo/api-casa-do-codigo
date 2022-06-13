package ao.com.development.apidevelopmentcasacodigo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/api/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Ola mundo");
    }
}
