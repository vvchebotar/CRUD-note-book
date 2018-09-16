package org.vvchebotar.crud.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.vvchebotar.crud.dao.BookDao;
import org.vvchebotar.crud.dao.BookDaoImp;
import org.vvchebotar.crud.service.BookService;
import org.vvchebotar.crud.service.BookServiceImpl;

/**
 * first
 *
 * @author user
 * "@EnableWebMvc" - to configure the DefaultAnnotationHandlerMapping, AnnotationMethodHandlerAdapter and ExceptionHandlerExceptionResolver
 * "@ComponentScan" - to force Spring find beans.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.vvchebotar.crud")
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "bookDAO")
    public BookDao getBookDAO() {
        return new BookDaoImp();
    }

    @Bean(name = "bookService")
    public BookService getBookService() {
        return new BookServiceImpl();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("messages");
        return resource;
    }
}


