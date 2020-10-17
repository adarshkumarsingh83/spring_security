package com.espark.adarsh.bean;

import lombok.Data;
import java.io.Serializable;

@Data
public class ApiResponseBean<T> implements Serializable {

    private T data;
    private String message;
}
