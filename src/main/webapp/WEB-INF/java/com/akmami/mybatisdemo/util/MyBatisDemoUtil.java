package com.akmami.mybatisdemo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisDemoUtil
{
    private static SqlSessionFactory sessionFactory;

    static {
        Reader reader;
        try
        {
            reader = Resources.getResourceAsReader("resources/mybatisdemo-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("Session opened.");
        } catch(IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
