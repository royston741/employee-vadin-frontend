package org.vaadin.example.mvputils;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@SpringComponent
public abstract class BasePresenter<V extends View> implements Presenter<V> {
    V view;
    @Override
    public V getView() {
        return this.view;
    }

    @Override
    public void setView(V view) {

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

    }

    @Override
    public void beforeLeave(BeforeLeaveEvent beforeLeaveEvent) {

    }

    @Override
    public void beforeViewInit() {

    }

    @Override
    public void afterViewInit() {

    }
}
