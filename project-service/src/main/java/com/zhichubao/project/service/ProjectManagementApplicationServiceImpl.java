package com.zhichubao.project.service;

import com.zhichubao.project.api.ProjectManagementApplicationService;
import com.zhichubao.project.core.mapper.ProjectManagementApplicationMapper;
import com.zhichubao.project.model.domain.ProjectManagementApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-05-03 18:53
 **/
@Service
public class ProjectManagementApplicationServiceImpl implements ProjectManagementApplicationService{

    @Autowired
    private ProjectManagementApplicationMapper projectManagementApplicationMapper;

    public int deleteByPrimaryKey(Long id) {
        return projectManagementApplicationMapper.deleteByPrimaryKey(id);
    }

    public int insert(ProjectManagementApplication record) {
        return projectManagementApplicationMapper.insert(record);
    }

    public int insertSelective(ProjectManagementApplication record) {
        return projectManagementApplicationMapper.insertSelective(record);
    }

    public ProjectManagementApplication selectByPrimaryKey(Long id) {
        return projectManagementApplicationMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(ProjectManagementApplication record) {
        return projectManagementApplicationMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ProjectManagementApplication record) {
        return projectManagementApplicationMapper.updateByPrimaryKey(record);
    }
}
