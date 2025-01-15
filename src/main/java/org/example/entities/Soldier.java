package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "soldiers")
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "soldier_gen")
    @SequenceGenerator(name = "soldier_gen",sequenceName = "soldier_seq",allocationSize = 1)
    private Long id;
    private String name;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST, CascadeType.MERGE})
    private Captain captain;
    public Soldier(String name) {
        this.name = name;
    }
}
