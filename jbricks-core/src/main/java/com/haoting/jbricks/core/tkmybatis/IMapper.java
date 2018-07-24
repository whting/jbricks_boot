package com.haoting.jbricks.core.tkmybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by caimiao on 2016/6/30.
 */
public interface IMapper<T> extends Mapper<T>, MySqlMapper<T> {


}
