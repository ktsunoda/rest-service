package io.berkeley.rest.service.model;


import io.berkeley.rest.service.model.dao.ModelObjectDAO;
import org.iternine.jeppetto.dao.NoSuchItemException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rest-service-model-test-application-context.xml")
@Transactional(propagation = Propagation.REQUIRED)
public class ModelObjectTest {

    //------------------------------------------------------------------------------------------------
    // Variables - Private
    //------------------------------------------------------------------------------------------------

    @Autowired
    private ModelObjectDAO modelObjectDAO = null;


    //------------------------------------------------------------------------------------------------
    // Tests
    //------------------------------------------------------------------------------------------------

    @Test
    public void crudTest() {
        ModelObject modelObject = new ModelObject();
        modelObject.setName("Name");
        modelObjectDAO.save(modelObject);
        assertNotNull(modelObject.getId());
        assertEquals("Name", modelObject.getName());
        assertNotNull(modelObject.getCreatedDate());
        assertNotNull(modelObject.getLastModifiedDate());

        ModelObject storedModelObject = modelObjectDAO.findById(modelObject.getId());
        assertEquals(modelObject.getId(), storedModelObject.getId());
        assertEquals(modelObject.getName(), storedModelObject.getName());
        assertEquals(modelObject.getCreatedDate(), storedModelObject.getCreatedDate());
        assertEquals(modelObject.getLastModifiedDate(), storedModelObject.getLastModifiedDate());

        modelObject.setName("Updated Name");
        modelObjectDAO.save(modelObject);
        assertEquals("Updated Name", modelObjectDAO.findById(modelObject.getId()).getName());

        modelObjectDAO.delete(modelObject);
        boolean exceptionThrown = false;
        try {
            modelObjectDAO.findById(modelObject.getId());
        } catch (NoSuchItemException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
