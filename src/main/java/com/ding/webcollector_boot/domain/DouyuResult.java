package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Ding
 * @create 2018/5/10
 * @description :
 */
@Table(name = "douyu_result")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DouyuResult {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "player")
    private String player;
    @Column(name = "title")
    private String title;
    @Column(name = "hot")
    private String hot;
    @Column(name = "gameType")
    private String gameType;
    @Column(name = "keyWord")
    private String keyWord;
    @Column(name = "picUrl")
    private String picUrl;

}
