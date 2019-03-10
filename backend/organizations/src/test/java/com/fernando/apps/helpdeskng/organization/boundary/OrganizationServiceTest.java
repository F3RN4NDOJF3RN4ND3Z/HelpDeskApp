package com.fernando.apps.helpdeskng.organization.boundary;

import static io.restassured.RestAssured.when;
import java.net.URL;
import java.util.Optional;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
* OrganizationsServiceTest
 */
@RunWith(Arquillian.class)
public class OrganizationServiceTest {

    @Deployment(testable=false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "organizations.war")
                .addPackages(true, "com.fernando.apps.helpdeskng.organizations")
                .addAsWebInfResource("beans.xml")
                .addAsWebInfResource("web.xml")
                .addAsResource("persistence.xml",
                        "META-INF/persistence.xml");
    }

    @Test
    public void testCreateOrganization(@ArquillianResource URL resource) throws Exception {
        URL apiUrl = new URL(resource, "resources/organizations");
        JsonObject user = Json.createObjectBuilder()
                .add("name", "Preba")
                .build();

        Response initiallyCreated = ClientBuilder.newClient().target(apiUrl.toURI())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user));
        assertThat(initiallyCreated.getStatus(), is(201));

        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
    }
}