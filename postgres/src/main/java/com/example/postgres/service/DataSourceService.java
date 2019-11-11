package com.example.postgres.service;

import com.example.postgres.config.DBContextHolder;
import com.example.postgres.config.DynamicDataSource;
import com.example.postgres.dao.DataSourceMapper;
import com.example.postgres.entity.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceService {
    @Autowired
    DataSourceMapper dataSourceMapper;
    @Autowired
    private DynamicDataSource dynamicDataSource;

    public boolean changeDB(String id) throws Exception{
        //默认切换到主数据源,进行整体资源的查找
        DBContextHolder.clearDataSource();

        List<DataSource> dataSourcesList = dataSourceMapper.findAllDataSource();

        for (DataSource dataSource : dataSourcesList) {
            if (dataSource.getId().equals(id)) {
                System.out.println("需要使用的的数据源已经找到,datasourceId是：" + dataSource.getId());
                //创建数据源连接&检查 若存在则不需重新创建
                dynamicDataSource.createDataSourceWithCheck(dataSource);
                //切换到该数据源
                DBContextHolder.setDataSource(dataSource.getId());
                return true;
            }
        }
        return false;

    }
}
