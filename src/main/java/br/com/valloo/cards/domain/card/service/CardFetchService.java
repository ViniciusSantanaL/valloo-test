package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.repository.CardRepository;
import br.com.valloo.cards.domain.card.repository.CardSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardFetchService {


    private final CardRepository repository;

    @Autowired
    public CardFetchService(CardRepository repository) {
        this.repository = repository;
    }
    public Page<Card> fetchCard(String userName, String cardNumber,
            String cardSecurityCode, String cardExpirationDate, PageRequest pageRequest) {
        return repository.findAll(new CardSpecification().with(userName,cardNumber,cardSecurityCode,cardExpirationDate),
                pageRequest);
    }
    public Card fetchCardById(final UUID cardId) {
        return repository.findById(cardId).orElseThrow(() -> new EntityNotFoundException("Card=[id:" + cardId + "]"));
    }

}
