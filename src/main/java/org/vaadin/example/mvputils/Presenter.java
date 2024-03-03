package org.vaadin.example.mvputils;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeLeaveEvent;

public interface Presenter<V extends View> {
    V getView();

    void setView(V view);

    void beforeEnter(BeforeEnterEvent beforeEnterEvent);

    void beforeLeave(BeforeLeaveEvent beforeLeaveEvent);

    void beforeViewInit();

    void afterViewInit();

}
