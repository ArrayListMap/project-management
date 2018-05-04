package com.zhichubao.project.core.mapper;

import com.zhichubao.project.model.domain.ProjectManagementDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectManagementDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectManagementDetail record);

    int insertSelective(ProjectManagementDetail record);

    ProjectManagementDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectManagementDetail record);

    int updateByPrimaryKey(ProjectManagementDetail record);
}