package de.softwartechnik.catalin.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = Booking.TABLE_NAME)
@Entity(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements CatalinModel {

    public static final String TABLE_NAME = "bookings";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Person person;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Flight flight;

    @ManyToMany
    private List<BookingExtra> extras;

    public Booking(Person person, Flight flight, List<BookingExtra> extras) {
        this.person = person;
        this.flight = flight;
        this.extras = extras;
    }
}
