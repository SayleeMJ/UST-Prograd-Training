package engineer.saylee.Bank.controller;

import engineer.saylee.Bank.entity.Customer;
import engineer.saylee.Bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BankController {

    @Autowired
    private CustomerService service;

    @RequestMapping("/")
    public String index(){
        return "Home";
    }

    @RequestMapping("/Home")
    public String home(){
        return "Home";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request){
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        Customer customer;
        if (service.existsById(username) == true) {
            customer = service.findById(username);
            if (password.equals(customer.getPassword())) {
                model.addAttribute("customerName", customer.getCustomerName());
                model.addAttribute("userName", customer.getUserName());
                model.addAttribute("Email", customer.getEmail());
                model.addAttribute("Address", customer.getAddress());
                model.addAttribute("Contact", customer.getContact());
                return "afterlogin";

            } else {
                model.addAttribute("errorMessage", "Invalid credentials!!!!!!!");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid credentials!!!!!!!");
            return "login";
        }
    }

    @RequestMapping("/afterlogin")
    public String afterlogin(){
        return "afterlogin";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, HttpServletRequest request){
        String name = request.getParameter("customerName");
        String  username = request.getParameter("userName");
        String contact = request.getParameter("Contact");
        String  email = request.getParameter("Email");
        String  address = request.getParameter("Address");
        String password = request.getParameter("Password");

        Customer customer = new Customer(name,username,contact,email,address,password);
        service.saveCustomer(customer);
        model.addAttribute("registerSuccessMessage", "Registered Successfully!!");
        return "login";
    }

    @RequestMapping("/updateDetails/{username}")
    public String updateDetails(@PathVariable String username, Model model){
        model.addAttribute("customer",service.findById(username));
        return "updateDetails";
    }

    @PostMapping(value = "/updateDetails")
    public String updateDetails(Model model,HttpServletRequest request){

        Customer customer = service.findById(request.getParameter("userName"));
        customer.setCustomerName(request.getParameter("customerName"));
        customer.setContact(request.getParameter("Contact"));
        customer.setEmail(request.getParameter("Email"));
        customer.setAddress(request.getParameter("Address"));
        customer.setPassword(request.getParameter("Password"));

        service.updateCustomer(customer);

        model.addAttribute("customerName", customer.getCustomerName());
        model.addAttribute("userName", customer.getUserName());
        model.addAttribute("Email", customer.getEmail());
        model.addAttribute("Address", customer.getAddress());
        model.addAttribute("Contact", customer.getContact());

        return "afterlogin";
    }

    @RequestMapping("/fundTransfer")
    public String transfer(){
        return "fundTransfer";
    }
}
