package com.amware.meterwritervk

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLayout

@Route("")
@PageTitle(MainView.titleText)
class MainView : VerticalLayout(), RouterLayout {

	companion object {
		const val titleText = "水表写入器网页版"
	}

	init {
		defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
		add(VerticalLayout().apply {
			width = "100%"
			style["color"] = "#FC0"
			style["background-color"] = "#08F"
			alignItems = FlexComponent.Alignment.CENTER
			isPadding = false
			add(Label(titleText).apply {
				//style["align"] = "center"
			})
		})
		add(NavPane())
	}

	class NavPane : Tabs() {
		init {
			add(Tab("one").apply {
				add("第一个")
			}, Tab("two").apply {
				add("很好")
			})
		}
	}

	@Route("page1", layout = MainView::class)
	class Page1 : Div(), RouterLayout {
		init {
			add(Button("返回主页") {
				ui.get().navigate("")
			})
		}
	}

}
