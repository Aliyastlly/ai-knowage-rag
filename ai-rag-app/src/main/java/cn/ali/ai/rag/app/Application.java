package cn.ali.ai.rag.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Configurable
@ComponentScan(basePackages = {"cn.ali.ai.rag"}) // 确保包含trigger包
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
