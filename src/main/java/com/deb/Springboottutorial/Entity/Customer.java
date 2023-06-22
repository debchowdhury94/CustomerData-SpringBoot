package com.deb.Springboottutorial.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Entity
@Table(name = "Customers")
@NoArgsConstructor
@Data
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id;
   @Column
   private String name;
   @Column
   private String email;
   @Column
   private int age;

   public Customer(int id, String name, String email, int age) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.age = age;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public String toString() {
      return "Customer{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", email='" + email + '\'' +
              ", age=" + age +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Customer customer)) return false;
      return getId() == customer.getId() && getAge() == customer.getAge() && Objects.equals(getName(), customer.getName()) && Objects.equals(getEmail(), customer.getEmail());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId(), getName(), getEmail(), getAge());
   }
}
