package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.DouyuResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @Description
 * @date 2018/05/13-20:36
 */
@Repository
public interface DouyuResultDao extends JpaRepository<DouyuResult,Integer> {
}
