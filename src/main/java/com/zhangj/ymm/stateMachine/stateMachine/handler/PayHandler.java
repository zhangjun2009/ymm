package com.zhangj.ymm.stateMachine.stateMachine.handler;


import com.zhangj.ymm.stateMachine.stateMachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.stateMachine.Event;
import com.zhangj.ymm.stateMachine.stateMachine.Order;

public class PayHandler extends AbstractStateHandler {

    @Override
    protected void before(Order order) {
        System.out.println("待付款定单，准备付款");
    }

    @Override
    protected void after(Order order) {
        System.out.println("付款成功");
    }

    @Override
    protected void doHandler(Order order) {
        System.out.println("定单付款");
    }

    @Override
    public Event event() {
        return Event.pay;
    }

}
