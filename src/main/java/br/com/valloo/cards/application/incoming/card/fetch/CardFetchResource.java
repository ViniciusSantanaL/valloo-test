package br.com.valloo.cards.application.incoming.card.fetch;

import br.com.valloo.cards.application.incoming.card.commons.converter.CardConverter;
import br.com.valloo.cards.application.incoming.card.commons.dtos.CardDTO;
import br.com.valloo.cards.domain.card.service.CardFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<CardDTO> fetchCard(
            @RequestParam(name = "userName", required = false) String userName,
            @RequestParam(name = "cardNumber", required = false) String cardNumber,
            @RequestParam(name = "cardSecurityCode", required = false) String cardSecurityCode,
            @RequestParam(name = "cardExpirationDate", required = false) String cardExpirationDate,
            @RequestParam(defaultValue = "cardExpirationDate") String sortBy ,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "30") Integer pageSize) {

        return service.fetchCard(userName,cardNumber,cardSecurityCode,cardExpirationDate,
                PageRequest.of(page,pageSize, Sort.by(sortBy))).map(CardConverter::toResponse);
    }

    @GetMapping("/{cardId}")
    @ResponseStatus(HttpStatus.OK)
    public CardDTO fetchCardById(@PathVariable(value = "cardId") final UUID cardId) {
        return toResponse(service.fetchCardById(cardId));
    }
}
