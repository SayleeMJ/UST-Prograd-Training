package engineer.saylee.Bank.controller;

import engineer.saylee.Bank.entity.Account;
import engineer.saylee.Bank.entity.Customer;
import engineer.saylee.Bank.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String index(){
        return "Home";
    }

//    @RequestMapping("/Home")
//    public String home(){
//        return "Home";
//    }
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
//                model.addAttribute("accountNumber", customer.getAccount().getAccountNumber());
//                model.addAttribute("balance", customer.getAccount().getBalance());
                return "afterlogin";

            } else {
                model.addAttribute("errorMessage", "Incorrect Password.");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Please enter valid Username");
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

    @RequestMapping("/updateDetails/{id}")
    public String updateDetailsForm(@PathVariable String id, Model model){
        model.addAttribute("customer",service.findById(id));
        return "updateDetails";
    }

    @PostMapping("/updateDetails")
    public String updateDetails(Model model,HttpServletRequest request){

        Customer existingCustomer = service.findById(request.getParameter("userName"));
        existingCustomer.setCustomerName(request.getParameter("customerName"));
        existingCustomer.setContact(request.getParameter("Contact"));
        existingCustomer.setEmail(request.getParameter("Email"));
        existingCustomer.setAddress(request.getParameter("Address"));

        service.updateCustomer(existingCustomer);

        model.addAttribute("customerName", existingCustomer.getCustomerName());
        model.addAttribute("userName", existingCustomer.getUserName());
        model.addAttribute("Email", existingCustomer.getEmail());
        model.addAttribute("Address", existingCustomer.getAddress());
        model.addAttribute("Contact", existingCustomer.getContact());

//        model.addAttribute("accountNumber", existingCustomer.getAccount().getAccountNumber());
//        model.addAttribute("balance", existingCustomer.getAccount().getBalance());
        return "afterlogin";
    }

    @RequestMapping("/fundTransfer/{accountNumber}")
    public String transfer(@PathVariable String accountNumber, Model model){
        model.addAttribute("accountNumber", accountNumber);
        return "fundTransfer";
    }

    @PostMapping("/fundTransfer/{accountNumber}")
    public String fundTransfer(@PathVariable String accountNumber, Model model, HttpServletRequest request){

        String toAccount = request.getParameter("toAccount");
        Double amount = Double.parseDouble(request.getParameter("amount"));


        if (accountService.existAccount(toAccount)) {
            Account account1 = accountService.getById(accountNumber);
            Account account2 = accountService.getById(toAccount);
            if (account1.getBalance() <= amount) {
                model.addAttribute("message", "insufficient Amount in your Account");
            } else {
                account1.withdraw(amount);
                account2.deposit(amount);
                accountService.saveAccount(account1);
                accountService.saveAccount(account2);
                model.addAttribute("message", "Transaction done successfully");
            }
        }
        else {
            model.addAttribute("message", "Account does not Exist! Please Enter valid Account Number");
        }

        return "fundTransfer";
    }
}
