package com.zhangj.ymm.stateMachine.stateMachine;

public interface StateHandler {
    void handle(Order order);
    
    Event event();
}
