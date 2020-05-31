package com.example.activiti.controller;

import cn.hutool.core.io.IoUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

/**
 * @author Pan Weilong
 * @date 2020/5/30 23:22
 * @description: 接口.
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 根据流程定义id查看流程图(xml或者图片)
     **/
    @GetMapping(value = "/getFlowChart")
    public ResponseEntity getFlowChart(String processDefinitionId,String resType) {
        HttpHeaders headers = new HttpHeaders();
        if ("xml".equals(resType)) {
            //xml格式
            headers.setContentType(MediaType.APPLICATION_XML);
        } else {
            //image 图片格式
            headers.setContentType(MediaType.IMAGE_PNG);
        }
        //获取流程定义信息
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId)
                .singleResult();
        String resourceName = "";
        if ("image".equals(resType)) {
            resourceName = processDefinition.getDiagramResourceName();
        } else if ("xml".equals(resType)) {
            resourceName = processDefinition.getResourceName();
        }
        InputStream resourceAsStream = repositoryService
                .getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
        return new ResponseEntity(IoUtil.readBytes(resourceAsStream), headers, HttpStatus.CREATED);
    }
}
