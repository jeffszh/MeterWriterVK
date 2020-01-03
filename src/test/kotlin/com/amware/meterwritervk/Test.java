package com.amware.meterwritervk;

import com.amware.meterwritervk.model.MyData;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class Test {

	public static void main(String... args) {
		new Test().run();
	}

	private void run() {
		TextField textField = new TextField();
		Binder<MyData> myDataBinder = new Binder<>();
		Binder.Binding<MyData, String> binding = myDataBinder.forField(textField).bind(MyData::getStr1, MyData::setStr1);
		System.out.println(binding);
	}

}
