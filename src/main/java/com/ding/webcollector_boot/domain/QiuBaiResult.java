package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-21:19
 */
@Entity
@Data
@Table(name = "qiubai_result")
@AllArgsConstructor
@NoArgsConstructor
public class QiuBaiResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;
    @Column(name = "hot")
    private String hot;
    @Column(name = "picUrl")
    private String picUrl;
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @Column(name = "lastupDate")
    private LocalDateTime lastUpDate;
}
