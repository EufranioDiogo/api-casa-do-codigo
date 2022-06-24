package ao.com.development.apidevelopmentcasacodigo.buy;

import ao.com.development.apidevelopmentcasacodigo.website.keeppayment.Buy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaypalForm {
  @NotBlank
  private String transactionId;
  @NotNull
  private PayPalStatus paypalStatus;

  public PaypalPayment newPaypalPayment(Buy buy) {
    return new PaypalPayment(this.transactionId, this.paypalStatus, buy);
  }

  public String getTransactionId() {
    return transactionId;
  }

  public PayPalStatus getPaypalStatus() {
    return paypalStatus;
  }
}
