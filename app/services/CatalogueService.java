package services;

import com.google.inject.ImplementedBy;
import models.Catalogue;
import models.Location;

import java.util.List;

/**
 * Created by yasin on 20/03/16.
 */
@ImplementedBy(CatalogueServiceImpl.class)
public interface CatalogueService {

    List<Catalogue> findCataloguesByLocationId(Integer locationId);
}
