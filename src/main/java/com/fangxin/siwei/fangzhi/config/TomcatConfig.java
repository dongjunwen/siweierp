package com.fangxin.siwei.fangzhi.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

/**
 * 设置tomcat最大并发和最大连接数
 * 文章来源：http://blog.csdn.net/mn960mn/article/details/51306140
 */
@Component
public class TomcatConfig extends TomcatEmbeddedServletContainerFactory{
   /* public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers)
    {
        //设置端口
        this.setPort(8082);
        return super.getEmbeddedServletContainer(initializers);
    }*/

    protected void customizeConnector(Connector connector)
    {
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        //设置最大连接数
        protocol.setMaxConnections(150);
        //设置最大线程数
        protocol.setMaxThreads(50);
        protocol.setConnectionTimeout(5000);
    }
}
