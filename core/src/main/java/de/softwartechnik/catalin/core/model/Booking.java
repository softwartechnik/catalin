package de.softwartechnik.catalin.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = Booking.TABLE_NAME)
@Entity(name = "booking")
@Data
@NoArgsConstructor
public class Booking {

    public static final String TABLE_NAME = "bookings";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Flight flight;

    @OneToMany
    private List<BookingExtra> extras;

    public Booking(Person person, Flight flight, List<BookingExtra> extras) {
        this.person = person;
        this.flight = flight;
        this.extras = extras;
    }
}
