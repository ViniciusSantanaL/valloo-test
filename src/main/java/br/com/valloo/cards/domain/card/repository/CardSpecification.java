package br.com.valloo.cards.domain.card.repository;

import br.com.valloo.cards.domain.card.model.Card;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardSpecification implements Specification<Card> {

    public static final  String USER_NAME = "userName";

    public static final  String CARD_NUMBER = "cardNumber";

    public static final  String CARD_SECURITY_CODE = "cardSecurityCode";

    public static final  String CARD_EXPIRAITON_DATE = "cardExpirationDate";

    private String userName;

    private String cardNumber;

    private String cardSecurityCode;

    private String cardExpirationDate;

    public CardSpecification with(String userName, String cardNumber,
            String cardSecurityCode, String cardExpirationDate) {
        this.userName = userName;
        this.cardNumber = cardNumber;
        this.cardSecurityCode = cardSecurityCode;
        this.cardExpirationDate = cardExpirationDate;
        return this;
    }

    @Override
    public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(userName)) {
            predicates.add(builder.like(builder.lower(root.get(USER_NAME)),"%" + userName.toLowerCase() + "%"));
        }

        if(Objects.nonNull(cardNumber)) {
            predicates.add(builder.like(builder.lower(root.get(CARD_NUMBER)),"%" + cardNumber.toLowerCase() + "%"));
        }

        if(Objects.nonNull(cardSecurityCode)) {
            predicates.add(builder.like(
                    builder.lower(root.get(CARD_SECURITY_CODE)),"%" + cardSecurityCode.toLowerCase() + "%"));
        }

        if(Objects.nonNull(cardExpirationDate)) {
            predicates.add(builder.equal(root.get(CARD_EXPIRAITON_DATE), cardExpirationDate));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
