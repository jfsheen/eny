package cc.aisc.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sjf on 15-11-11.
 */

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebApplication.class);
    }*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication().run(WebApplication.class, args);
    }


}


/*
@SpringBootApplication
public class XdApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdApplication.class, args);
    }
}*/
