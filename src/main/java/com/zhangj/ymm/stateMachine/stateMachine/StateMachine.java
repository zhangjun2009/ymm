package com.zhangj.ymm.stateMachine.stateMachine;

public interface StateMachine {
    State next(State state, Event event);
}
