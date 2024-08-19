package induckmoms.server.ai.claude.config;

import induckmoms.server.ai.claude.util.ClaudeRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class AiConfig {
    @Value("${claude.endpoint}")
    private String claudeApiUrl;

    @Value("${claude.api.key}")
    private String claudeApiKey;

    @Value("${claude.anthropic.version}")
    private String claudeAnthropicVersion;


    @Bean
    public RestClient claudeRestClient() {
        return RestClient.builder()
                .baseUrl(claudeApiUrl)
                .defaultHeader("x-api-key", claudeApiKey)
                .defaultHeader("anthropic-version", claudeAnthropicVersion)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public ClaudeRequestUtil claudeRequestUtil() {
        return new ClaudeRequestUtil();
    }

}
