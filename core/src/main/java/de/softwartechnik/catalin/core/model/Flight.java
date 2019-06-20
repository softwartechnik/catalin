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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = Flight.TABLE_NAME)
@Entity(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements CatalinModel {

    public static final String TABLE_NAME = "flights";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "id")
    private long id;

    private String title;

    @ManyToOne
    private Terminal source;

    @ManyToOne
    private Terminal destination;

    @ManyToOne
    private Plane plane;

    public Flight(String title, Terminal source, Terminal destination, Plane plane) {
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.plane = plane;
    }
}
