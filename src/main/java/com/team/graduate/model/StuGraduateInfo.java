package com.team.graduate.model;

import java.sql.Date;

public class StuGraduateInfo {
	private String id;
	private String stuName;		//学生姓名
	private String stuEnName;	//学生英文姓名
	private String stuNumber;	//学号
	private String stuGender;	//学生性别
	private Date stuBrithday;	//出生年月日
	private Date stuEnrollment;	//入学时间
	private Date stuGraduation;	//毕业时间
	private String stuAcademy;	//学院
	private String stuSpecialty;//专业
	private String stuSpecialtyMajor;	//专业方向
	private String stuClass;	//班级
	private String stuPicture;	//图片
//	private String stuGraduationCardNum;	//毕业证编号
	private String stuMajorDegreeCertNum;	//学位证编号
	private String stuMajorDegree;			//学位
	private String stuDoubleMajorDegree;	//第二学位
	private String stuDoubleMajorDegreeNum;	//第二学位证编号
	private String stuMinorDegree;			//辅修学位
	private String stuMinorDegreeNum;		//辅修学位整编号
	private String stuIdentificationNum;	//身份证编号
	private String stuPostgraduateNum;		//肄业证编号
	private String stuCompletionNum;		//结业证编号
	private String stuLeaveType;			//离校类型
	private Date stuPublicationDate;        //发证日期

	public StuGraduateInfo(String stuName) {
		this.stuName =stuName;
	}
	public StuGraduateInfo() {
		
	}

	public Date getStuPublicationDate() {
		return stuPublicationDate;
	}
	public void setStuPublicationDate(Date stuPublicationDate) {
		this.stuPublicationDate = stuPublicationDate;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEnName() {
		return stuEnName;
	}
	public void setStuEnName(String stuEnName) {
		this.stuEnName = stuEnName;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public String getStuGender() {
		return stuGender;
	}
	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}
	public Date getStuBrithday() {
		return stuBrithday;
	}
	public void setStuBrithday(Date stuBrithday) {
		this.stuBrithday = stuBrithday;
	}
	public Date getStuEnrollment() {
		return stuEnrollment;
	}
	public void setStuEnrollment(Date stuEnrollment) {
		this.stuEnrollment = stuEnrollment;
	}
	public Date getStuGraduation() {
		return stuGraduation;
	}
	public void setStuGraduation(Date stuGraduation) {
		this.stuGraduation = stuGraduation;
	}
	public String getStuAcademy() {
		return stuAcademy;
	}
	public void setStuAcademy(String stuAcademy) {
		this.stuAcademy = stuAcademy;
	}
	public String getStuSpecialty() {
		return stuSpecialty;
	}
	public void setStuSpecialty(String stuSpecialty) {
		this.stuSpecialty = stuSpecialty;
	}
	public String getStuSpecialtyMajor() {
		return stuSpecialtyMajor;
	}
	public void setStuSpecialtyMajor(String stuSpecialtyMajor) {
		this.stuSpecialtyMajor = stuSpecialtyMajor;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getStuPicture() {
		return stuPicture;
	}
	public void setStuPicture(String stuPicture) {
		this.stuPicture = stuPicture;
	}
//	public String getStuGraduationCardNum() {
//		return stuGraduationCardNum;
//	}
//	public void setStuGraduationCardNum(String stuGraduationCardNum) {
//		this.stuGraduationCardNum = stuGraduationCardNum;
//	}
	public String getStuMajorDegreeCertNum() {
		return stuMajorDegreeCertNum;
	}
	public void setStuMajorDegreeCertNum(String stuMajorDegreeCertNum) {
		this.stuMajorDegreeCertNum = stuMajorDegreeCertNum;
	}
	public String getStuMajorDegree() {
		return stuMajorDegree;
	}
	public void setStuMajorDegree(String stuMajorDegree) {
		this.stuMajorDegree = stuMajorDegree;
	}
	public String getStuDoubleMajorDegree() {
		return stuDoubleMajorDegree;
	}
	public void setStuDoubleMajorDegree(String stuDoubleMajorDegree) {
		this.stuDoubleMajorDegree = stuDoubleMajorDegree;
	}
	public String getStuDoubleMajorDegreeNum() {
		return stuDoubleMajorDegreeNum;
	}
	public void setStuDoubleMajorDegreeNum(String stuDoubleMajorDegreeNum) {
		this.stuDoubleMajorDegreeNum = stuDoubleMajorDegreeNum;
	}
	public String getStuMinorDegree() {
		return stuMinorDegree;
	}
	public void setStuMinorDegree(String stuMinorDegree) {
		this.stuMinorDegree = stuMinorDegree;
	}
	public String getStuMinorDegreeNum() {
		return stuMinorDegreeNum;
	}
	public void setStuMinorDegreeNum(String stuMinorDegreeNum) {
		this.stuMinorDegreeNum = stuMinorDegreeNum;
	}
	public String getStuIdentificationNum() {
		return stuIdentificationNum;
	}
	public void setStuIdentificationNum(String stuIdentificationNum) {
		this.stuIdentificationNum = stuIdentificationNum;
	}
	public String getStuPostgraduateNum() {
		return stuPostgraduateNum;
	}
	public void setStuPostgraduateNum(String stuPostgraduateNum) {
		this.stuPostgraduateNum = stuPostgraduateNum;
	}
	public String getStuCompletionNum() {
		return stuCompletionNum;
	}
	public void setStuCompletionNum(String stuCompletionNum) {
		this.stuCompletionNum = stuCompletionNum;
	}
	public String getStuLeaveType() {
		return stuLeaveType;
	}
	public void setStuLeaveType(String stuLeaveType) {
		this.stuLeaveType = stuLeaveType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

//	验证方法
	public boolean isLegal() {
		return this.getStuName() != null && this.getStuIdentificationNum().length() == 18;
	}

//	认证验证方法
	public boolean isAuthenticationLegal() {
		return this.getStuName() != null
				&& this.getStuMajorDegreeCertNum().length() == 16
				&& this.getStuPublicationDate() != null;
	}

	public boolean isLegalImportData() {
		return this.getStuMajorDegree() != null
				&& this.getStuSpecialty() != null && this.getStuName() != null
				&& this.getStuIdentificationNum().length() == 18 && this.getStuMajorDegreeCertNum().length() == 16
				&& this.getStuBrithday() != null && this.getStuGender() != null
				&& this.getStuPublicationDate() != null;
	}
}
