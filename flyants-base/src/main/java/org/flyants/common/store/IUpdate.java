package org.flyants.common.store;

public interface IUpdate<P,T> extends IStore<P,T> {
    void update(T t);
}
