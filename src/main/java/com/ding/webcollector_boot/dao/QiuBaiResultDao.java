package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.QiuBaiResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-21:26
 */
@Repository
public interface QiuBaiResultDao extends JpaRepository<QiuBaiResult,Integer> {
}
