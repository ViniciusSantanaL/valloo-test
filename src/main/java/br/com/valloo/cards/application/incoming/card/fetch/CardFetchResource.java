package br.com.valloo.cards.application.incoming.card.fetch;

import br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter;
import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.domain.card.service.CardFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter.toResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/cards")
public class CardFetchResource {

    private final CardFetchService service;

    @Autowired
    public CardFetchResource(CardFetchService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void fetchCard() {

    }

    @GetMapping("/{cardId}")
    @ResponseStatus(HttpStatus.OK)
    public CardDTO fetchCardById(@PathVariable(value = "cardId") final UUID cardId) {
        return toResponse(service.fetchCardById(cardId));
    }
}
