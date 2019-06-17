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

@Table(name = Employee.TABLE_NAME)
@Entity(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements CatalinModel {

    public static final String TABLE_NAME = "employees";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "id")
    private long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Airport airport;

    public Employee(String firstName, String lastName, Airport airport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.airport = airport;
    }
}
