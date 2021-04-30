package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTypeTbl implements Serializable {
    private Integer typeId;

    private String typeName;

    private Integer toborrowDays;

    private List<BookTbl> list;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getToborrowDays() {
        return toborrowDays;
    }

    public void setToborrowDays(Integer toborrowDays) {
        this.toborrowDays = toborrowDays;
    }
}