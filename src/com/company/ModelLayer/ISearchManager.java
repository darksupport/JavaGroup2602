package com.company.ModelLayer;

import com.company.ModelLayer.ISock;

import java.util.List;

/**
 * Created by Brainacad4 on 10.05.2018.
 */
public interface ISearchManager {
    List<ISock> search(String fieldName, Object searchParam);
}
