package com.zhangj.ymm.stateMachine.myb.statemachine;

public interface StateMachine {
    State next(State state, Event event, Object result);
}
