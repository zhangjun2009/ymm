package com.zhangj.ymm.stateMachine.myb.statemachine.handler;

import com.zhangj.ymm.stateMachine.myb.statemachine.AbstractStateHandler;
import com.zhangj.ymm.stateMachine.myb.statemachine.Event;
import com.zhangj.ymm.stateMachine.myb.statemachine.Member;

public class EnterpriseRechargeHandler extends AbstractStateHandler {

    @Override
    public Event event() {
        return Event.recharge;
    }

    @Override
    protected Object doHandler(Member member) {
        System.out.println("5天内充值了6000元");
        return new Object();
    }

}
