package com.example.application.views.helloworld;

import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

    private final TextField name;
    private final Button sayHello;
    private final ComboBox<String> combo;

    public HelloWorldView() {
        setId("hello-world-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        combo = getCmbMode();
        combo.setItems("item1", "item2", "item3");
        add(name, sayHello, combo);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

    private ComboBox<String> getCmbMode() {
        // 略
        final ComboBox<String> cmbMode = new ComboBox<>();

        cmbMode.addValueChangeListener(new ValueChangeListener<ValueChangeEvent<?>>() {
            private static final long serialVersionUID = 1L;

            boolean isCalled = false;

            @Override
            public void valueChanged(final ValueChangeEvent<?> e) {
                if (isCalled)
                    return;
                try {
                    isCalled = true;
                    // 確認ダイアログを表示し、
                    // キャンセルなら
                    // コンボボックスを変更前の状態にし、リターン
                    final Object oldValue = e.getOldValue();
                    getCmbMode().setValue((String) oldValue);
                    return;
                    // OKなら
                    // データをリセットする

                } finally {
                    isCalled = false;
                }
            }
        });
        return cmbMode;
    }

}
