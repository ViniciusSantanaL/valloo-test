package br.com.valloo.cards.domain.card.service;

import br.com.valloo.cards.domain.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardRemoveService {

    private final CardRepository repository;

    @Autowired
    public CardRemoveService(CardRepository repository) {
        this.repository = repository;
    }

    public void removeCard(UUID cardId) {
        try {
            repository.deleteById(cardId);
        }catch (Exception ex) {
            throw new DataIntegrityViolationException(ex.getMessage());
        }
    }
}
