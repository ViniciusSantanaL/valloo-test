package br.com.valloo.cards.domain.card.vo.builder;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.vo.CardVO;

public class CardBuilder {

    CardBuilder() { throw new UnsupportedOperationException("constructor cannot bel call");}

    public static Card create(CardVO cardVO) {
        Card card = new Card();
        card.setCardNumber(cardVO.getCardNumber());
        card.setCardSecurityCode(cardVO.getCardSecurityCode());
        card.setCardExpirationDate(cardVO.getCardExpirationDate());
        card.setUserName(cardVO.getUserName());

        return card;
    }
    public static CardVO of(Card card) {
        return new CardVO(card);
    }
}
