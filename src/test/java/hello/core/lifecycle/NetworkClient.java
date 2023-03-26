package hello.core.lifecycle;

//implements InitializingBean, DisposableBean 이 방식은 스프링에서만 의존해서 최근에는 거의 사용하지 않는다.
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = "+url);
    }

    public void call(String msg) {
        System.out.println("call : "+ url + " msg: "+msg);
    }

    //서비스 시작시 호출
    public void disconnect() {
        System.out.println("close: "+url);
    }

    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}