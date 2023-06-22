package com.deb.Springboottutorial.Repository;

import com.deb.Springboottutorial.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
