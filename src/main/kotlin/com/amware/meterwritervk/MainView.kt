package com.amware.meterwritervk

import com.amware.meterwritervk.model.MyData
import com.amware.meterwritervk.tabs.HasTitle
import com.amware.meterwritervk.tabs.ReadFlowDataPane
import com.amware.meterwritervk.tabs.ReadPreciseFlowDataPane
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLayout
import org.springframework.beans.factory.annotation.Autowired
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

	private val tabPanes = arrayOf<Component>(
			ReadFlowDataPane(),
			ReadPreciseFlowDataPane()
	)

	init {
		defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
		add(HorizontalLayout().apply {
			width = "100%"
			style["color"] = "#FC0"
			style["background-color"] = "#08F"
			justifyContentMode = FlexComponent.JustifyContentMode.CENTER
			add(titleText)
		}, HorizontalLayout(
				SerialPortPane(myData),
				CenterPane().also {
					expand(it)
				},
				Button("右边")
		).apply {
			defaultVerticalComponentAlignment = FlexComponent.Alignment.START
			width = "100%"
		})

		println(myData.str1)
		myData.str1 += " 然后呢？"
	}

	inner class CenterPane : VerticalLayout(), RouterLayout {
		init {
			val navPane = NavPane(this)
			add(navPane)
			navPane.initTabs()
			add("一行字")
			add(Button("一个按钮"))
			add("两行字")
			add(Button("又一个按钮"))
		}
	}

	inner class NavPane(private val centerPane: CenterPane) : Tabs() {
		fun initTabs() {
//			orientation = Orientation.VERTICAL

			val tabMap = tabPanes.map {
				Tab(
						if (it is HasTitle) {
							it.title
						} else {
							it.toString()
						}
				) to it
			}.toMap()

			tabMap.forEach {
				add(it.key)
				centerPane.add(it.value.apply {
					isVisible = false
				})
			}

			addSelectedChangeListener { event ->
				tabMap.forEach {
					it.value.isVisible = false
				}
				tabMap[event.source.selectedTab]?.isVisible = true
			}

			tabMap.values.first().isVisible = true
		}
	}

	@PostConstruct
	fun loaded() {
		println("这时候，myData.str1 = \"${myData.str1}\"")
	}

}
