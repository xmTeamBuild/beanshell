package com.bean.shell.entities;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.tomcat.util.modeler.BaseModelMBean;

import java.io.Serializable;
import java.sql.Date;

@Data
public class PurchaseData extends BaseRowModel {
    //设置excel表头名称
    @ExcelProperty(value = "采购类别",index = 0)
    private Long purchaseType;
    @ExcelProperty(value = "采购品名",index = 1)
    private String purchaseName;
    @ExcelProperty(value = "规格",index = 2)
    private String purchaseUnit;
    @ExcelProperty(value = "单价",index = 3)
    private String purchaseUnitPrice;
    @ExcelProperty(value = "数量",index = 4)
    private String puchaseNumber;
    @ExcelProperty(value = "总价",index = 5)
    private String puchaseTotalPrice;
    @ExcelProperty(value = "下单时间",index = 6)
    private String orderTime;
    @ExcelProperty(value = "备注",index = 7)
    private String remark;


}
