package com.ding.webcollector_boot;

import com.ding.webcollector_boot.domain.DouYuResult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ding
 * @create 2018/5/10
 * @description :
 */
public interface CrawlerResultDao extends JpaRepository<DouYuResult,Integer> {
}
