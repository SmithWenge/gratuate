package com.team.graduate.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.graduate.model.Admin;
import com.team.graduate.model.StuGraduateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.team.graduate.framework.RepositoryUtil;
import com.team.graduate.model.Log;
import com.team.graduate.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RepositoryUtil<Log> repository;

    public Page<Log> selectWithPage(Pageable pageable) {
        String sql = "SELECT logId, createDate, thread, `level`, class, message FROM stu_graduate_log4j";
        Object[] args = {};
        Page<Log> page = repository.select4Page(sql, pageable, args, new LogRowMapperParam());

        return page;
    }

    public Admin select(Admin admin) {
        String sql = "SELECT username FROM stu_graduate_loginuser WHERE username = ? AND password = ?";
        Object[] args = { admin.getUsername(), admin.getPassword() };

        try {
            return  jdbcTemplate.queryForObject(sql, args, new AdminRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    public void insert(StuGraduateInfo info) {
        String sql = "INSERT INTO stu_graduate_info (id, stuName, stuEnName, stuNumber, stuGender, stuBrithday," +
                " stuEnrollment, stuGraduation, stuAcademy, stuSpecialty, stuSpecialtyMajor, stuClass, stuPicture," +
                " stuGraduationCardNum, stuMajorDegreeCertNum, stuMajorDegree, stuDoubleMajorDegree, stuDoubleMajorDegreeNum, " +
                "stuMinorDegree, stuMinorDegreeNum, stuIdentificationNum, stuPostgraduateNum, stuCompletionNum," +
                " stuLeaveType, stuPublicationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { info.getId(), info.getStuName(), info.getStuEnName(), info.getStuNumber(), info.getStuGender(),
                info.getStuBrithday(), info.getStuEnrollment(), info.getStuGraduation(), info.getStuAcademy(),
                info.getStuSpecialty(), info.getStuSpecialtyMajor(), info.getStuClass(), info.getStuPicture(),
                info.getStuGraduationCardNum(), info.getStuMajorDegreeCertNum(), info.getStuMajorDegree(), info.getStuDoubleMajorDegree(),
                info.getStuDoubleMajorDegreeNum(), info.getStuMinorDegree(), info.getStuMinorDegreeNum(),
                info.getStuIdentificationNum(), info.getStuPostgraduateNum(), info.getStuCompletionNum(),
                info.getStuLeaveType(), info.getStuPublicationDate() };

        jdbcTemplate.update(sql, args);
    }

    private class LogRowMapperParam implements ParameterizedRowMapper<Log> {

        public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
            Log log = new Log();
            log.setLogId(rs.getInt("logId"));
			log.setClazz(rs.getString("class"));
			log.setCreateDate(rs.getDate("createDate"));
			log.setLevel(rs.getString("level"));
			log.setMessage(rs.getString("message"));
			log.setThread(rs.getString("thread"));
            return log;
        }
    }

    private class AdminRowMapper implements ParameterizedRowMapper<Admin> {

        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {

            Admin admin = new Admin();
            admin.setUsername(rs.getString("username"));

            return admin;
        }
    }
}
