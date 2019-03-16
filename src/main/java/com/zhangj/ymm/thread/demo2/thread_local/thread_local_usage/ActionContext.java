package com.zhangj.ymm.thread.demo2.thread_local.thread_local_usage;

/**
 * @author zhangj
 * @date 2019/3/16
 * 设置成单列
 */
public class ActionContext {
    private final static ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ActionContextHolder {
        private static final ActionContext ACTION_CONTEXT = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return ActionContextHolder.ACTION_CONTEXT;
    }

    public Context getContext() {
        return THREAD_LOCAL.get();
    }
}
