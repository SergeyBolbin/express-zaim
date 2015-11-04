package com.soulware.ez.impl.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Base converter from/to Entities and Data transfer objects
 * Created by bolbin on 31.10.2015.
 */
public abstract class AbstractConverter <E, T> {

    /**
     * Convert single Entity to Transfer Object
     * @param entity entity to convert
     * @return transfer obj
     */
    public abstract T convertEntity(E entity);

    /**
     * Convert List of Entities to Transfer objects
     * @param entityList list of Entities to convert
     * @return list of transfer obj
     */
    public List<T> convertEntityList(List<E> entityList) {
        List<T> result = new ArrayList<T>();
        for(E entity : entityList) {
            result.add(convertEntity(entity));
        }
        return result;
    }
}
