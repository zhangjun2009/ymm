package com.zhangj.ymm.stateMachine.myb.statemachine;

public interface StateHandler {
    void handle(Member member);
    
    Event event();
}
