package com.lanou.sm.admin.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
public class GetFieldsErrors {
    public static String getFieldsErrors(BindingResult result, String fieldName){
        if (result.hasFieldErrors(fieldName)){
            StringBuilder sb = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors(fieldName);
            for (FieldError error : errors) {
                sb.append(error.getDefaultMessage()).append("<br/>");
            }
            return sb.toString();
        }
        return null;
    }
}
