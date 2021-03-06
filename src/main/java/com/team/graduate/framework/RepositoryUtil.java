package com.team.graduate.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/4/2.
 */
@Repository
public class RepositoryUtil<T> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RepositoryUtil(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<T> select4Page(String sql, Pageable pageable, Object[] args, ParameterizedRowMapper<T> rowMapper) {
        String countSql = buildCountSql(sql);
        int maxCount = queryMaxCount(countSql, args);
        String pageSql = buildPageSql(sql, pageable);

        List<T> list = jdbcTemplate.query(pageSql, args, rowMapper);

        Page<T> result = new PageImpl<T>(list, pageable, maxCount);

        return result;
    }

    private String buildPageSql(String sql, Pageable pageable) {
        StringBuffer buffer = new StringBuffer(sql)
                .append(mysql2PageSql(pageable.getPageNumber(), pageable.getPageSize()));

        return buffer.toString();
    }

    private String mysql2PageSql(int pageNumber, int pageSize) {
        StringBuffer buffer = new StringBuffer(" limit ")
                .append(searchStartPoint(pageNumber, pageSize)).append(",").append(pageSize);

        return buffer.toString();
    }

    private int searchStartPoint(int pageNumber, int pageSize) {
        int start = 0;

        pageNumber = pageNumber < 0 ? 1 : pageNumber;
        pageSize = pageSize < 1 ? 1 : pageSize;

        start = pageNumber * pageSize;

        return start;
    }

    private static final String COUNT_SQL_PREFIX = "SELECT COUNT(1) FROM (";
    private static final String COUNT_SQL_SUFFIX = ") AS countSql";

    private String buildCountSql(String sql) {
        StringBuffer buffer = new StringBuffer(COUNT_SQL_PREFIX)
                .append(sql).append(COUNT_SQL_SUFFIX);

        return buffer.toString();
    }

    private int queryMaxCount(String sql, Object[] args) {
        // TODO replace queryForInt
        return jdbcTemplate.queryForInt(sql, args);
    }
}
