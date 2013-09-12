package com.codexsoft.yormoney.dao;

import com.codexsoft.yormoney.util.datatables.*;

import java.util.List;
import java.util.Map;

public interface DaoInterface<T> {

    public void merge(T item);

    public void saveOrUpdate (T item);

    public T read (Long id);

    public void delete (T item);

    public List<T> list();

    public List<T> sortedList(int first, int count, String orderField, String orderDirection);

    public Long size();

    public Long size(Map<String, Object> criterias);

    public void evict(T item);

    public DatatablesStructure<T> getDatatablesListByParams(JQueryDataTableParamModel<T> param, Map<String, Object> criterias, String[] colsPosition );

    public DatatablesStructure<T> getDatatablesListByData(List<T> resultList, JQueryDataTableParamModel<T> param);

    public T getByParams(Map<String, Object> params);

    public List<T> getListByParams(Map<String, Object> params);

    public Long getListCountByParams(Map<String, Object> params);
}
