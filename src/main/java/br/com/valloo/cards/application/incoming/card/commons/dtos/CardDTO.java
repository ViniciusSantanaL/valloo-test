package br.com.valloo.cards.application.incoming.card.commons.dtos;

import br.com.valloo.cards.application.incoming.card.commons.deserializations.CustomLocalDateDeserializer;
import br.com.valloo.cards.application.incoming.card.commons.serializations.CustomLocalDateSerializer;
import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.vo.CardVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CardDTO(
        UUID id,
        @NotBlank
        String cardNumber,
        @NotBlank
        @Size(min = 3, max = 3)
        String cardSecurityCode,
        @JsonDeserialize(using = CustomLocalDateDeserializer.class)
        @JsonSerialize(using = CustomLocalDateSerializer.class)
        LocalDate cardExpirationDate,
        @NotBlank
        String userName) {

    public CardDTO(CardVO cardVO) {
        this(cardVO.getId(),cardVO.getCardNumber(), cardVO.getCardSecurityCode(),
                cardVO.getCardExpirationDate(), cardVO.getUserName());
    }

    public CardDTO(Card card) {
        this(card.getId(), card.getCardNumber(), card.getCardSecurityCode(),
                card.getCardExpirationDate(),card.getUserName());
    }
}
