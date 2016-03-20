package models;

import play.db.jpa.JPA;

import java.util.List;

public class CatalogueDAO {


    /**
     * Get all Catalogue Products for a specific location
     * Will also return catalogues relating to no location
     *
     * @return List<Catalogue>
     */
    public static List<Catalogue> findCataloguesByLocationIdAndEmptyLocation(Integer locationId) {
        return (List<Catalogue>) JPA.em().createQuery("SELECT c FROM Catalogue c where locationId = " + locationId + " or locationId is null").getResultList();
    }


}