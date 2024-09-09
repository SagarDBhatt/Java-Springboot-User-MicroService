package UserMicroServicePkg.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceSingleton {

    private static DataSource dataSourceObj;

    @Value("${driverName}")
    String driver;

    @Value("${url}")
    String url;

    @Value("${username_prop}")
    String username;

    @Value("${password}")
    String password;

    @Bean
    public synchronized DataSource getDataSource(){
        if(dataSourceObj == null){
            synchronized (DataSourceSingleton.class){
                //System.out.println(username + " == " + password + " == " +  url + " == " + driver);
                dataSourceObj = DataSourceBuilder.create()
                        .username(username)
                        .password(password)
                        .url(url)
                        .driverClassName(driver)
                        .build();
            }
        }
        return dataSourceObj;
    }

}
