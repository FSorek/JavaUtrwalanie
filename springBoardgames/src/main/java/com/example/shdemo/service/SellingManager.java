package com.example.shdemo.service;

import java.util.List;


import com.example.shdemo.domain.Manufacturer;
import com.example.shdemo.domain.BoardGame;
import com.example.shdemo.domain.Customer;

public interface SellingManager {

  void addBoardGame(BoardGame boardgame);
  void deleteBoardGame(BoardGame boardgame);
  BoardGame findBoardGame(Long id);
  List<BoardGame> getAllBoardGames();

  void addCustomer(Customer owner);
  void deleteCustomer(Customer owner);
  Customer findCustomer(Long id);
  List<Customer> getAllCustomers();
  
  void addManufacturer(Manufacturer man);
  void deleteManufacturer(Manufacturer man);
  Manufacturer findCompany(Long id);
  List<?> getAllManufacturers();
}
