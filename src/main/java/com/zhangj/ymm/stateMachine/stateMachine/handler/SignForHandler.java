package com.zhangj.ymm.stateMachine.stateMachine.handler;

import com.zhangj.ymm.stateMachine.stateMachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.stateMachine.Event;
import com.zhangj.ymm.stateMachine.stateMachine.Order;

public class SignForHandler extends AbstractStateHandler {

    @Override
    protected void doHandler(Order order) {
        System.out.println("签收");
    }

    @Override
    protected void after(Order order) {
        System.out.println("定单处理完结");
    }

    @Override
    public Event event() {
        return Event.sign_for;
    }
}
