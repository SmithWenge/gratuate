package com.team.graduate.repository;

import com.team.graduate.model.Admin;
import com.team.graduate.model.StuGraduateInfo;

public interface AdminRepository {
    public Admin select(Admin admin);
    public void insert(StuGraduateInfo info);
    public boolean selectDiff(StuGraduateInfo info);

    boolean selectDiffImageName(String idNum);
}
