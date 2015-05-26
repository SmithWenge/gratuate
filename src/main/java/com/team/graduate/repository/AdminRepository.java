package com.team.graduate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team.graduate.model.Log;

/**
 * Created by Administrator on 2015/4/1.
 */
public interface AdminRepository {
    public Page<Log> selectWithPage(Pageable pageable);
}
