package org.estore.finki.controller;

import org.estore.finki.model.Customer;
import org.estore.finki.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by 133086 on 3/7/2017.
 */
@RestController()
@RequestMapping("/customer")
public class CustomerController
{

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping()
    @ResponseBody
    public String defaultMethod(){
        return "</br><p>Methods</p><ul>" +
                "<li>/getAllCustomers</li>" +
                "<li>/getCustomerById/{id}</li>" +
                "<li>/create</li></ul>";
    }

    @RequestMapping("/getCustomerById/{id}")
    public @ResponseBody String getById(@PathVariable(value="id") Long id, Model model)
    {

        model.addAttribute("controller", customerRepository.findOne(id));
        return customerRepository.findOne(id).toString();
    }

    @RequestMapping(value = "/getAllCustomers" /*, produces = MediaType.APPLICATION_XML_VALUE */)
    public List<Customer> getById()
    {
        List<Customer> toso = (List<Customer>) customerRepository.findAll();
        return toso;
    }

    @RequestMapping("/create")
    public String createNew(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname)
    {
        Customer toso = new Customer(name,surname);
        customerRepository.save(toso);
        return "Created new repository: " + toso.toString();
    }

}

