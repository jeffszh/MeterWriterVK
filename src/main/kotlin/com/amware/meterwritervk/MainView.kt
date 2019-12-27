package com.amware.meterwritervk

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("")
class MainView : VerticalLayout() {

	init {
		defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
		val versionText = Label("V0.0.1")
		add(H1("打字練習"), versionText, NavPane())
		setHorizontalComponentAlignment(FlexComponent.Alignment.END, versionText)
	}

	class NavPane : HorizontalLayout() {
		init {
			add(
					Button("练习输入密码") {
						ui.get().navigate("pwExercise")
					},
					Button("键位练习") {
//						UI.getCurrent().navigate(KeyPosExView::class.java)
					}
			)
		}
	}

}
