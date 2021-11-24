package com.da.daCryptApp.dao;

import com.da.daCryptApp.entity.RealtimeCurrencyExchangeRate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealtimeCurrencyExchangeRateDAOImplementation implements RealtimeCurrencyExchangeRateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate() {

        Session session = sessionFactory.getCurrentSession();
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRates =
                session.createQuery("from RealtimeCurrencyExchangeRate", RealtimeCurrencyExchangeRate.class)
                        .getResultList();

        return realtimeCurrencyExchangeRates;
    }


    @Override
    public void saveRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate) {







        Session session = sessionFactory.getCurrentSession();
        session.save(realtimeCurrencyExchangeRate);

    }

}
