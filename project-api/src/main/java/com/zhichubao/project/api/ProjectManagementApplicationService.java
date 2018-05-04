package com.zhichubao.project.api;

import com.zhichubao.project.model.domain.ProjectManagementApplication;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-05-03 18:54
 **/
public interface ProjectManagementApplicationService {

    int deleteByPrimaryKey(Long id);

    int insert(ProjectManagementApplication record);

    int insertSelective(ProjectManagementApplication record);

    ProjectManagementApplication selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectManagementApplication record);

    int updateByPrimaryKey(ProjectManagementApplication record);

}
