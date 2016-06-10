package com.luxoft.movieLand;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        DataSource dataSource = (DataSource) application.getBean("dataSource");

        /*Insert insert = new Insert();
        for (Movie movie: movieList)
        {
            insert.insertDataMovie(movie,dataSource);
        }*/
    }
}
