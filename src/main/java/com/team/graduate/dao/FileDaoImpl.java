package com.team.graduate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team.graduate.model.StuGraduateInfo;

@Repository
public class FileDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBatchByExcel(List<StuGraduateInfo> list) {
		String sql = "INSERT INTO stu_graduate_info (Id, stuName, stuEnName, stuNumber, stuGender, stuBrithday, "
				+ "stuEnrollment, stuGraduation, stuAcademy, stuSpecialty, stuSpecialtyMajor, "
				+ "stuClass, stuPicture, stuGraduationCardNum, stuMajorDegreeCertNum, stuMajorDegree,"
				+ " stuDoubleMajorDegree, stuDoubleMajorDegreeNum, stuMinorDegree, stuMinorDegreeNum, stuIdentificationNum,"
				+ " stuPostgraduateNum, stuCompletionNum, stuLeaveType, stuPublicationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		for (StuGraduateInfo stu : list) {
			Object[] args = {stu.getId(), stu.getStuName(), stu.getStuEnName(), stu.getStuNumber(), stu.getStuGender(), stu.getStuBrithday(),
					stu.getStuEnrollment(), stu.getStuGraduation(), stu.getStuAcademy(), stu.getStuSpecialty(), stu.getStuSpecialtyMajor(), 
					stu.getStuClass(), stu.getStuPicture(), stu.getStuGraduationCardNum(), stu.getStuMajorDegreeCertNum(), stu.getStuMajorDegree(),
					stu.getStuDoubleMajorDegree(), stu.getStuDoubleMajorDegreeNum(), stu.getStuMinorDegree(), stu.getStuMinorDegreeNum(),
					stu.getStuIdentificationNum(), stu.getStuPostgraduateNum(), stu.getStuCompletionNum(), stu.getStuLeaveType(), stu.getStuPublicationDate()};
			try {
				jdbcTemplate.update(sql, args);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
