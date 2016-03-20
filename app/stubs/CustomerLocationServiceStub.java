package stubs;

import exceptions.LocationNotFoundException;
import models.Location;
import services.CustomerLocationService;

/**
 * Created by yasin on 20/03/16.
 */
public class CustomerLocationServiceStub implements CustomerLocationService {

    public Location findLocationByCustomerId(Integer customerId) throws LocationNotFoundException{

        if (customerId==null) {
            throw new LocationNotFoundException("No location could be found as customer ID is null");
        }
        if (customerId%2==0)
        {
            Location location = new Location();
            location.setId(1);
            location.setName("London");
            return location;

        }
        Location location = new Location();
        location.setId(2);
        location.setName("Liverpool");
        return location;
    }
}
