package com.team.graduate.repository.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.team.graduate.common.util.MD5Util;
import com.team.graduate.repository.StuGraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.team.graduate.model.StuGraduateInfo;

@Repository
public class StuGraduateRepositoryImpl implements StuGraduateRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<StuGraduateInfo> selectNameAndIdentificationNum(StuGraduateInfo stu) {
		String sql = "select stuName,stuGraduationCardNum, stuMajorDegree, stuMajorDegreeCertNum, stuSpecialty, stuIdentificationNum from stu_graduate_info where stuName=? and stuIdentificationNum=?";
		Object[] args = { stu.getStuName(), stu.getStuIdentificationNum() };

		try {
			return jdbcTemplate.query(sql, args, new StuRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public StuGraduateInfo authNameAndDegreeNumAndPubDate(StuGraduateInfo stu) {
		String sql = "select stuName, stuGender, stuBrithday, stuSpecialty, stuMajorDegree, stuMajorDegreeCertNum, stuPublicationDate, stuIdentificationNum from stu_graduate_info where stuName=? and stuMajorDegreeCertNum=? and stuPublicationDate=?";
		Object[] args = { stu.getStuName(), stu.getStuMajorDegreeCertNum(), stu.getStuPublicationDate() };
		try {
			return jdbcTemplate.queryForObject(sql, args, new AuthStuRowMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public List<Date> getDiffDate() {
		String sql = "SELECT distinct(stuPublicationDate) FROM graduate.stu_graduate_info order by stuPublicationDate desc";

		return jdbcTemplate.queryForList(sql, Date.class);
	}

	public int selectKV(String key, String value) {
		String sql = "SELECT count(1) FROM stu_graduate_info WHERE " + key + " = ?";
		Object[] args = { value };

		return jdbcTemplate.queryForObject(sql, args, Integer.class);
	}

	private class StuRowMapper implements RowMapper<StuGraduateInfo> {
		public StuGraduateInfo mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			StuGraduateInfo stu = new StuGraduateInfo();

			stu.setStuName(rs.getString("stuName"));
			stu.setStuIdentificationNum(rs.getString("stuIdentificationNum"));
			stu.setStuGraduationCardNum(rs.getString("stuGraduationCardNum"));
			stu.setStuMajorDegree(rs.getString("stuMajorDegree"));
			stu.setStuMajorDegreeCertNum(rs.getString("stuMajorDegreeCertNum"));
			stu.setStuSpecialty(rs.getString("stuSpecialty"));
			
			return stu;
		}
	}

	private class AuthStuRowMapper implements RowMapper<StuGraduateInfo> {
		public StuGraduateInfo mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			StuGraduateInfo stu = new StuGraduateInfo();

			stu.setStuName(rs.getString("stuName"));
			stu.setStuMajorDegree(rs.getString("stuMajorDegree"));
			stu.setStuMajorDegreeCertNum(rs.getString("stuMajorDegreeCertNum"));
			stu.setStuPublicationDate(rs.getDate("stuPublicationDate"));
			stu.setStuGender(rs.getString("stuGender"));
			stu.setStuBrithday(rs.getDate("stuBrithday"));
			stu.setStuSpecialty(rs.getString("stuSpecialty"));
			stu.setStuPublicationDate(rs.getDate("stuPublicationDate"));
//			md5
			String picturePath = MD5Util.getMD5String(rs.getString("stuIdentificationNum"));
			if (null == picturePath) picturePath = "default";

			stu.setStuIdentificationNum(picturePath);

			return stu;
		}
	}
}
