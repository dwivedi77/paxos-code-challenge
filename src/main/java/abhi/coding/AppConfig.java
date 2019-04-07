package abhi.coding;

import abhi.coding.ch1.util.HashDigestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("abhi.coding")
public class AppConfig {

    @Bean(name = "digesterUtil")
    public HashDigestUtil getDigestUtil(){
        return HashDigestUtil.getInstance();
    }
}