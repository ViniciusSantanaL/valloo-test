package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.model.Card;
import br.com.valloo.cards.domain.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardFetchService {


    private final CardRepository repository;

    @Autowired
    public CardFetchService(CardRepository repository) {
        this.repository = repository;
    }

    public Card fetchCardById(final UUID cardId) {
        return repository.findById(cardId).orElseThrow(() -> new RuntimeException("test"));
    }

}
