package ao.com.development.apidevelopmentcasacodigo.buy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaypalPayment, Long> {
}
