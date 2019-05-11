package de.softwartechnik.catalin.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = Airline.TABLE_NAME)
@Entity(name = "airline")
@Data
@NoArgsConstructor
public class Airline {

    public static final String TABLE_NAME = "airlines";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * The name of the airline.
     */
    private String name;

    public Airline(String name) {
        this.name = name;
    }
}
