package com.zhangj.ymm.stateMachine.stateMachine;

public class Order {
    private State state = State.pending_payment;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
