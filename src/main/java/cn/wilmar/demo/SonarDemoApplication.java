package cn.wilmar.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinguowei
 */
@MapperScan("cn.wilmar.demo.mapper")
@RestController
@SpringBootApplication
public class SonarDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonarDemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

}
