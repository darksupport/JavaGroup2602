package com.company.DAOLayer;

import com.company.ModelLayer.IOwnerData;

/**
 * Created by Brainacad4 on 14.05.2018.
 */
public interface IDAODBOwner {
    IOwnerData getOwnerById(int id);
}
