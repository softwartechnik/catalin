package de.softwartechnik.catalin.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = Plane.TABLE_NAME)
@Entity(name = "plane")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane implements CatalinModel {

    public static final String TABLE_NAME = "planes";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "id")
    private long id;

    private String name;

    public Plane(String name) {
        this.name = name;
    }
}
