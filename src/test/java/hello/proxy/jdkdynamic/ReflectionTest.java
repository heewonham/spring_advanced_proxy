package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {
    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        // 공통 로직1 종료

        // 공통 로직2 시작

        // 공통 로직2 종료


    }

    @Slf4j
    static class Hello{
        public String callA() {

        }
        public String callB() {

        }
    }
}
