package io.vertx.up._03.rm;

import java.util.List;

public interface RStore {
    static RStore getInstance() {
        /*
         * 静态代码逻辑，可在正式代码中直接调用 RStore.getInstance() 屏蔽实现组件获取流程，
         * 类似 RStore 的简单工厂模式，内部实现可结合实际需要进行处理。
         *
         * 示例：
         * final RStore store = RStore.getInstance();
         * final List<RRecord> routes = store.fetchAll();
         */
        return null;
    }

    /* 读取数据构造 List<RRecord> 集合 */
    List<RRecord> fetchAll();
}
