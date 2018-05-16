package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ding
 * @create 2018/5/16
 * @description :直播数据通用数据层
 */
@Repository
public interface LiveResultDao extends JpaRepository<LiveResult,Integer> {
}
