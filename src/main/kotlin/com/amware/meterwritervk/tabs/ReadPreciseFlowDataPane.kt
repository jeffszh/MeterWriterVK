package com.amware.meterwritervk.tabs

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("readPreciseFlowData")
class ReadPreciseFlowDataPane : VerticalLayout() {

	init {
		add(Button("读取"))
		add(Button("写入"))
	}

}
