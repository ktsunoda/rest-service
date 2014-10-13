package io.berkeley.rest.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rest-service-impl-test-application-context.xml")
@Transactional(propagation = Propagation.REQUIRED)
public class RestServiceImplementationTest {

    //------------------------------------------------------------------------------------------------
    // Variables - Private
    //------------------------------------------------------------------------------------------------

    @Autowired
    private RestService restService= null;


    //------------------------------------------------------------------------------------------------
    // Tests
    //------------------------------------------------------------------------------------------------

    @Test
    public void crudTest() {
        ModelObjectDetails modelObjectDetails = new ModelObjectDetails();
        modelObjectDetails.setName("Name");

        ModelObjectDetails createdModelObjectDetails = restService.createModelObject(modelObjectDetails);
        assertEquals("Name", createdModelObjectDetails.getName());

        modelObjectDetails = new ModelObjectDetails();
        modelObjectDetails.setName("Updated Name");

        ModelObjectDetails updatedModelObjectDetails = restService.updateModelObject(createdModelObjectDetails.getId(), modelObjectDetails);
        assertEquals("Updated Name", updatedModelObjectDetails.getName());

        restService.deleteModelObject(updatedModelObjectDetails.getId());
        boolean exceptionThrown = false;
        try {
            restService.getModelObject(updatedModelObjectDetails.getId());
        } catch (Exception ignored) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
