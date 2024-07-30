package com.example.utils;

/**
 * BearerTokenUtils class provides bearer token generation related data.
 * This class contains static is data for generate bearer token.
 * Please see the {@link com.example.utils} class for true identity
 * <p>@author Darshan Gohil</p>
 */
public class BearerTokenUtils {
    public static final String GRANT_TYPE = "grant_type";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET_KEY = "client_secret";
    public static final String BEARER="Bearer ";
    public static final String GRANT_TYPEVALUE = "client_credentials";
    public static final String CLIENT_IDVALUE = "tasklist";
    public static final String CLIENT_SECRET_KEYVALUE = "XALaRPl5qwTEItdwCMiPS62nVpKs7dL7";
    public static final String CONTENTTYPEVALUE = "application/x-www-form-urlencoded";
    public static final String BEARERTOKENURL = "http://localhost:18080/auth/realms/camunda-platform/protocol/openid-connect/token";
}
