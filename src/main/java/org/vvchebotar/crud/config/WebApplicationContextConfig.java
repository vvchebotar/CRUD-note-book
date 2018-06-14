package org.vvchebotar.crud.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.vvchebotar.crud.dao.BookDao;
import org.vvchebotar.crud.dao.GenericDao;
import org.vvchebotar.crud.dao.BookDaoImp;
import org.vvchebotar.crud.service.BookService;
import org.vvchebotar.crud.service.GenericService;
import org.vvchebotar.crud.service.BookServiceImpl;

/**
 * first
 *
 * @author user
 * @EnableWebMvc - to configure the DefaultAnnotationHandlerMapping, AnnotationMethodHandlerAdapter and ExceptionHandlerExceptionResolver
 * @ComponentScan - to force Spring find beans.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.vvchebotar.crud")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * resolve actual view path
     *
     * @return
     */
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
/*
        @Bean
        public CommonsMultipartResolver multipartResolver() {
            CommonsMultipartResolver resolver = new CommonsMultipartResolver();
            resolver.setDefaultEncoding("utf-8");
            return resolver;
        }

        @Bean
        public MappingJackson2JsonView jsonView() {
            MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
            jsonView.setPrettyPrint(true);
            return jsonView;
        }

        @Bean
        public MarshallingView xmlView() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setClassesToBeBound(Product.class);
            MarshallingView xmlView = new MarshallingView(marshaller);
            return xmlView;
        }

        @Bean
        public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
            ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
            resolver.setContentNegotiationManager(manager);
            ArrayList<View> views = new ArrayList<>();
            views.add(jsonView());
            views.add(xmlView());
            resolver.setDefaultViews(views);
            return resolver;
        }

        @Bean
        public LocaleResolver localeResolver() {
            SessionLocaleResolver resolver = new SessionLocaleResolver();
            resolver.setDefaultLocale(new Locale("en"));
            return resolver;
        }

        @Bean
        public HandlerInterceptor promoCodeInterceptor() {
            PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
            promoCodeInterceptor.setPromoCode("OFF3R");
            promoCodeInterceptor.setOfferRedirect("products");
            promoCodeInterceptor.setErrorRedirect("invalidPromoCode");
            return promoCodeInterceptor;
        }

        @Bean(name = "validator")
        public LocalValidatorFactoryBean validator() {
            LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
            bean.setValidationMessageSource(messageSource());
            return bean;
        }

        @Bean
        public ProductValidator productValidator() {
            Set<Validator> springValidators = new HashSet<>();
            springValidators.add(new UnitsInStockValidator());
            ProductValidator productValidator = new ProductValidator();
            productValidator.setSpringValidators(springValidators);
            return productValidator;
        }

        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            UrlPathHelper urlPathHelper = new UrlPathHelper();
            urlPathHelper.setRemoveSemicolonContent(false);
            configurer.setUrlPathHelper(urlPathHelper);
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new ProcessingTimeLogInterceptor());
            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
            localeChangeInterceptor.setParamName("language");
            registry.addInterceptor(localeChangeInterceptor); */
    //registry.addInterceptor(promoCodeInterceptor()).addPathPatterns("/**/market/products/specialOffer");
        /*}

        @Override
        public Validator getValidator() {
            return validator();
        }*/
}


