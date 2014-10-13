package io.berkeley.rest.service;


import io.berkeley.rest.service.model.ModelObject;
import io.berkeley.rest.service.model.dao.ModelObjectDAO;

import javax.annotation.Resource;
import java.util.TimeZone;


public class RestServiceImplementation
        implements RestService {

    //------------------------------------------------------------------------------------------------
    // Variables - Private
    //------------------------------------------------------------------------------------------------

    @Resource
    private ModelObjectDAO modelObjectDAO = null;


    //------------------------------------------------------------------------------------------------
    // Constructors
    //------------------------------------------------------------------------------------------------

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }


    //------------------------------------------------------------------------------------------------
    // Implementations - RestService
    //------------------------------------------------------------------------------------------------

    @Override
    public ModelObjectDetails createModelObject(ModelObjectDetails modelObjectDetails) {
        ModelObject modelObject = modelObjectDetails.toModel(new ModelObject());
        modelObjectDAO.save(modelObject);

        return modelObjectDetails.fromModel(modelObject);
    }


    @Override
    public ModelObjectDetails getModelObject(String id) {
        return new ModelObjectDetails().fromModel(modelObjectDAO.findById(id));
    }


    @Override
    public ModelObjectDetails updateModelObject(String id, ModelObjectDetails modelObjectDetails) {
        ModelObject modelObject = modelObjectDAO.findById(id);
        modelObject = modelObjectDetails.toModel(modelObject);
        modelObjectDAO.save(modelObject);

        return modelObjectDetails.fromModel(modelObject);
    }


    @Override
    public void deleteModelObject(String id) {
        modelObjectDAO.deleteById(id);
    }
}
