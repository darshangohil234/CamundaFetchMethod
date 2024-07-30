package com.example.service;

import com.example.configuration.HeaderConfig;
import com.example.domain.GenericResponseData;
import io.camunda.zeebe.client.ZeebeClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

public class TaskListServiceImplTest {

    Object jsonString =
            "{\"stringValue\":\"a\"," +
            "\"stringValue2\":\"something\"}";

  private final ZeebeClient zeebeClient;
    private final HeaderConfig headerConfig;

    public TaskListServiceImplTest(ZeebeClient zeebeClient, HeaderConfig headerConfig) {
        this.zeebeClient = zeebeClient;
        this.headerConfig = headerConfig;
    }

   // @Test
    //public void getAllTask() throws IOException {
      //  TaskListServiceImpl taskListServiceImpl = new TaskListServiceImpl(zeebeClient, headerConfig);
       // GenericResponseData<List<Object>> result = taskListServiceImpl.getAllTask(jsonString);
        //Assertions.assertEquals(jsonString, result);
    //}

    //@Test
  //  void start() throws IOException {
       // TaskListServiceImpl taskListServiceImpl = new TaskListServiceImpl(zeebeClient, headerConfig);
        //GenericResponseData<List<Object>> result = taskListServiceImpl.start(jsonString);
    //}
}