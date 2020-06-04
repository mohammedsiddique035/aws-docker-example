package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "primefactor")
public class primeController {

    //@GetMapping -->can use this as well
    @RequestMapping(path = "/{num}", method = RequestMethod.GET)
    public String greeting(@PathVariable int num) {
        return "The Prime Factors of " + num + " are : " + this.primeFactors(num);
    }

    private String primeFactors(int num) {
        StringBuffer factors = new StringBuffer();
        for (int factor = 2; factor * factor <= num; factor++) {

            while (num % factor == 0) {
                factors.append(factor).append("*");
                num = num / factor;
            }
        }
        if (num > 1) {
            factors.append(num).append("*");
        }
        if (factors.length() > 0)
            factors.deleteCharAt(factors.length() - 1);
        return factors.toString();
    }
}
