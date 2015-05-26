package com.team.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.graduate.dao.FileDaoImpl;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDaoImpl impl;

	public void importExcel(List<StuGraduateInfo> list) {
		impl.insertBatchByExcel(list);
	}

}
