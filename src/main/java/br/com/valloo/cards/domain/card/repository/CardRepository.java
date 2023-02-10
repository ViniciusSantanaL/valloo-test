package br.com.valloo.cards.domain.card.repository;

import br.com.valloo.cards.domain.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID>, JpaSpecificationExecutor<Card> {
}
