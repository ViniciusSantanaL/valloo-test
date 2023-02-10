package br.com.valloo.cards.application.incoming.card.update;

import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.infrastructure.errorhandling.MessageResponse;
import br.com.valloo.cards.domain.card.service.CardUpdateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter.of;

@RestController
@RequestMapping("/cards")
public class CardUpdateResource {

    private final CardUpdateService service;

    @Autowired
    public CardUpdateResource(CardUpdateService service) {
        this.service = service;
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<MessageResponse> updateCard(
            @PathVariable(value = "cardId") final UUID cardId, @RequestBody @Valid CardDTO cardDTO) {
        service.updateCard(of(cardDTO, cardId));
        return ResponseEntity
                .ok(new MessageResponse("Card updated with sucess!", HttpStatus.NO_CONTENT.value()));
    }
}
