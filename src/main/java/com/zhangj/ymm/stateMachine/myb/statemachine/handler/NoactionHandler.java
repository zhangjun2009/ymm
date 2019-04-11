package com.zhangj.ymm.stateMachine.myb.statemachine.handler;

import com.zhangj.ymm.stateMachine.myb.statemachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.myb.statemachine.Event;
import com.zhangj.ymm.stateMachine.myb.statemachine.Member;

public class NoactionHandler extends AbstractStateHandler {

    @Override
    public Event event() {
        return Event.no_action;
    }

    @Override
    protected Object doHandler(Member member) {
        System.out.println("客户什么都没做，没充值，也没有支付");
        return null;
    }

}
