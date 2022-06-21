package ao.com.development.apidevelopmentcasacodigo.cupom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
    Optional<Cupom> findByPkCupom(Long cupomId);
}
