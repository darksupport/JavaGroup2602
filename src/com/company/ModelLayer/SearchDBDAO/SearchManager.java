package com.company.ModelLayer.SearchDBDAO;

import com.company.DAOLayer.IDAOSock;
import com.company.ModelLayer.ISearchManager;
import com.company.ModelLayer.ISock;
import com.company.ModelLayer.ISockModel;
import com.company.ModelLayer.SockData;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Brainacad4 on 17.05.2018.
 */
public class SearchManager implements ISearchManager {

    ISockModel model;


    HashMap<String,String> fieldNameTranslate;

    public SearchManager(ISockModel model)
    {
        this.model = model;
        fieldNameTranslate = new HashMap<>();
        initTranslation();
    }

    private void initTranslation()
    {
        fieldNameTranslate.put("Color","color_socks");
        fieldNameTranslate.put("Type","type_socks");
        fieldNameTranslate.put("Size","size_socks");
        fieldNameTranslate.put("Owner","name_owner");
    }

    @Override
    public List<ISock> search(String fieldName, Object searchParam) {
           return model.getSockByCondition(fieldNameTranslate.get(fieldName),"=",searchParam.toString());
    }
}
