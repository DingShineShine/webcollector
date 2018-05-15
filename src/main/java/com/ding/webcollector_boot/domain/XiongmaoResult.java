package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ding
 * @Description
 * @date 2018/05/15-21:30
 */
@Table(name = "xiongmao_result")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class XiongmaoResult {
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
    @Column(name = "liveUrl")
    private String liveUrl;
}
