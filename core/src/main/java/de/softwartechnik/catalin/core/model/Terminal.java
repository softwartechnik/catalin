package de.softwartechnik.catalin.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = Terminal.TABLE_NAME)
@Entity(name = "terminal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terminal implements CatalinModel {

    public static final String TABLE_NAME = "terminals";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @ManyToOne
    private Airport airport;

    public Terminal(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
    }
}
