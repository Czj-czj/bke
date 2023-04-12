package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ErrorPage;
import javax.servlet.ServletException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp/WEB-INF";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        context.addErrorPage(new ErrorPage());

        tomcat.start();
        tomcat.getServer().await();
    }
}

