package com.amware.meterwritervk

import com.amware.meterwritervk.model.MyData
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import com.vaadin.flow.data.binder.Setter
import com.vaadin.flow.data.value.ValueChangeMode
import com.vaadin.flow.function.ValueProvider
import com.vaadin.flow.router.RouterLayout
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import kotlin.reflect.KProperty1
import com.vaadin.flow.component.html.NativeButton
import com.amware.meterwritervk.SerialPortPane
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

@Component
final class SerialPortPane(
		@Autowired val myData: MyData
) : FormLayout(), RouterLayout {

//	@Autowired
//	lateinit var myData2: MyData

	init {
//		println("myData2=$myData2")
		width = "30%"
		val portName = TextField().apply {
			label = "串口名："
			placeholder = "内容1"
			valueChangeMode = ValueChangeMode.ON_CHANGE
		}
		val baudRate = TextField().apply {
			label = "输入2："
			placeholder = "内容2"
		}
		val dataBits = TextField().apply {
			label = "输入3："
			placeholder = "内容3"
		}
		add(portName, baudRate, dataBits)
		val btnRead = NativeButton("读取").apply {
			addClickListener {
				println(myData.str1)
			}
		}
		val reset = Button("Reset")
		add(HorizontalLayout().apply {
			add(btnRead, reset)
		})

		val binder = Binder<MyData>()
//		val binding1: Binder.Binding<MyData, String> = binder.forField(portName).bind(
//				{ it.str1 }, { obj, str -> obj.str1 = str }
//		)
		binder.forField(portName).bind(
				{ it.str1 }, { obj, str -> obj.str1 = str }
		)
		binder.bean = myData
	}

}
