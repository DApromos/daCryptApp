package com.da.daCryptApp.dao;

import com.da.daCryptApp.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateDAO {

    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    public void saveRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate);

}
