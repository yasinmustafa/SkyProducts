package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import exceptions.LocationNotFoundException;
import services.CustomerLocationService;
import models.Location;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CustomerLocationController extends Controller {

    @Inject
    CustomerLocationService customerLocationService;

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
     * Get one location by id
     *
     * @param Integer id
     *
     * @return Result
     */
    public Result get(Integer customerId) {
        try {
            Location location = customerLocationService.findLocationByCustomerId(customerId);
            return jsonResult(ok(Json.toJson(location)));
        } catch (LocationNotFoundException ex) {
            ObjectNode result = Json.newObject();
            result.put("error", "No location found for custmer ID = " + customerId);
            return jsonResult(notFound(result));
        }

    }


}
