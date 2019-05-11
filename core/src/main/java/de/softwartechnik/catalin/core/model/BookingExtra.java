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

@Table(name = BookingExtra.TABLE_NAME)
@Entity(name = "bookingExtra")
@Data
@NoArgsConstructor
public class BookingExtra {

    public static final String TABLE_NAME = "booking_extras";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;
    private String description;
    private double price;

    public BookingExtra(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
