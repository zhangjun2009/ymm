package com.zhangj.ymm.stateMachine.myb.statemachine.handler;

import com.zhangj.ymm.stateMachine.myb.statemachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.myb.statemachine.Event;
import com.zhangj.ymm.stateMachine.myb.statemachine.Member;

public class EnterprisePayHandler extends AbstractStateHandler {

    @Override
    public Event event() {
        return Event.pay;
    }

    @Override
    protected Object doHandler(Member member) {
        System.out.println("30天内支付了");
        return new Object();
    }

}
