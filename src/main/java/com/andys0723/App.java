package com.andys0723;

import com.andys0723.Config.AppConfig;
import com.andys0723.Service.ProcessingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        ProcessingService processingService = context.getBean(ProcessingService.class);
        processingService.processing();
    }
}
