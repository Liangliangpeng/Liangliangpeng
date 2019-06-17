package com.operatormanager.pagination ; 

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false )
public class Condition implements Serializable {
   
	private static final long serialVersionUID = 3726647076920014670L;
	
    private String field ;
    
    private Object value ;

    public Condition(String field, Object value) {
        this.field = field;
        this.value = value;
    }

}