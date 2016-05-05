/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyork.taxi.service;

import com.newyork.taxi.GreenTrip;
import com.newyork.taxi.ProcessedTaxiTrip;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("com.newyork.taxi.greentrip")
public class GreenTripFacadeREST extends AbstractFacade<GreenTrip> {

    @PersistenceContext(unitName = "TaxiTripServerPU")
    private EntityManager em;

    public GreenTripFacadeREST() {
        super(GreenTrip.class);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ProcessedTaxiTrip findRange(@PathParam("from") String from, @PathParam("to") String to) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date startDate = format.parse(from);
        Date endDate = format.parse(to);
        
        java.sql.Date start = new java.sql.Date(startDate.getTime());
        java.sql.Date end = new java.sql.Date(endDate.getTime());
        
        List<GreenTrip> queryResult = super.findByTimeRange(start, end);
        
        ProcessedTaxiTrip processedTaxiTrip = new ProcessedTaxiTrip(queryResult);

        return processedTaxiTrip;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
