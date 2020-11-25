package com.demo.test.refresh;

import com.demo.test.config.Config;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class RefreshApplication {
	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(RefreshApplication.class);
		ConfigurableApplicationContext context = application.run(args);
		ConfigurableEnvironment environment=context.getEnvironment();
		StandardEnvironment bootstrapEnvironment = new StandardEnvironment();
		SpringApplicationBuilder builder = new SpringApplicationBuilder()

				.profiles(environment.getActiveProfiles()).bannerMode(Banner.Mode.OFF)
				.environment(bootstrapEnvironment)
				// Don't use the default properties in this builder
				.registerShutdownHook(false).logStartupInfo(false)
				.web(WebApplicationType.NONE);
		builder.sources(Config.class);
		builder.run(args);
	}
}
