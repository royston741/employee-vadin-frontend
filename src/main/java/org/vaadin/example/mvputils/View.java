package org.vaadin.example.mvputils;

public interface View<P extends Presenter> {
    P getPresenter();
}
