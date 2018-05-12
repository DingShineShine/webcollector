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
@Table(name = "crawler_result_page")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerResultPage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "page_url")
    private String pageUrl;
    @Column(name = "viewer_number")
    private String viewerNumber;
}
