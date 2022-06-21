package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import ao.com.development.apidevelopmentcasacodigo.website.cart.BuyItem;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_buy", nullable = false)
    private Long id;

    private String email;
    private String document;
    private String address;
    @ElementCollection
    private Set<BuyItem> buyItens = new HashSet<>();
    private LocalDateTime relizedDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buy(@NotBlank @Email String email, @NotBlank String document, @NotBlank String address, @Size(min = 1) Set<BuyItem> buyItems) {
        this.email = email;
        this.document = document;
        this.address = address;
        this.buyItens.addAll(buyItems);
    }

    @Override
    public String toString() {
        return "Buy{" +
                "email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", buyItens=" + buyItens +
                ", relizedDate=" + relizedDate +
                '}';
    }
}
