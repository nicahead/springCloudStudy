package me.nic.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Robin配置类
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule() {
        // 随机算法
        return new RandomRule();
    }
}
