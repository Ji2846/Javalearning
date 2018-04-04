package com.horsleyli.javalearning.polymorphic;

class 毕姥爷 {

    void 讲课() {
        System.out.println("管理");
    }
    void 钓鱼() {
        System.out.println("钓鱼");
    }

}

class 毕老师 extends 毕姥爷 {
    void 讲课() {
        System.out.println("Java");
    }
    void 看电影() {
        System.out.println("看电影");
    }
}

public class PolymorphicDemo1 {

    public static void main(String[] args) {

        毕姥爷 y = new 毕老师();
//        毕老师"化妆"(向上转型)成了毕姥爷.
//        所以此时毕老师拥有三个功能("讲课","钓鱼","看电影").
        y.讲课();
//        因为毕老师"化妆"成了毕姥爷,所以可以"讲课".
        y.钓鱼();
//        y.看电影();
//        虽然同时拥有三个功能,但毕姥爷自己并不爱看电影,所以无法调用"看电影()".
        毕老师 s = (毕老师)y;
        s.看电影();
//        所以,当需要执行"看电影()"时,毕老师就需要"卸妆"(向下转型)回毕老师这个身份.
    }

}
