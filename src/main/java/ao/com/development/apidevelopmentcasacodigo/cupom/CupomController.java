package ao.com.development.apidevelopmentcasacodigo.cupom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CupomController {
    private final CupomRepository cupomRepository;

    public CupomController(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @PostMapping("/api/v1/cupom")
    @Transactional
    public CupomResponse createCupom(@Valid  @RequestBody CupomForm cupomForm) {
        Cupom cupom = cupomForm.build();

        System.out.println(cupom);
        cupomRepository.save(cupom);

        return new CupomResponse(cupom);
    }

    @GetMapping("/api/v1/cupom/{id}")
    @Transactional
    public CupomResponse getCupom(@PathVariable(name = "id") Long cupomId) {
        Optional<Cupom> cupom = cupomRepository.findByPkCupom(cupomId);

        cupom.orElseThrow();

        return new CupomResponse(cupom.get());
    }
}
