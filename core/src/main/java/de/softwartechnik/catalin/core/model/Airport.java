package de.softwartechnik.catalin.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = Airport.TABLE_NAME)
@Entity(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport implements CatalinModel {

    public static final String TABLE_NAME = "airports";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @OneToMany
    private List<Terminal> terminals;

    @OneToMany
    private List<Employee> employees;

    public Airport(String name, List<Terminal> terminals, List<Employee> employees) {
        this.name = name;
        this.terminals = terminals;
        this.employees = employees;
    }
}
