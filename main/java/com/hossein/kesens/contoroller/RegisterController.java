package com.hossein.kesens.contoroller;

import com.hossein.kesens.model.access.Users;
import com.hossein.kesens.model.customer.Customer;
import com.hossein.kesens.service.AccessService;
import com.hossein.kesens.service.ContextService;
import com.hossein.kesens.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hossein on 4/24/17.
 */
@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccessService accessService;
    @Autowired
    private ContextService contextService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null)
            model.addAttribute("error", "ایمیل یا رمز ورود اشتباه است");
        if (logout != null)
            model.addAttribute("logout", "خروج موفق بود");

        Customer customer = new Customer();
        model.addAttribute(customer);
        model.addAttribute("contextService",contextService);
        return "login";
    }

    @RequestMapping("/register")
    public String registerCustomer(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("error", "لطفا مشخصه های ستاره دار را پر کنید");

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("contextService",contextService);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("customer") Customer customer) {
        customer.setEnabled(true);
        Users user = new Users(customer.getCustomerEmail(),customer.getCustomerPassword(),true,"ROLE_USER");
        accessService.addUser(user);
        customerService.addCustomer(customer);
        return "redirect:/";
    }

}
