package com.countriesinfo.app.model;

import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Country {

    public static final String TAG = "COUNTRY";

    @SerializedName("name")
    public String name;

    @SerializedName("capital")
    public String capital;

    @SerializedName("currencies")
    public List<String> currencies;

    @SerializedName("region")
    public String region;

    @SerializedName("population")
    public String population;

    @SerializedName("alpha2Code")
    public String alpha2Code;

    @SerializedName("callingCodes")
    public List<String> callingCodes;

    public String currency;

    public Country() {
    }

    public Country(String name, String capital, String region, String alphaCode) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.alpha2Code = alphaCode;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Country setCurrency(String currency) {
        this.currency = currency;
        return this;

    }

    public String getCapital() {
        return capital;
    }

    public Country setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Country setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getPopulation() {
        return population;
    }

    public Country setPopulation(String population) {
        this.population = population;
        return this;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public Country setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public Country setCurrencies(List<String> currencies) {
        this.currencies = currencies;
        return this;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public Country setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null) return false;
        if (currencies != null ? !currencies.equals(country.currencies) : country.currencies != null) return false;
        if (region != null ? !region.equals(country.region) : country.region != null) return false;
        if (population != null ? !population.equals(country.population) : country.population != null) return false;
        if (alpha2Code != null ? !alpha2Code.equals(country.alpha2Code) : country.alpha2Code != null) return false;
        if (callingCodes != null ? !callingCodes.equals(country.callingCodes) : country.callingCodes != null)
            return false;
        return currency != null ? currency.equals(country.currency) : country.currency == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (currencies != null ? currencies.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (alpha2Code != null ? alpha2Code.hashCode() : 0);
        result = 31 * result + (callingCodes != null ? callingCodes.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", currencies=" + currencies +
                ", region='" + region + '\'' +
                ", population='" + population + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", callingCodes=" + callingCodes +
                ", currency='" + currency + '\'' +
                '}';
    }
}
