package com.bean.shell.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    //需要将对象交给容器管理Map集合  map<paginationInterceptor方法名,实例化之后的对象>
    //Spring注入 1.按照类型注入   2.可以按照名字注入
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
