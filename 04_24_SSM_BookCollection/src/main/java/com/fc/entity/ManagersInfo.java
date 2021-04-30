package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagersInfo implements Serializable {
    //管理员编号
    private Integer managersId;
    //管理员姓名
    private String managersName;

}
