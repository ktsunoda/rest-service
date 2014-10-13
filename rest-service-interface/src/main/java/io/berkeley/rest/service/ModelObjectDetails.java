package io.berkeley.rest.service;


import com.google.common.base.Strings;
import io.berkeley.rest.service.model.ModelObject;
import io.berkeley.serialization.BaseDetails;
import io.berkeley.serialization.Model;

import java.util.Date;


@SuppressWarnings("UnusedDeclaration")
public class ModelObjectDetails extends BaseDetails<ModelObjectDetails, String> {

    //------------------------------------------------------------------------------------------------
    // Variables - Private
    //------------------------------------------------------------------------------------------------

    private String id;
    private String name;
    private Date createdDate;
    private Date lastModifiedDate;


    //------------------------------------------------------------------------------------------------
    // Implementations - BaseDetails
    //------------------------------------------------------------------------------------------------

    @Override
    public ModelObjectDetails fromModel(Model<String> model) {
        ModelObject modelObject = (ModelObject) model;

        this.id = modelObject.getId();
        this.name = modelObject.getName();
        this.createdDate = modelObject.getCreatedDate();
        this.lastModifiedDate = modelObject.getLastModifiedDate();

        return this;
    }


    @Override
    public <M extends Model<String>> M toModel(M model) {
        ModelObject modelObject = (ModelObject) model;

        if (!Strings.isNullOrEmpty(this.name)) {
            modelObject.setName(this.name);
        }

        return model;
    }


    //------------------------------------------------------------------------------------------------
    // Methods - Getters/Setters
    //------------------------------------------------------------------------------------------------

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }


    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
