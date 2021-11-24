package com.da.daCryptApp.controller;


import com.da.daCryptApp.entity.RealtimeCurrencyExchangeRate;
import com.da.daCryptApp.service.RealtimeCurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private RealtimeCurrencyExchangeRateService realtimeCurrencyExchangeRateService;

    @RequestMapping("/")
    public String showRealTimeExRate(Model model){
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRates =
                realtimeCurrencyExchangeRateService.getRealtimeCurrencyExchangeRate();
        model.addAttribute("realTimeExRates", realtimeCurrencyExchangeRates);
        return "main-page";
    }

}
