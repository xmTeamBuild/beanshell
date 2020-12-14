package com.bean.shell.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysAttrValueVO implements Serializable {

    private static final long serialVersionUID = -6278758925708487356L;

    private String attrValue;

    private String attrName;

    private String attrSpecCode;

    private Long attrSpecId;

    private String attrDesc;
}
