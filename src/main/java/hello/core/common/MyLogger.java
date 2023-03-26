package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // proxyMode = ScopedProxyMode.TARGET_CLASS 가짜 프록시 클래스(CGLIB)를 생성해서 주입해준다. 로직이 호출 됐을때 진짜 로직 실행.
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String msg) {
        System.out.println("["+uuid+"]"+"["+requestURL+"] "+msg);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] "+"request scope bean create: "+this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid+"] "+"request scope bean close: "+this);
    }
}
