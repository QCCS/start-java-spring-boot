package com.example.demo1.learn.other;

public class EnumTest {
    public static void main(String[] args) {
        forEnum();
        useEnumInJava();
    }
    /**
     * 循环枚举,输出序号-ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性)
     */
    private static void forEnum() {
        for (SimpleEnum simpleEnum : SimpleEnum.values()) {
            System.out.println(simpleEnum + " index is" + simpleEnum.ordinal());
        }
        System.out.println("------------------");
        for (TYPE type : TYPE.values()) {
            System.out.println("type = " + type + "    type.name = " + type.name() + "   typeName = " + type.getTypeName() + "   ordinal = " + type.ordinal());
        }
    }

    /**
     * 在Java代码使用枚举
     */
    private static void useEnumInJava() {
        String typeName = "f5";
        TYPE type = TYPE.fromTypeName(typeName);
        if (TYPE.BALANCE.equals(type)) {
            System.out.println(type.name());
            System.out.println(type.getTypeName());
            System.out.println("Get enum key by value");
        } else {
            System.out.println("code error");
        }

    }

    /**
     * 季节枚举(不带参数的枚举常量)这个是最简单的枚举使用实例
     * Ordinal 属性，对应的就是排列顺序，从0开始。
     */
    private enum SimpleEnum {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER
    }

    /**
     * 常用类型(带参数的枚举常量，这个只是在书上不常见，实际使用还是很多的，看懂这个，使用就不是问题啦。)
     */
    private enum TYPE {
        FIREWALL("firewall"),
        SECRET("secretMac"),
        BALANCE("f5");

        private String typeName;

        TYPE(String typeName) {
            this.typeName = typeName;
        }
        /**
         * 根据类型的名称，返回类型的枚举实例。
         * @param typeName 类型名称
         */
        public static TYPE fromTypeName(String typeName) {
            for (TYPE type : TYPE.values()) {
                if (type.getTypeName().equals(typeName)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeName() {
            return this.typeName;
        }
    }
    public enum Color1 {
        RED, GREEN, BLANK, YELLOW
    }
    public enum Color2 {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private Color2(String name, int index) {
            this.name = name;
            this.index = index;
        }
        //覆盖方法
        @Override
        public String toString() {
            return this.index+"_"+this.name;
        }
    }
}
