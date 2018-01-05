package com.example.shdemo.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "boardgame.all", query = "Select b from BoardGame b")
})
public class BoardGame {
  private Long id;
  private String name;
  private int year;
  private Manufacturer manufacturer;
  private List<Customer> customers;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public Manufacturer getCompany() {
    return manufacturer;
  }

  public void setCompany(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }
}
