package org.vvchebotar.crud.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * to configure dispatcher servlet
 *
 * @author user
 *
 */

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;//new Class[] { RootApplicationContextConfig.class }
    }

    /**
     * WebApplicationContextConfig!!!! here is config Spring.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebApplicationContextConfig.class, HibernateConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
