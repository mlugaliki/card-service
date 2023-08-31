package com.logicea.cards.repositories;

import com.logicea.cards.models.Cards;
import com.logicea.cards.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository extends JpaRepository<Cards, Long> {
    @Query(value = "SELECT c FROM Cards c WHERE c.name=:name AND c.colour=:colour AND c.status=:status AND c.createdAt>=:createDate")
    List<Cards> search(String name, String colour, Status status, LocalDateTime createDate);

    @Query(nativeQuery = true, value = "SELECT EXISTS(SELECT id FROM cards c WHERE c.name=:name  AND user_id=:id) card_exists")
    long getCardByNameAndUserId(String name, long id);

    @Query(value = "SELECT c FROM Cards c WHERE c.name=:name AND c.colour=:colour AND c.status=:status AND c.createdAt>=:createDate AND c.user.id=:userId")
    List<Cards> searchByUser(String name, String colour, Status status, LocalDateTime createDate, long userId);
}
