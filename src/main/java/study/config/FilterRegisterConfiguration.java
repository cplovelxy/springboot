package study.config;

import com.feidee.money.adminauth.filter.AdminAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

/**
 *
 * @author Administrator
 * @date 2017/11/10
 */
@Configuration
public class FilterRegisterConfiguration {

   /* @Bean
    @Order(value = 1)
    public FilterRegistrationBean registrationFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(adminAuthFilter());
        registration.addUrlPatterns("*//*");

        return registration;
    }


    @Bean
    public Filter adminAuthFilter(){
        return new AdminAuthFilter();
    }*/
}
