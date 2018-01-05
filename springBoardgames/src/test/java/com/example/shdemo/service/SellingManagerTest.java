package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Manufacturer;
import com.example.shdemo.domain.BoardGame;
import com.example.shdemo.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class SellingManagerTest {

  @Autowired
  SellingManager sellingManager;

  @Test
  public void addGameCheck() {
    BoardGame boardgame = new BoardGame();
    boardgame.setYear(1996);
    boardgame.setName("Game Of Thrones");
    
    Manufacturer manufacturer = new Manufacturer("Agglo", 1990);
    boardgame.setCompany(manufacturer);
    
    Customer cust1 = new Customer("Adam", "Madam", 11);
    Customer cust2 = new Customer("Karol", "Wisienki", 55);
    List<Customer> orders = new ArrayList<Customer>();
    
    orders.add(cust1);
    orders.add(cust2);
    boardgame.setCustomers(orders);
    
    List<BoardGame> stateBefore = sellingManager.getAllBoardGames();
    sellingManager.addBoardGame(boardgame);
    List<BoardGame> stateAfter = sellingManager.getAllBoardGames();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteGameCheck() {
    BoardGame boardgame = new BoardGame();
    boardgame.setYear(1990);
    boardgame.setName("Chronicles");
    sellingManager.addBoardGame(boardgame);
    
    List<BoardGame> stateBefore = sellingManager.getAllBoardGames();
    sellingManager.deleteBoardGame(boardgame);
    List<BoardGame> stateAfter = sellingManager.getAllBoardGames();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findGameCheck() {
    BoardGame boardgame = new BoardGame();
    boardgame.setYear(2001);
    boardgame.setName("Independants");
    sellingManager.addBoardGame(boardgame);
    
    BoardGame found = sellingManager.findBoardGame(boardgame.getId());
    assertEquals(boardgame.getYear(), found.getYear(), 0.01);
    assertEquals(boardgame.getName(), found.getName());
  }

  @Test
  public void addCompanyCheck() {
    Manufacturer manufacturer = new Manufacturer("Bandai", 1991);
    
    List<?> stateBefore = sellingManager.getAllManufacturers();
    sellingManager.addManufacturer(manufacturer);
    List<?> stateAfter = sellingManager.getAllManufacturers();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteCompanyCheck() {
    Manufacturer manufacturer = new Manufacturer("CraftyGames", 2005);
    
    sellingManager.addManufacturer(manufacturer);
    List<?> stateBefore = sellingManager.getAllManufacturers();
    sellingManager.deleteManufacturer(manufacturer);
    List<?> stateAfter = sellingManager.getAllManufacturers();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findCompanyCheck() {
    Manufacturer manufacturer = new Manufacturer("Dragon", 1989);
    
    sellingManager.addManufacturer(manufacturer);
    Manufacturer found = sellingManager.findCompany(manufacturer.getId());
    assertEquals(manufacturer.getName(), found.getName());
    assertEquals(manufacturer.getYearOfCreation(), found.getYearOfCreation());
  }

  @Test
  public void addOwnerCheck() {
    Customer owner = new Customer("Jack", "Truck", 1990);
    
    List<Customer> stateBefore = sellingManager.getAllCustomers();
    sellingManager.addCustomer(owner);
    List<Customer> stateAfter = sellingManager.getAllCustomers();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteOwnerCheck() {
    Customer customer = new Customer("Marek", "Kozacki", 31);
    
    sellingManager.addCustomer(customer);
    List<Customer> stateBefore = sellingManager.getAllCustomers();
    sellingManager.deleteCustomer(customer);
    List<Customer> stateAfter = sellingManager.getAllCustomers();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findOwnerCheck() {
    Customer customer = new Customer("Kamil", "Stoch", 22);
    
    sellingManager.addCustomer(customer);
    Customer found = sellingManager.findCustomer(customer.getId());
    assertEquals(customer.getFirstName(), found.getFirstName());
    assertEquals(customer.getLastName(), found.getLastName());
    assertEquals(customer.getAge(), found.getAge());
  }

  @Test
  public void LazyExceptionTest() {
    BoardGame boardgame = new BoardGame();
    boardgame.setYear(2008);
    boardgame.setName("Sheepes");
    
    Manufacturer manufacturer = new Manufacturer("Eurogames", 2009);
    boardgame.setCompany(manufacturer);
    
    Customer cust1 = new Customer("Adam", "Roman", 31);
    Customer cust2 = new Customer("Kasia", "Wybina", 11);
    List<Customer> orders = new ArrayList<Customer>();
    
    orders.add(cust1);
    orders.add(cust2);
    boardgame.setCustomers(orders);
    
    sellingManager.addBoardGame(boardgame);
    List<Customer> owners = boardgame.getCustomers();
    try {
      System.out.println(owners.get(0).getFirstName());
      System.out.println(owners.get(1).getFirstName());
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
