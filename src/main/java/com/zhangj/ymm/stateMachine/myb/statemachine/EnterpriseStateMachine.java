package com.zhangj.ymm.stateMachine.myb.statemachine;

public class EnterpriseStateMachine implements StateMachine {

    @Override
    public State next(State state, Event event, Object result) {
        if (State.pending_active.equals(state) && Event.recharge.equals(event)) {
            
            if (null == result) {
                return state;
            }
            
            return State.active;
        }
        
        if (State.pending_active.equals(state) && Event.no_action.equals(event)) {
            return State.lost;
        }
        
        if (State.active.equals(state) && Event.pay.equals(event)) {
            
            if (null == result) {
                return state;
            }
            
            return State.online;
        }
        
        if (State.pending_active.equals(state) && Event.no_action.equals(event)) {
            return State.lost;
        }
        
        if (State.online.equals(state) && Event.no_action.equals(event)) {
            return State.lost;
        }
        
        if (State.lost.equals(state) && Event.pay.equals(event)) {
            return State.online;
        }
        
        if (State.lost.equals(state) && Event.recharge.equals(event)) {
            return State.online;
        }
        
        throw new IllegalStateException();
    }

}
