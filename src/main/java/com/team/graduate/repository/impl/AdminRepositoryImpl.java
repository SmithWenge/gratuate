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
import com.team.graduate.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        String sql = "INSERT INTO stu_graduate_info (id, stuName, stuNumber, stuGender, stuBrithday," +
                " stuEnrollment, stuGraduation, stuSpecialty, stuMajorDegreeCertNum," +
                " stuMajorDegree, stuIdentificationNum, stuPublicationDate)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { info.getId(), info.getStuName(), info.getStuNumber(), info.getStuGender(),
                info.getStuBrithday(), info.getStuEnrollment(), info.getStuGraduation(), info.getStuSpecialty(),
                info.getStuMajorDegreeCertNum(), info.getStuMajorDegree(),
                info.getStuIdentificationNum(),  info.getStuPublicationDate() };

        jdbcTemplate.update(sql, args);
    }

    public boolean selectDiff(StuGraduateInfo info) {
        String sql = "SELECT count(1) FROM stu_graduate_info WHERE stuMajorDegreeCertNum = ?";
        Object[] args = { info.getStuMajorDegreeCertNum() };

        return jdbcTemplate.queryForObject(sql, args, Integer.class) > 0 ? true : false;
    }

    public boolean selectDiffImageName(String idNum) {
        String sql = "SELECT count(1) FROM stu_graduate_info WHERE stuIdentificationNum = ?";
        Object[] args = { idNum };

        return jdbcTemplate.queryForObject(sql, args, Integer.class) > 0 ? true : false;
    }

    public StuGraduateInfo selectInfo(String key, String value) {
        String sql = "SELECT id, stuName, stuNumber, stuGender, stuBrithday, stuEnrollment, stuGraduation," +
                " stuSpecialty, stuMajorDegreeCertNum, stuMajorDegree," +
                " stuIdentificationNum, stuPublicationDate FROM stu_graduate_info WHERE " + key + " = ?";
        Object[] args = { value };

        try {
            return jdbcTemplate.queryForObject(sql, args, new StuGraduateInfoRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    public StuGraduateInfo queryByStuId(String stuId) {
        String sql = "SELECT id, stuName, stuNumber, stuGender, stuBrithday, stuEnrollment, stuGraduation," +
                " stuSpecialty, stuMajorDegreeCertNum, stuMajorDegree," +
                " stuIdentificationNum, stuPublicationDate FROM stu_graduate_info WHERE id = ?";
        Object[] args = { stuId };

        return jdbcTemplate.queryForObject(sql, args, new StuGraduateInfoRowMapper());
    }

    public StuGraduateInfo update(StuGraduateInfo info) {
        String sql = "UPDATE stu_graduate_info set stuName = ?, stuNumber = ?, stuGender = ?," +
                " stuBrithday = ?, stuEnrollment = ?, stuGraduation = ?, stuSpecialty = ?," +
                " stuMajorDegreeCertNum = ?, stuMajorDegree = ?," +
                " stuIdentificationNum = ?, stuPublicationDate = ? WHERE id = ?";
        Object[] args = { info.getStuName(), info.getStuNumber(), info.getStuGender(), info.getStuBrithday(),
                info.getStuEnrollment(), info.getStuGraduation(), info.getStuSpecialty(),
                info.getStuMajorDegreeCertNum(), info.getStuMajorDegree(), info.getStuIdentificationNum(),
                info.getStuPublicationDate(), info.getId() };

        int value = jdbcTemplate.update(sql, args);

        if (value == 1) {
            return queryByStuId(info.getId());
        }

        return null;
    }

    public int selectCountTotal() {
        String sql = "SELECT count(1) FROM graduate.stu_graduate_info";
        Object[] args = { };

        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }

    private class AdminRowMapper implements ParameterizedRowMapper<Admin> {

        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {

            Admin admin = new Admin();
            admin.setUsername(rs.getString("username"));

            return admin;
        }
    }

    private class StuGraduateInfoRowMapper implements ParameterizedRowMapper<StuGraduateInfo> {

        public StuGraduateInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            StuGraduateInfo info = new StuGraduateInfo();

            info.setId(rs.getString("id"));
            info.setStuName(rs.getString("stuName"));
            info.setStuNumber(rs.getString("stuNumber"));
            info.setStuGender(rs.getString("stuGender"));
            info.setStuBrithday(rs.getDate("stuBrithday"));
            info.setStuEnrollment(rs.getDate("stuEnrollment"));
            info.setStuGraduation(rs.getDate("stuGraduation"));
            info.setStuSpecialty(rs.getString("stuSpecialty"));
//            info.setStuGraduationCardNum(rs.getString("stuGraduationCardNum"));
            info.setStuMajorDegreeCertNum(rs.getString("stuMajorDegreeCertNum"));
            info.setStuMajorDegree(rs.getString("stuMajorDegree"));
            info.setStuIdentificationNum(rs.getString("stuIdentificationNum"));
            info.setStuPublicationDate(rs.getDate("stuPublicationDate"));

            return info;
        }
    }
}
