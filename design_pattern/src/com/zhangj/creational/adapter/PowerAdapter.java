package com.zhangj.creational.adapter;

/**
 * @author zhangj
 * @date 2019/8/2
 */
public class PowerAdapter implements DC5 {
    private AC200 ac200 = new AC200();

    @Override
    public int outputDC5V() {
        int ac200V = ac200.outputAC200V();
        int adapterOutput = ac200V / 44;

        System.out.println("使用PowerAdapter输入AC:" + ac200V + "V" + "输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
