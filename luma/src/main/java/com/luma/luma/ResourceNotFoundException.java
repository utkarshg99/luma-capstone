package com.luma.luma;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    String fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue)  {
        super(String.format("%s not found with this %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
