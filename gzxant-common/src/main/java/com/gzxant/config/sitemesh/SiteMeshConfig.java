package com.gzxant.config.sitemesh;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "sitemesh")  // 配置文件中的前缀
public class SiteMeshConfig {

	/** 需要装饰的访问路径 */
    private String contentPath/*="/**,/404.html"*/;

    /** 装饰器页面路径 */
    private String decoratorPath/*="/layouts"*/;

    /** 不需要装饰的访问路径,多个之间用英文逗号分隔 */
    private String excludedPaths;

	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getDecoratorPath() {
		return decoratorPath;
	}

	public void setDecoratorPath(String decoratorPath) {
		this.decoratorPath = decoratorPath;
	}

	public String getExcludedPaths() {
		return excludedPaths;
	}

	public void setExcludedPaths(String excludedPaths) {
		this.excludedPaths = excludedPaths;
	}
}
