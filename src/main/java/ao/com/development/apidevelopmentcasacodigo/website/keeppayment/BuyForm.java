package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import ao.com.development.apidevelopmentcasacodigo.cupom.Cupom;
import ao.com.development.apidevelopmentcasacodigo.cupom.CupomRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class BuyForm {
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
    private String cupomCode;

    public BuyForm() {
    }

    public BuyForm(String email, String firstName, String lastName, String document, String address, String cupomCode) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.cupomCode = cupomCode;
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

    public String getCupomCode() {
        return cupomCode;
    }

    public void setCupomCode(String cupomCode) {
        this.cupomCode = cupomCode;
    }

    public BuyerData buildBuyerData() {
        return new BuyerData(email, firstName, lastName, document, address);
    }

    public Optional<Cupom> getCupom(CupomRepository cupomRepository) {
        if (cupomCode != null) {
            return cupomRepository.findByCode(cupomCode);
        }
        return Optional.empty();
    }
}
