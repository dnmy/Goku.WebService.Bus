package com.goku.webservice.mapper;

import com.goku.webservice.datahelper.DataSource;
import org.apache.ibatis.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017-11-03.
 */
@Repository
public interface VelocityMapper {

    @Select("${sqlstr}")
    Map<String, String> SelectOne(@Param("sqlstr") String sqlstr);

    @Select("${sqlstr}")
    List<Map<String, String>> SelectList(@Param("sqlstr") String sqlstr);

    @Select("${sqlstr}")
    List<Map<String,String>> SelectProc(@Param("sqlstr") String sqlstr);

    @Insert("${sqlstr}")
    void insert(@Param("sqlstr") String sqlstr);

    @Update("${sqlstr}")
    void update(@Param("sqlstr") String sqlstr);

    @Delete("${sqlstr}")
    void delete(@Param("sqlstr") String sqlstr);

}
