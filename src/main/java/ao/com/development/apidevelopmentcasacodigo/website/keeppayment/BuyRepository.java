package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

    @Override
    Optional<Buy> findById(Long aLong);

}
