package com.example.utils;

import org.springframework.stereotype.Component;

/**
 * GlobalUtils class provides global variables required for HttpHeader, Zeebe abd taskList apis.
 * This class contains static is data required for HttpHeader, Zeebe abd taskList apis.
 * Please see the {@link com.example.utils} class for true identity
 * @author Darshan Gohil
 */
@Component
public class GlobalUtils {

    /**
     * GlobalUtilHeaders provides all required data for HttpHeaders.
     *
     */
    public static class GlobalUtilHeaders {
        public static final String CONTENT_TYPE="Content-Type";
        public static final String ACCEPT="Accept";
        public static final String AUTHORIZATION="Authorization";
        public static final String APPLICATIONJSON="application/json";
    }

    /**
     * GlobalTasklistUtils provides all required data for TaskList User tasks.
     *
     */
    public static class GlobalTasklistUtils {
        public static final String TASKSEARCHURL="http://localhost:8082/v1/tasks/search";
        public static final String PROCESSINSTANCEID= "Process_1jejpyd";
    }
    }

