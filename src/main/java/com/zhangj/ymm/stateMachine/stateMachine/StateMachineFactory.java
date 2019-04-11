package com.zhangj.ymm.stateMachine.stateMachine;

public final class StateMachineFactory {
    private static StateMachine machine;
    
    public static StateMachine getMachine() {
        if (null == machine) {
            synchronized (StateMachineFactory.class) {
                if (null == machine) {
                    machine = new DefaultStateMachine();
                }
            }
        }
        
        return machine;
    }
}
