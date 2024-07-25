package com.example.POJO;

import lombok.Getter;
import lombok.Setter;

public class BearerTokenGeneratorDetails {

    public static class BearerTokenGeneratorResponse {

        @Getter
        @Setter
        private String accessToken;

		public String getAccessToken() {
			return accessToken;
		}

		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

    }

}