package com.ding.webcollector_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "player")
    private String player;
    @Column(name = "title")
    private String title;
    @Column(name="liveStatus")
    private String liveStatus;
    @Column(name = "hot")
    private Double hot;
    @Column(name = "gameType")
    private String gameType;
    @Column(name = "keyWord")
    private String keyWord;
    @Column(name = "picUrl")
    private String picUrl;
    @Id
    @Column(name = "liveUrl")
    private String liveUrl;
    @Column(name = "lastUpdate")
    private LocalDateTime updateTime;
    @Column(name = "numberStr")
    private String numberStr;
}
