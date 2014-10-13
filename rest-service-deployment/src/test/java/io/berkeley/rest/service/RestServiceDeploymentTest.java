package io.berkeley.rest.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rest-service-deployment-test-application-context.xml")
public class RestServiceDeploymentTest {

    @SuppressWarnings("UnusedDeclaration")
    @Autowired
    private ApplicationContext applicationContext = null;

    @Test
    public void configurationTest() {
        // Left blank intentionally. At least one test method is required for any test class. Minimally,
        // this class tests the loading of the application context through the @Autowired annotation.
    }
}
