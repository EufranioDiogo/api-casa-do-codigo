package ao.com.development.apidevelopmentcasacodigo.cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CupomForm {
    private String code;
    private LocalDateTime expireAt;
    private BigDecimal discountPercentage;

    public CupomForm() {
    }

    public CupomForm(String code, LocalDateTime expireAt, BigDecimal discountPercentage) {
        this.code = code;
        this.expireAt = expireAt;
        this.discountPercentage = discountPercentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Cupom build() {
        return new Cupom(code, expireAt, discountPercentage);
    }
}
