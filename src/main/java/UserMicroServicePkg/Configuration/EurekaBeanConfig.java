package UserMicroServicePkg.Configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaBeanConfig {

    @Bean
    @ConditionalOnMissingBean
    public InetUtils getInetUtils(){
        return new InetUtils(new InetUtilsProperties());
    }
//    @Bean
//    @ConditionalOnMissingBean
//    public EurekaInstanceConfigBean getEurekInstanceConfigBean(InetUtils inetUtils){
//        return new EurekaInstanceConfigBean(inetUtils);
//    }
}
