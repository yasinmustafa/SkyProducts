package services;

import exceptions.LocationNotFoundException;
import junit.framework.Assert;
import org.junit.Test;
import models.Location;
import stubs.CustomerLocationServiceStub;

/**
 * Created by yasin on 20/03/16.
 */
public class TestCustomerLocationServiceStub {

    CustomerLocationService customerLocationService = new CustomerLocationServiceStub();

    @Test
    public void test_London_is_Returned_for_Even_Numbers() throws LocationNotFoundException {
        for (int i=2; i<11; i++) {
            Location location = customerLocationService.findLocationByCustomerId(i);
            Assert.assertTrue(location.getName().equals("London"));
            i++;
        }

    }

    @Test
    public void test_Liverpool_is_Returned_for_Odd_Numbers() throws LocationNotFoundException {
        for (int i=1; i<11; i++) {
            Location location = customerLocationService.findLocationByCustomerId(i);
            Assert.assertTrue(location.getName().equals("Liverpool"));
            i++;
        }

    }

    @Test(expected = LocationNotFoundException.class)
    public void test_Exception_Is_thrown_for_Invalid_Customer() throws LocationNotFoundException {

            customerLocationService.findLocationByCustomerId(null);



    }
}
