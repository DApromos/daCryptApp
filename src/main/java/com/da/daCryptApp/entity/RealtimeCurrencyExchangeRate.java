package com.da.daCryptApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "RealtimeCurrencyExchangeRate")
public class RealtimeCurrencyExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fromCurrencyShortName")
    private String fromCurrencyShortName;

    @Column(name = "fromCurrencyFullName")
    private String fromCurrencyFullName;

    @Column(name = "toCurrencyShortName")
    private String toCurrencyShortName;

    @Column(name = "toCurrencyFullName")
    private String toCurrencyFullName;

    @Column(name = "exchangeRate")
    private double exchangeRate;

    @Column(name = "lastRefreshed")
    private String lastRefreshed;

    @Column(name = "timeZone")
    private String timeZone;

    @Column(name = "bidPrice")
    private double bidPrice;

    @Column(name = "askPrice")
    private double askPrice;


    public RealtimeCurrencyExchangeRate() {
    }

    public RealtimeCurrencyExchangeRate(String fromCurrencyShortName, String fromCurrencyFullName, String toCurrencyShortName, String toCurrencyFullName, double exchangeRate, String lastRefreshed, String timeZone, double bidPrice, double askPrice) {
        this.fromCurrencyShortName = fromCurrencyShortName;
        this.fromCurrencyFullName = fromCurrencyFullName;
        this.toCurrencyShortName = toCurrencyShortName;
        this.toCurrencyFullName = toCurrencyFullName;
        this.exchangeRate = exchangeRate;
        this.lastRefreshed = lastRefreshed;
        this.timeZone = timeZone;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromCurrencyShortName() {
        return fromCurrencyShortName;
    }

    public void setFromCurrencyShortName(String fromCurrencyShortName) {
        this.fromCurrencyShortName = fromCurrencyShortName;
    }

    public String getFromCurrencyFullName() {
        return fromCurrencyFullName;
    }

    public void setFromCurrencyFullName(String fromCurrencyFullName) {
        this.fromCurrencyFullName = fromCurrencyFullName;
    }

    public String getToCurrencyShortName() {
        return toCurrencyShortName;
    }

    public void setToCurrencyShortName(String toCurrencyShortName) {
        this.toCurrencyShortName = toCurrencyShortName;
    }

    public String getToCurrencyFullName() {
        return toCurrencyFullName;
    }

    public void setToCurrencyFullName(String toCurrencyFullName) {
        this.toCurrencyFullName = toCurrencyFullName;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }
}
