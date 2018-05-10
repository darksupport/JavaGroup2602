package com.company.ModelLayer.SearchForFileDAO;

import com.company.ModelLayer.ISock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brain on 26.04.2018.
 */
public class SizeSearch implements ISearch {
    @Override
    public List<ISock> search(Object searchParam, List<ISock> data) {
        Integer size = Integer.parseInt((String)searchParam);
        List<ISock> result = new ArrayList<>();
        for (ISock sock: data) {
            if(sock.getSize() == size)
            {
                result.add(sock);
            }
        }
        return result;
    }
}
