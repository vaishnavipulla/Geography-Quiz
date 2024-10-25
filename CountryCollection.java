CountryCollection.java
package edu.uga.cs1302.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CountryCollection {
    private List<Country> countries;

    public CountryCollection() {
        this.countries = new ArrayList<Country>();

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("country_continent.csv");
            Reader in = new BufferedReader(new InputStreamReader(is));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

            for (CSVRecord record : records) {
                String name = record.get(0);
                String continent = record.get(1);
                Country country = new Country(name, continent);
                addCountry(country);
            }
            System.out.println("CountryCollection: number of countries: " + countries.size());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void addCountry(Country country) {
        if (country == null) {
            return;
        }
        countries.add(country);
    }

    public Country getCountryAtIndex(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index >= countries.size())) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return countries.get(index);
    }

    @Override
    public String toString() {
        return "CountryCollection [countries=" + countries + "]";
    }
}
