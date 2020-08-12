package io.vertx.up._02.buffer.cases;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.shareddata.impl.ClusterSerializable;

public class BasicUser implements ClusterSerializable {

    private transient String id;
    private transient String username;
    private transient String password;

    @Override
    public void writeToBuffer(final Buffer buffer) {
        /* 写入id，用户名和token **/
        Buffalo.write(buffer, this.id, this.username, this.password);
    }

    @Override
    public int readFromBuffer(int pos, final Buffer buffer) {
        /* 读取信息 **/
        final String[] reference = new String[3];
        pos = Buffalo.read(pos, buffer, reference);

        /* 从引用中读取数据 **/
        this.id = reference[0];
        this.username = reference[1];
        this.password = reference[2];
        return pos;
    }
}
