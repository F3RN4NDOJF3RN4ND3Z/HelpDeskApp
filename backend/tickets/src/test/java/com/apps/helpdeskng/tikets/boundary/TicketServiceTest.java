package com.apps.helpdeskng.tikets.boundary;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * TicketServiceTest
 */
@RunWith(Arquillian.class)
public class TicketServiceTest {

   

    @Deployment(testable=false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "tickets.war")
                .addPackages(true, "com.fernando.apps.helpdeskng.tickets")
                .addAsWebInfResource("beans.xml")
                .addAsWebInfResource("web.xml")
                .addAsResource("persistence.xml",
                        "META-INF/persistence.xml");
    }

    @Test
    public void testCreateTicket(@ArquillianResource URL resource) throws Exception {
        URL apiUrl = new URL(resource, "resources/tickets");
        JsonObject user = Json.createObjectBuilder()
                .add("description", "Prueba")
                .add("status","OPEN")
                .build();

        Response initiallyCreated = ClientBuilder.newClient().target(apiUrl.toURI())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user));
        assertThat(initiallyCreated.getStatus(), is(201));

        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
    }
}