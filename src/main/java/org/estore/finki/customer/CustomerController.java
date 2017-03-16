package org.estore.finki.customer;

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
    @RequestMapping("/getCustomerById/{id}")
    public @ResponseBody String getById(@PathVariable(value="id") Long id, Model model)
    {

        model.addAttribute("product", customerRepository.findOne(id));
        return "product";
    }

    @RequestMapping("/getAllCustomers")
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
        return "Created new customer: " + toso.toString();
    }

}

