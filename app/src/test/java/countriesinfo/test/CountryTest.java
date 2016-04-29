package countriesinfo.test;

import com.countriesinfo.app.model.Country;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class CountryTest {

    private Country country;

    @Test
    public void assert_country_valid() throws Exception {

        country = new Country("Germany", "Berlin", "Europe", "DE");

        final String EXPECTED_NAME = "Germany";
        final String EXPECTED_CAPITAL = "Berlin";
        final String EXPECTED_REGION = "Europe";
        final String EXPECTED_ALPHA_CODE = "DE";

        assertEquals(EXPECTED_NAME, country.getName());
        assertEquals(EXPECTED_CAPITAL, country.getCapital());
        assertEquals(EXPECTED_REGION, country.getRegion());
        assertEquals(EXPECTED_ALPHA_CODE, country.getAlpha2Code());
    }

    @Test
    public void assert_country_not_same() throws Exception {

        country = new Country("Germany", "Berlin", "Europe", "DE");

        final String EXPECTED_NAME = "France";
        final String EXPECTED_CAPITAL = "Paris";
        final String EXPECTED_REGION = "Europe";
        final String EXPECTED_ALPHA_CODE = "FR";

        assertNotSame(EXPECTED_NAME, country.getName());
        assertNotSame(EXPECTED_CAPITAL, country.getCapital());
        assertEquals(EXPECTED_REGION, country.getRegion());
        assertNotSame(EXPECTED_ALPHA_CODE, country.getAlpha2Code());
    }

}
