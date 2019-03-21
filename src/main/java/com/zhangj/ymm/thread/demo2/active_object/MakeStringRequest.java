package com.zhangj.ymm.thread.demo2.active_object;

/**
 * @author zhangj
 * @date 2019/3/20
 */
public class MakeStringRequest extends MethodRequest {
    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
