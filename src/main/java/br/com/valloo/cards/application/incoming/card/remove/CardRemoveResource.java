package br.com.valloo.cards.application.incoming.card.remove;

import br.com.valloo.cards.application.incoming.card.commons.response.MessageResponse;
import br.com.valloo.cards.domain.card.service.CardRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardRemoveResource {

    private final CardRemoveService service;

    @Autowired
    public CardRemoveResource(CardRemoveService service) {
        this.service = service;
    }

    @DeleteMapping("/{cardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<MessageResponse> removeCard(@PathVariable(value = "cardId") final UUID cardId) {
        service.removeCard(cardId);
        return ResponseEntity
                .ok(new MessageResponse("Card deleted with sucess!", HttpStatus.NO_CONTENT.value()));
    }
}
