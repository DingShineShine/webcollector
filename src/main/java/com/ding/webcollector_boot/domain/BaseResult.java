package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-20:38
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "lastupDate")
    private Date lastUpDate;

}
