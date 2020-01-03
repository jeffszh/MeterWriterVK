package com.amware.meterwritervk.tabs

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class ReadPreciseFlowDataPane : VerticalLayout(), HasTitle {

	override val title = "读高精度流量数据"

	init {
		add(Button("读取"))
		add(Button("写入"))
	}

}
