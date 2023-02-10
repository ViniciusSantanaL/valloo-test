package br.com.valloo.cards.domain.card.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


@Entity(name = "card")
@EntityListeners(AuditingEntityListener.class)
public class Card implements Serializable {

    @Serial
    private static final long serialVersionUID = -5197359199527120832L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "card_security_code")
    private String cardSecurityCode;

    @Column(name = "card_expiration_date")
    private LocalDate cardExpirationDate;

    @Column(name = "user_name")
    private String userName;

    @Version
    private Long revision;

    public Card() {}

    public Card(String cardNumber, String cardSecurityCode, LocalDate cardExpirationDate, String userName) {
        this.cardNumber = cardNumber;
        this.cardSecurityCode = cardSecurityCode;
        this.cardExpirationDate = cardExpirationDate;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id.equals(card.id) && cardNumber.equals(card.cardNumber) && cardSecurityCode.equals(card.cardSecurityCode) && cardExpirationDate.equals(card.cardExpirationDate) && userName.equals(card.userName) && Objects.equals(revision, card.revision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardSecurityCode, cardExpirationDate, userName, revision);
    }

    public UUID getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public LocalDate getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(LocalDate cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRevision() {
        return revision;
    }
}
