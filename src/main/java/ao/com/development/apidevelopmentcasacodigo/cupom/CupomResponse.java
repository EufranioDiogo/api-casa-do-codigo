package ao.com.development.apidevelopmentcasacodigo.cupom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CupomResponse {
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime expireAt;
    private BigDecimal discountPercentage;

    public CupomResponse() {
    }
    public CupomResponse(Cupom cupom) {
        this.code = cupom.getCode();
        this.createdAt = cupom.getCreatedAt();
        this.expireAt = cupom.getExpiresAt();
        this.discountPercentage = cupom.getDiscountPercentage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public boolean isValid() {
        return !LocalDateTime.now().isAfter(expireAt);
    }
}
