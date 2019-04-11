package com.zhangj.ymm.stateMachine.myb.statemachine;

public class IndividualStateMachine implements StateMachine {

    @Override
    public State next(State state, Event event, Object result) {
        if (State.pending_active.equals(state) && Event.pay.equals(event)) {
            return State.active;
        }
        
        
        if (State.active.equals(state) && Event.no_action.equals(event)) {
            return State.lost;
        }
        
        if (State.lost.equals(state) && Event.pay.equals(event)) {
            return State.active;
        }
        
        throw new IllegalStateException();
    }

}
