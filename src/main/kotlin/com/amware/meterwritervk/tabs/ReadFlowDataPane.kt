package com.amware.meterwritervk.tabs

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class ReadFlowDataPane : VerticalLayout(), HasTitle {

	override val title = "读流量数据"

	init {
		add("读取")
		add(Button("写入"))
	}

}
