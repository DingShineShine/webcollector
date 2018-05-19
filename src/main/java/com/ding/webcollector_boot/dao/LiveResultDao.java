package com.ding.webcollector_boot.dao;

import com.ding.webcollector_boot.domain.LiveResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ding
 * @create 2018/5/16
 * @description :直播数据通用数据层
 */
@Repository
public interface LiveResultDao extends JpaRepository<LiveResult,Integer> {
    List<LiveResult> findByHot(String hot);
    List<LiveResult> findByGameType(String gameType);
    @Query("select live from LiveResult live where live.gameType like :gameType and live.hot > :hot")
    List<LiveResult> findByGameTypeAndHot(@Param("gameType") String gameType,@Param("hot") Integer hot);
}
