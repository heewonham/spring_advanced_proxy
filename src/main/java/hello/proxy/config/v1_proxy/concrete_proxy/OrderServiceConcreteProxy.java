package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null); // 자식을 생략할 때부모 클래스를 생성해야한다.
        /***
         * 만약 super을 생략하면 super()를 기본으로 호출하고 기본생상자가 없어서 오류가 발생한다.
         * 만약 생성자가 하나도 없으면 기본생성자를 자바에서 자동으로 만듦.
         * 현재는 생성자가 하나 있어서 자동으로 만들어주지 않고 에러가 발생한다.
         */
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            // target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
