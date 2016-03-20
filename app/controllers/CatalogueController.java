package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import models.Catalogue;
import models.Location;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CatalogueService;
import services.CustomerLocationService;

import java.util.List;

public class CatalogueController extends Controller {

    @Inject
    CatalogueService catalogueService;

    /**
     * Add the content-type json to response
     *
     * @param Result httpResponse
     *
     * @return Result
     */
    public Result jsonResult(Result httpResponse) {
        response().setContentType("application/json; charset=utf-8");
        return httpResponse;
    }

    /**
     * Get Catalogue Products by locationId
     *
     * @param Integer id
     *
     * @return Result
     */
    @Transactional(readOnly = true)
    public Result getProducts(Integer locationId) {
        List<Catalogue> catalogues = catalogueService.findCataloguesByLocationId(locationId);
        return jsonResult(ok(Json.toJson(catalogues)));
    }


}
