package com.zhangj.ymm.work;

/**
 * @author zhangj
 * @date 2019/3/15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(OptType.isExistOptType(1));

    }

    static class User {
        private Integer id1;
        private Integer id2;

        @Override
        public String toString() {
            return "User{" +
                    "id1=" + id1 +
                    ", id2=" + id2 +
                    '}';
        }

        public User(Integer id1, Integer id2) {
            this.id1 = id1;
            this.id2 = id2;
        }

        public Integer getId1() {
            return id1;
        }

        public void setId1(Integer id1) {
            this.id1 = id1;
        }

        public Integer getId2() {
            return id2;
        }

        public void setId2(Integer id2) {
            this.id2 = id2;
        }
    }
}
