package com.company.ModelLayer.SearchForFileDAO;

import com.company.ModelLayer.ISock;

import java.util.List;

/**
 * Created by Brain on 26.04.2018.
 */
public interface ISearch {
    List<ISock> search(Object searchParam, List<ISock> data);
}
