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

    /**
     * 根绝热度查找游戏
     * @param hot
     * @return
     */
    @Query(value = "select live from LiveResult live where live.hot > :hot order by live.hot")
    List<LiveResult> findByHot(@Param("hot") Integer hot);

    /**
     * 根据游戏类型查询,按照hot降序列出所有直播间
     * @param gameType
     * @return
     */
    @Query("select live from LiveResult live where live.gameType like :gameType and live.picUrl is not null order by live.hot desc")
    List<LiveResult> findAllByGameType(@Param("gameType") String gameType);

    /**
     * 更具游戏类别查询热度大于x的游戏
     * @param gameType
     * @param hot
     * @return
     */
    @Query("select live from LiveResult live where live.gameType like :gameType and live.hot > :hot order by live.hot desc")
    List<LiveResult> findByGameTypeAndHot(@Param("gameType") String gameType,@Param("hot") Integer hot);

    /**
     * 根据直播状态查找所有游戏
     * @param liveStatus
     * @return
     */
    @Query("select live from LiveResult live where live.liveStatus = :liveStatus")
    List<LiveResult> findByLiveStatus(@Param("liveStatus") String liveStatus);


    /**
     * 查询直播数大于x的游戏类别,降序排序
     * @param number
     * @return
     */
    @Query(value = "select t.game_type from (select count(1) as number,game_type from live_crawler_result GROUP BY game_type ORDER BY number desc limit :number) as t;",nativeQuery = true)
    List<String> findGameTypeList(@Param("number") Integer number);

    LiveResult findByLiveUrl(String liveUrl);

}
