package br.com.valloo.cards.application.incoming.card.commons.converter;

import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.vo.CardVO;

import java.util.UUID;

public class CardConverter {

    CardConverter() {throw new UnsupportedOperationException("constructor cannot be call");}
    public static CardVO of(CardDTO cardDTO) {
        return new CardVO(cardDTO);
    }

    public static CardVO of(CardDTO cardDTO, UUID cardId) {
        return new CardVO(cardDTO, cardId);
    }

    public static CardDTO toResponse(CardVO cardVO) {
        return new CardDTO(cardVO);
    }

    public static CardDTO toResponse(Card card) {
        return new CardDTO(card);
    }

}
