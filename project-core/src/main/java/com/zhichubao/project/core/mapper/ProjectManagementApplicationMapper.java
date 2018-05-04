package com.zhichubao.project.core.mapper;

import com.zhichubao.project.model.domain.ProjectManagementApplication;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectManagementApplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectManagementApplication record);

    int insertSelective(ProjectManagementApplication record);

    ProjectManagementApplication selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectManagementApplication record);

    int updateByPrimaryKey(ProjectManagementApplication record);
}