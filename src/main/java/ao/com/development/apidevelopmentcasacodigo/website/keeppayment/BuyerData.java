package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import ao.com.development.apidevelopmentcasacodigo.website.cart.BuyItem;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class BuyerData {
    @NotBlank
    @Email
    private String email;
    private String firstName;
    private String lastName;
    @NotBlank
    @CpfCnpj
    private String document;
    @NotBlank
    private String address;

    public BuyerData() {
    }

    public BuyerData(String email, String firstName, String lastName, String document, String address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Buy newBuy(Set<BuyItem> buyItems) {
        return new Buy(this.email, this.document, this.address, buyItems);
    }
}
