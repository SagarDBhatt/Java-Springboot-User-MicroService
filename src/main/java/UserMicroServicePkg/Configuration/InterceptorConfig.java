package UserMicroServicePkg.Configuration;

import UserMicroServicePkg.Interceptor.UserServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    UserServiceInterceptor userServiceInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userServiceInterceptor);
    }
}
