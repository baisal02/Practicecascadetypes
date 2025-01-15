package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "captains")
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "captain_gen")
    @SequenceGenerator(name = "captain_gen",sequenceName = "captain_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "captain",cascade = {CascadeType.PERSIST,
                                               CascadeType.MERGE,
                                               CascadeType.REMOVE,
                                               CascadeType.REFRESH
    },orphanRemoval = true)
    private List<Soldier>soldiers = new ArrayList<>();

    public Captain(String name) {
        this.name = name;
    }
}
