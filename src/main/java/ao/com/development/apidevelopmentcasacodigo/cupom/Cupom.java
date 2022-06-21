package ao.com.development.apidevelopmentcasacodigo.cupom;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_cupom", nullable = false)
    private Long pkCupom;
    @NotBlank
    private String code;
    @FutureOrPresent
    private LocalDateTime expiresAt;
    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();
    @Min(5) @Max(90)
    private BigDecimal discountPercentage;

    public Cupom() {
    }

    public Cupom(@NotBlank  String code, @PastOrPresent LocalDateTime expiresAt, @Size(min = 0, max = 90) BigDecimal discountPercentage) {
        this.code = code;
        this.expiresAt = expiresAt;
        this.discountPercentage = discountPercentage;
    }

    public Long getPkCupom() {
        return pkCupom;
    }

    public void setPkCupom(Long id) {
        this.pkCupom = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expirationDate) {
        this.expiresAt = expirationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdDate) {
        this.createdAt = createdDate;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + pkCupom +
                ", code='" + code + '\'' +
                ", expiresAt=" + expiresAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
