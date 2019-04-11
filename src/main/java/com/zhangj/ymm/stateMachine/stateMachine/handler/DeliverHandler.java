package com.zhangj.ymm.stateMachine.stateMachine.handler;


import com.zhangj.ymm.stateMachine.stateMachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.stateMachine.Event;
import com.zhangj.ymm.stateMachine.stateMachine.Order;

public class DeliverHandler extends AbstractStateHandler {

    @Override
    protected void doHandler(Order order) {
        System.out.println("发货");
    }

    @Override
    public Event event() {
        return Event.deliver;
    }

}
