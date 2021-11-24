package com.da.daCryptApp.service;

import com.da.daCryptApp.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateService {

    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    public void saveExchangeRate();

}
