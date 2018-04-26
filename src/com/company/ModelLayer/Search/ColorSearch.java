package com.company.ModelLayer.Search;

import com.company.ModelLayer.ISock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brain on 26.04.2018.
 */
public class ColorSearch implements ISearch {

    @Override
    public List<ISock> search(Object searchParam, List<ISock> data) {
        String color = (String)searchParam;
        List<ISock> result = new ArrayList<>();
        for (ISock sock: data) {
            if(sock.getColor().indexOf(color)>0)
            {
                result.add(sock);
            }
        }
        return result;
    }
}
