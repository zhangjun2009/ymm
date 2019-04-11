package com.zhangj.ymm.stateMachine.myb.statemachine;

public abstract class AbstractStateHandler implements StateHandler {

    @Override
    public void handle(Member member) {
        this.before(member);
        Object result = this.doHandler(member);
        member.setState(StateMachineFactory.getMachine(
                member.getType()).next(member.getState(), this.event(), result));
        this.after(member);
    }

    protected void before(Member member) {
        
    }
    
    protected void after(Member member) {
        
    }
    
    protected abstract Object doHandler(Member member);
    
}
