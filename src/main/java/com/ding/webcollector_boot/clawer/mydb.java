package com.ding.webcollector_boot.clawer;

import cn.edu.hfut.dmic.webcollector.crawldb.DBManager;
import cn.edu.hfut.dmic.webcollector.crawldb.Generator;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;

/**
 * @author Ding
 * @create 2018/5/10
 * @description :
 */
public class mydb extends DBManager {
    @Override
    public boolean isDBExists() {
        return false;
    }

    @Override
    public void clear() throws Exception {

    }

    @Override
    public Generator createGenerator() {
        return null;
    }

    @Override
    public void open() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void inject(CrawlDatum crawlDatum, boolean b) throws Exception {

    }

    @Override
    public void inject(CrawlDatums crawlDatums, boolean b) throws Exception {

    }

    @Override
    public void merge() throws Exception {

    }

    @Override
    public void initSegmentWriter() throws Exception {

    }

    @Override
    public void writeFetchSegment(CrawlDatum crawlDatum) throws Exception {

    }

    @Override
    public void writeParseSegment(CrawlDatums crawlDatums) throws Exception {

    }

    @Override
    public void closeSegmentWriter() throws Exception {

    }
}
