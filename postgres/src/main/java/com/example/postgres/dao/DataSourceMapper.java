package com.example.postgres.dao;


import com.example.postgres.entity.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataSourceMapper {
    @Select("SELECT id,driver_name,password,url,username,database_type FROM conn_info")
    List<DataSource> findAllDataSource();
}
