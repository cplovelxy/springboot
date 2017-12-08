package study.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/29.
 */
@Component
public class TomcatConfig extends TomcatEmbeddedServletContainerFactory {
    private static int port = 8081;
    private static String contextPath = "/springBoot";
    private static long timeOut = (long) 15*1000;
    private static int maxConnection = 20;
    private static int maxThread = 20;


    public TomcatConfig(){
        super(contextPath,port);
    }

    @Override
    protected void customizeConnector(Connector connector){
        super.customizeConnector(connector);

        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setSelectorTimeout(timeOut);
        protocol.setMaxConnections(maxConnection);
        protocol.setMaxThreads(maxThread);
    }

}
