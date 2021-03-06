package de.softwartechnik.catalin.core.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = Airline.TABLE_NAME)
@Entity(name = "airline")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline implements CatalinModel {

  public static final String TABLE_NAME = "airlines";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
  @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
  @Column(name = "id")
  private long id;

  /**
   * The name of the airline.
   */
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "airline_id")
  private List<Plane> planes;

  public Airline(String name, List<Plane> planes) {
    this.name = name;
    this.planes = planes;
  }
}
