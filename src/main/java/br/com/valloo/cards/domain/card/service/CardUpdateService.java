package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.repository.CardRepository;
import br.com.valloo.cards.domain.card.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateService {

    private final CardRepository repository;

    @Autowired
    public CardUpdateService(CardRepository repository) {
        this.repository = repository;
    }

    public void updateCard(final CardVO cardVO) {
        Card card = repository.findById(cardVO.getId()).orElseThrow(() -> new RuntimeException("teste"));

        card.setCardNumber(cardVO.getCardNumber());
        card.setCardSecurityCode(cardVO.getCardNumber());
        card.setCardExpirationDate(cardVO.getCardExpirationDate());
        card.setUserName(cardVO.getUserName());

        repository.save(card);
    }

}
