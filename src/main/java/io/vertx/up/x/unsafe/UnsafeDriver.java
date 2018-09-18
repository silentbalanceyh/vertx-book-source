package io.vertx.up.x.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDriver {

    public static void main(final String[] args) throws Exception {
        // 下边代码会编译错
        // final DefaultScope scope = new DefaultScope();
        final Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference
        f.setAccessible(true);
        final Unsafe unsafe = (Unsafe) f.get(null);
        // 实例化DefaultScope
        final DefaultScope scope = (DefaultScope) unsafe.allocateInstance(DefaultScope.class);
        System.out.println(scope.getUsername() + "," + scope.getAge());
        // 正常设置scope中的age
        scope.setAge(44);
        System.out.println(scope.getUsername() + "," + scope.getAge());
    }
}
