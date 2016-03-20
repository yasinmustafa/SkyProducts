package services;

import models.Catalogue;
import models.CatalogueDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasin on 20/03/16.
 */
public class CatalogueServiceImpl implements CatalogueService {
    @Override
    public List<Catalogue> findCataloguesByLocationId(Integer locationId) {
        return CatalogueDAO.findCataloguesByLocationIdAndEmptyLocation(locationId);
    }
}
