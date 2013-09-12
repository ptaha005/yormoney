package com.codexsoft.yormoney.util;

import com.codexsoft.yormoney.domain.DomainObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Iterator;

public class ResultToJSON {
    public static void trasition(DomainObject dobject, BindingResult result){
        for (FieldError fe : result.getFieldErrors())
            dobject.getJsonValues().put(fe.getField(), fe.getDefaultMessage());
    }
}
