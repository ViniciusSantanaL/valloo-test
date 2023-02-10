package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.repository.CardRepository;
import br.com.valloo.cards.domain.card.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import static br.com.valloo.cards.domain.card.vo.builder.CardBuilder.create;
import static br.com.valloo.cards.domain.card.vo.builder.CardBuilder.of;

@Service
public class CardCreateService {

    private final CardRepository cardRepository;

    @Autowired
    public CardCreateService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardVO createCard(CardVO cardVO) {

        Card card = saveCard(create(cardVO));

        return of(card);
    }

    private Card saveCard(Card card) {
        try {
            return cardRepository.save(card);
        } catch (Exception ex) {
            throw new DataIntegrityViolationException("exception");
        }
    }
}

