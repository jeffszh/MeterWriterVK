package com.amware.meterwritervk.tabs

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("readFlowData")
class ReadFlowDataPane : VerticalLayout() {

	init {
		add("读取")
		add(Button("写入"))
	}

}
