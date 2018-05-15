package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.XiongmaoResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @Description
 * @date 2018/05/15-20:31
 */
@Repository
public interface XiongMaoResultDao extends JpaRepository<XiongmaoResult,Integer> {
}
