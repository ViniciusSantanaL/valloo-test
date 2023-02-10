package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.repository.CardRepository;
import br.com.valloo.cards.domain.card.vo.CardVO;
import br.com.valloo.cards.infrastructure.exception.EnityDuplicatedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateService {

    private final CardRepository repository;

    @Autowired
    public CardUpdateService(CardRepository repository) {
        this.repository = repository;
    }

    public void updateCard(final CardVO cardVO) {
        Card card = repository.findById(cardVO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Card=[id:" + cardVO.getId() + "]"));

        card.setCardNumber(cardVO.getCardNumber());
        card.setCardSecurityCode(cardVO.getCardNumber());
        card.setCardExpirationDate(cardVO.getCardExpirationDate());
        card.setUserName(cardVO.getUserName());

        update(card);
    }
    private void update(Card card) {
        try {
            repository.save(card);
        } catch (DataIntegrityViolationException ex) {
            throw new EnityDuplicatedException("Card", "cardNumber");
        }
    }
}
