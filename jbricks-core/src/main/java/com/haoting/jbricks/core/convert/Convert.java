package com.haoting.jbricks.core.convert;

import java.util.List;

/**
 * Created by Think on 2016/12/3.
 */
public interface Convert<POJO, VO>{


    /**
     * VO转化
     * @param pojo
     * @return
     */
    VO convert(POJO pojo);

    /**
     * VOList 转化
     * @param pojoList
     * @return
     */
    List<VO> convert(List<POJO> pojoList);
}
