package io.vertx.up._03.rm;

import io.vertx.core.http.HttpMethod;

import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.Set;

public class RRecord implements Serializable {
    /** 路由顺序 */
    private int order = 1000;
    /** 路由路径 */
    private String path;
    /** Consume绑定 */
    private Set<MediaType> consumes;
    /** Produce绑定 */
    private Set<MediaType> produces;
    /** HTTP方法 */
    private HttpMethod method = HttpMethod.GET;
    /** 处理器构造 **/
    private RAction success;
    /** 异常处理器构造 **/
    private RAction failure;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public Set<MediaType> getConsumes() {
        return this.consumes;
    }

    public void setConsumes(final Set<MediaType> consumes) {
        this.consumes = consumes;
    }

    public Set<MediaType> getProduces() {
        return this.produces;
    }

    public void setProduces(final Set<MediaType> produces) {
        this.produces = produces;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public void setMethod(final HttpMethod method) {
        this.method = method;
    }

    public RAction getSuccess() {
        return this.success;
    }

    public void setSuccess(final RAction success) {
        this.success = success;
    }

    public RAction getFailure() {
        return this.failure;
    }

    public void setFailure(final RAction failure) {
        this.failure = failure;
    }
}
