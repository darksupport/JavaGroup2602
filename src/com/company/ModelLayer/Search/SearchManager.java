package com.company.ModelLayer.Search;

import com.company.ModelLayer.ISock;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Brain on 26.04.2018.
 */
public class SearchManager {

    HashMap<String,ISearch> serachTable;
    List<ISock> data;
    public SearchManager(List<ISock> data)
    {
        this.data = data;
        serachTable = new HashMap<>();
        serachTable.put("Color",new ColorSearch());
        serachTable.put("Size",new SizeSearch());
    }

    public List<ISock> search(String fieldName, Object searchParam)
    {
      ISearch serchObject = serachTable.get(fieldName);
      return serchObject.search(searchParam,this.data);
    }

}
