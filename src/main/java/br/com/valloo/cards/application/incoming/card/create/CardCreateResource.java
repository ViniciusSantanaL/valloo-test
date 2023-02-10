package br.com.valloo.cards.application.incoming.card.create;

import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.domain.card.service.CardCreateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter.of;
import static br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter.toResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/cards")
public class CardCreateResource {

    private final CardCreateService service;

    @Autowired
    public CardCreateResource(CardCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardDTO create(@RequestBody @Valid CardDTO cardDTO) {
        return toResponse(service.createCard(of(cardDTO)));
    }
}
