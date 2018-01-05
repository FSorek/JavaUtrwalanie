package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "manufacturer.all", query = "select m from Manufacturer m"),
    @NamedQuery(name = "manufacturer.removeAll", query = "delete from Manufacturer")
})
public class Manufacturer {
  private long id;
  private String name;
  private int yearOfCreation;

  public Manufacturer() {
    super();
  }

  public Manufacturer(String name, int yearOfCreation) {
    this.name = name;
    this.yearOfCreation = yearOfCreation;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYearOfCreation() {
    return yearOfCreation;
  }

  public void setYearOfCreation(int yearOfCreation) {
    this.yearOfCreation = yearOfCreation;
  }
}
