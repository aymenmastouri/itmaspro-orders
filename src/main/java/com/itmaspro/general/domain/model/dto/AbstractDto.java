package com.itmaspro.general.domain.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractDto
{

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Integer version;

}
