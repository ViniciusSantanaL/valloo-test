package br.com.valloo.cards.domain.card.vo;

import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.domain.card.model.Card;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class CardVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1867606407612747269L;
    private UUID id;

    private String cardNumber;

    private String cardSecurityCode;

    private LocalDate cardExpirationDate;

    private String userName;


    public CardVO(CardDTO cardDTO) {
        this.cardNumber = cardDTO.cardNumber();
        this.cardExpirationDate = cardDTO.cardExpirationDate();
        this.cardSecurityCode = cardDTO.cardSecurityCode();
        this.userName = cardDTO.userName();
    }

    public CardVO(CardDTO cardDTO, UUID cardId) {
        this.id = cardId;
        this.cardNumber = cardDTO.cardNumber();
        this.cardExpirationDate = cardDTO.cardExpirationDate();
        this.cardSecurityCode = cardDTO.cardSecurityCode();
        this.userName = cardDTO.userName();
    }

    public CardVO(Card card) {
        this.id = card.getId();
        this.cardNumber = card.getCardNumber();
        this.cardExpirationDate = card.getCardExpirationDate();
        this.cardSecurityCode = card.getCardSecurityCode();
        this.userName = card.getUserName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
