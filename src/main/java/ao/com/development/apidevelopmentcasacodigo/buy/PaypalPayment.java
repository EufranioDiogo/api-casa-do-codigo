package ao.com.development.apidevelopmentcasacodigo.buy;

import ao.com.development.apidevelopmentcasacodigo.website.keeppayment.Buy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class PaypalPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String transactionId;
    @NotNull
    private PayPalStatus paypalStatus;
    @NotNull
    @OneToOne
    private Buy buy;

    public PaypalPayment() {
    }

    public PaypalPayment(@NotBlank String transactionId, @NotNull  PayPalStatus paypalStatus, @NotNull Buy buy) {
        this.transactionId = transactionId;
        this.paypalStatus = paypalStatus;
        this.buy = buy;
    }

    public boolean isValid() {
        return this.paypalStatus.equals(PayPalStatus.SUCCESS);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PayPalStatus getPaypalStatus() {
        return paypalStatus;
    }

    public void setPaypalStatus(PayPalStatus paypalStatus) {
        this.paypalStatus = paypalStatus;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }
}
