package com.apps.helpdeskng.tikets.boundary;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fernando.apps.helpdeskng.tickets.entity.Category;
import com.fernando.apps.helpdeskng.tickets.entity.Status;

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

        @Deployment(testable = false)
        public static WebArchive createDeployment() {
                return ShrinkWrap.create(WebArchive.class, "tickets.war")
                                .addPackages(true, "com.fernando.apps.helpdeskng.tickets")
                                .addAsWebInfResource("beans.xml").addAsWebInfResource("web.xml")
                                .addAsResource("persistence.xml", "META-INF/persistence.xml");
        }

        @Test
        public void testCreateTicket(@ArquillianResource URL resource) throws Exception {
                
                LocalDateTime date = LocalDateTime.now();
                String text = date.format(DateTimeFormatter.ISO_DATE_TIME);
        URL apiUrl = new URL(resource, "resources/tickets");
        JsonObject ticket = Json.createObjectBuilder()
                .add("description", "Prueba")
                .add("status",Status.OPEN.toString())
                .add("userId",1L)
	        .add("category",Category.IMPORTANT.toString())
	        .add("organizationId",1L)
	        .add("createdDate",text)
                .build();

        Response initiallyCreated = ClientBuilder.newClient().target(apiUrl.toURI())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(ticket));
        assertThat(initiallyCreated.getStatus(), is(201));

        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
    }
}