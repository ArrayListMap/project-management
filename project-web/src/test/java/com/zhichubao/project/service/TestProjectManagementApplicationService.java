package com.zhichubao.project.service;

import com.zhichubao.project.ProjectApp;
import com.zhichubao.project.api.ProjectManagementApplicationService;
import com.zhichubao.project.model.domain.ProjectManagementApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-05-03 18:56
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectApp.class)
public class TestProjectManagementApplicationService {
    @Autowired
    private ProjectManagementApplicationService projectManagementApplicationService;
    @Test
    public void testInsert(){
        ProjectManagementApplication projectManagementApplication = new ProjectManagementApplication();
        projectManagementApplication.setApplicationCode("123");
        projectManagementApplication.setApplicationName("123");
        projectManagementApplication.setRemark("123");
        projectManagementApplication.setTenantId(1L);

        projectManagementApplicationService.insert(projectManagementApplication);

    }

    @Test
    public void testSelect(){
        ProjectManagementApplication projectManagementApplication = projectManagementApplicationService.selectByPrimaryKey(1L);
        System.out.println(Objects.toString(projectManagementApplication));
    }
}
