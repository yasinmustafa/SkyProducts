package services;

import com.google.inject.ImplementedBy;
import exceptions.LocationNotFoundException;
import models.Location;
import stubs.CustomerLocationServiceStub;

/**
 * Created by yasin on 20/03/16.
 */
@ImplementedBy(CustomerLocationServiceStub.class)
public interface CustomerLocationService {

    Location findLocationByCustomerId(Integer customerId) throws LocationNotFoundException;
}
