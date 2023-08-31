package com.logicea.cards.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//uniqueConstraints = {
//        @UniqueConstraint(name = "crb_score_cid_id_un", columnNames = {"cif_id"}
@Getter
@Setter
@Entity
@Table(name = "cards", uniqueConstraints = {@UniqueConstraint(name = "card_user_un", columnNames = {"name", "user_id"})})
public class Cards extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", columnDefinition = "varchar(256) NOT NULL", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "varchar(256)")
    private String description;
    @Column(name = "colour", columnDefinition = "varchar(256)")
    private String colour;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cards)) return false;
        return id != null && id.equals(((Cards) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
