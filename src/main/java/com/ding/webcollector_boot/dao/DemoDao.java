package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ding
 * @create 2018/5/16
 * @description :
 */
@Repository
public interface DemoDao extends JpaRepository<LiveResult,Integer> {
}
