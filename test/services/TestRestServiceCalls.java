package services;

import junit.framework.Assert;
import models.Catalogue;
import models.Location;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yasin on 20/03/16.
 *
 * These tests can only be run when the application is started in localhost
 * TODO Refactor so that the test runs it's own application
 */
public class TestRestServiceCalls {

    private String serviceURI= "http://localhost:9000";
    private Client client;

    private Catalogue productArsenalTv;
    private Catalogue productChelseaTv;
    private Catalogue productLiverpoolTv;

    private Catalogue skyNews;
    private Catalogue skySportsNews;

    public TestRestServiceCalls() {
        this.client = ClientBuilder.newClient();

        productArsenalTv = new Catalogue();
        productArsenalTv.setProduct("Arsenal TV");
        productChelseaTv = new Catalogue();
        productChelseaTv.setProduct("Chelsea TV");
        productLiverpoolTv = new Catalogue();
        productLiverpoolTv.setProduct("Liverpool TV");

        skyNews = new Catalogue();
        skyNews.setProduct("Sky News");
        skySportsNews = new Catalogue();
        skySportsNews.setProduct("Sky Sports News");

    }

    @Test
    public void test_Liverpool_is_returned_for_odd_customer_id() throws IOException {

        Response response = client
                .target(serviceURI)
                .path("location/1")
                .request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .get();

        Location location = response.readEntity(new GenericType<Location>() {});

        response.close();

        Assert.assertTrue(location.getId()==2);
        Assert.assertTrue(location.getName().equals("Liverpool"));
    }

    @Test
    public void test_London_is_returned_for_even_customer_id() throws IOException {

        Response response = client
                .target(serviceURI)
                .path("location/2")
                .request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .get();

        Location location = response.readEntity(new GenericType<Location>() {});

        response.close();

        Assert.assertTrue(location.getId()==1);
        Assert.assertTrue(location.getName().equals("London"));
    }

    @Test
    public void test_CorrectProducts_returned_for_London() throws IOException {

        Response response = client
                .target(serviceURI)
                .path("products/1")
                .request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .get();

        List<Catalogue> products = response.readEntity(new GenericType<List<Catalogue>>() {});
        response.close();

        Set<Catalogue> productsSet = new HashSet<Catalogue>(products);
        Assert.assertTrue(products.size()==4);
        Assert.assertTrue(productsSet.contains(productArsenalTv));
        Assert.assertTrue(productsSet.contains(productChelseaTv));
        Assert.assertTrue(productsSet.contains(skyNews));
        Assert.assertTrue(productsSet.contains(skySportsNews));
        Assert.assertFalse(productsSet.contains(productLiverpoolTv));


    }

    @Test
    public void test_CorrectProducts_returned_for_Liverpool() throws IOException {

        Response response = client
                .target(serviceURI)
                .path("products/2")
                .request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .get();

        List<Catalogue> products = response.readEntity(new GenericType<List<Catalogue>>() {});
        response.close();

        Set<Catalogue> productsSet = new HashSet<Catalogue>(products);

        Assert.assertTrue(products.size()==3);
        Assert.assertTrue(productsSet.contains(productLiverpoolTv));
        Assert.assertTrue(productsSet.contains(skyNews));
        Assert.assertTrue(productsSet.contains(skySportsNews));
        Assert.assertFalse(productsSet.contains(productArsenalTv));
        Assert.assertFalse(productsSet.contains(productChelseaTv));

    }


}
