package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.shdemo.domain.Manufacturer;
import com.example.shdemo.domain.BoardGame;


@Component
@Transactional
public class SellingMangerHibernateImpl implements SellingManager {

  @Autowired
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  
  //-----------Board Games
  @Override
  public void addBoardGame(BoardGame boardgame) {
    sessionFactory.getCurrentSession().clear();
    sessionFactory.getCurrentSession().persist(boardgame);
  }
  @Override
  public void deleteBoardGame(BoardGame boardgame) {
    sessionFactory.getCurrentSession().delete(boardgame);
  }
  @Override
  public BoardGame findBoardGame(Long id) {
    return (BoardGame) sessionFactory.getCurrentSession().get(BoardGame.class, id);
  }
  @Override
  @SuppressWarnings("unchecked")
  public List<BoardGame> getAllBoardGames() {
    return sessionFactory.getCurrentSession().getNamedQuery("boardgame.all").list();
  }

  
  //--------------Customers
  @Override
  public void addCustomer(Customer owner) {
    sessionFactory.getCurrentSession().persist(owner);
  }
  @Override
  public void deleteCustomer(Customer owner) {
    sessionFactory.getCurrentSession().delete(owner);
  }
  @Override
  public Customer findCustomer(Long id) {
    return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
  }
  @Override
  @SuppressWarnings("unchecked")
  public List<Customer> getAllCustomers() {
    return sessionFactory.getCurrentSession().getNamedQuery("customer.all").list();
  }
  
  
  //----------Manufacturers
  @Override
  public void addManufacturer(Manufacturer man) {
    sessionFactory.getCurrentSession().persist(man);
  }
  @Override
  public void deleteManufacturer(Manufacturer man) {
    sessionFactory.getCurrentSession().delete(man);
  }
  @Override
  public Manufacturer findCompany(Long id) {
    return (Manufacturer) sessionFactory.getCurrentSession().get(Manufacturer.class, id);
  }
  @Override
  @SuppressWarnings("unchecked")
  public List<Manufacturer> getAllManufacturers() {
    return sessionFactory.getCurrentSession().getNamedQuery("manufacturer.all").list();
  }
}
