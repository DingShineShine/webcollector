package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Ding
 * @create 2018/5/16
 * @description :
 */
@Table(name = "live_crawler_result")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LiveResult {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "player")
    private String player;
    @Column(name = "title")
    private String title;
    @Column(name="liveStatus")
    private String liveStatus;
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
