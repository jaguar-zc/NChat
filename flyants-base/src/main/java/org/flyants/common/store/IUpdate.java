package org.flyants.common.store;

public interface IUpdate<T> extends IStore<T> {
    void update(T t);
}
