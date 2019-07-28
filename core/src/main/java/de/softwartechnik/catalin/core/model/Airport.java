package de.softwartechnik.catalin.core.model;

import com.google.common.collect.Lists;
import java.util.List;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Table(name = Airport.TABLE_NAME)
@Entity(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport implements CatalinModel {

  public static final String TABLE_NAME = "airports";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
  @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
  @Column(name = "id")
  private long id;

  private String name;

  @OneToMany
  @Cascade(CascadeType.ALL)
  @JoinColumn(name = "airport_id")
  private List<Terminal> terminals;

  @OneToMany
  @Cascade(CascadeType.ALL)
  @JoinColumn(name = "airport_id")
  private List<Employee> employees;

  public Airport(String name, List<Terminal> terminals, List<Employee> employees) {
    this.name = name;
    this.terminals = terminals;
    this.employees = employees;
  }

  public Airport(String name) {
    this(name, Lists.newArrayList(), Lists.newArrayList());
  }
}
