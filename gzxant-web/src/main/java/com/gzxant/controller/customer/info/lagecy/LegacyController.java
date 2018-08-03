package com.gzxant.controller.customer.info.lagecy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/info")
public class LegacyController {
    @GetMapping("customer/legacy")
    public String getCustomerPage(){
       return "customer/info/customer/legacy";
    }
}
