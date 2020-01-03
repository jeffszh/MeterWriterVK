package com.amware.meterwritervk

import com.amware.meterwritervk.model.MyData
import com.amware.meterwritervk.tabs.ReadFlowDataPane
import com.amware.meterwritervk.tabs.ReadPreciseFlowDataPane
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLayout
import org.springframework.beans.factory.annotation.Autowired
import java.lang.Exception
import javax.annotation.PostConstruct

@Route("")
@PageTitle(MainView.titleText)
class MainView(
//		@Autowired val serialPortPane: SerialPortPane
		@Autowired val myData: MyData
) : VerticalLayout(), RouterLayout {

	companion object {
		const val titleText = "水表写入器网页版"
	}

	private val tabPanes = arrayOf(
			"读流量数据" to ReadFlowDataPane::class.java,
			"读高精度流量数据" to ReadPreciseFlowDataPane::class.java
	)

	init {
		defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
		add(HorizontalLayout().apply {
			width = "100%"
			style["color"] = "#FC0"
			style["background-color"] = "#08F"
			justifyContentMode = FlexComponent.JustifyContentMode.CENTER
			add(titleText)
		})
		add(HorizontalLayout().apply {
			defaultVerticalComponentAlignment = FlexComponent.Alignment.START
			width = "100%"

			val centerPane = CenterPane()
			val rightPane = Button("右边")
			expand(centerPane)
//			add(serialPortPane, centerPane, rightPane)
			add(SerialPortPane(myData), centerPane, rightPane)
		})

		println(myData.str1)
		myData.str1 += " 然后呢？"
	}

	inner class CenterPane : VerticalLayout() {
		init {
			val navPane = NavPane()
			add(navPane)
			add("一行字")
			add(Button("一个按钮"))
			add("两行字")
			add(Button("又一个按钮"))
		}
	}

	inner class NavPane : Tabs() {
		init {
//			orientation = Orientation.VERTICAL

			tabPanes.forEach {
				val tabText = it.first
				val tabClass = it.second
				val routeAnnotation = tabClass.getAnnotation(Route::class.java)
				if (routeAnnotation == null) {
					throw Exception("忘了加上 ${Route::class.java} 注解！")
				} else {
					add(Tab(tabText))
				}
			}
		}
	}

//	@Route("page1", layout = CenterPane::class)
//	class Page1 : Div(), RouterLayout {
//		init {
//			add(Button("返回主页") {
//				ui.get().navigate("")
//			})
//		}
//	}

	@PostConstruct
	fun loaded() {
		println("这时候，myData.str1 = \"${myData.str1}\"")
	}

}
