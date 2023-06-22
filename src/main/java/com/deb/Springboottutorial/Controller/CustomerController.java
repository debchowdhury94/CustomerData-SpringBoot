package com.deb.Springboottutorial.Controller;

import com.deb.Springboottutorial.Entity.Customer;
import com.deb.Springboottutorial.Exception.CourseNotFoundException;
import com.deb.Springboottutorial.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
   @Autowired
   private CustomerRepository customerRepository;
  @RequestMapping(value = "/customers",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Customer> getCustomers(){
      return customerRepository.findAll();
   }

   @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
   public Customer addCustomer(@RequestBody Customer customer) {
     customerRepository.save(customer);
      return customer;
   }
   @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public Customer getCustomerById(@PathVariable("id") int id){
      Optional<Customer> cus = customerRepository.findById(id);
         if(cus.isEmpty()){
            throw new CourseNotFoundException("customer with that id is not present");
         }
         return cus.get();
   }
   @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
   public void deleteCustomerById(@PathVariable("id") int id){
      Optional<Customer> cus = customerRepository.findById(id);
      if(cus.isEmpty()){
         throw new CourseNotFoundException("customer with that id is not present. Could not delete");
      }
      customerRepository.deleteById(id);
   }

   @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public Customer updateCustomer(@RequestBody Customer customer){
      Optional<Customer> cus = customerRepository.findById(customer.getId());
      if(cus.isEmpty()){
         throw new CourseNotFoundException("customer with that id is not present. Could not update");
      }
      customer.setId(cus.get().getId());
      customerRepository.save(customer);
      return customer;
   }

   @RequestMapping(value = "/updateEmail/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public Customer updateCustomerEmail(@PathVariable("id") int id, @RequestBody Customer customer){
      Optional<Customer> cus = customerRepository.findById(id);
      if(cus.isEmpty()){
         throw new CourseNotFoundException("customer with that id is not present. Could not update");
      }
      cus.get().setEmail(customer.getEmail());
      customerRepository.save(cus.get());
      return cus.get();
   }

}

