package com.amware.meterwritervk;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

//@Route("")
@PageTitle(MainView.titleText)
public class Root extends VerticalLayout implements RouterLayout {

	private static final String titleText = "水表写入器网页版（Java）";

	public Root() {
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		VerticalLayout div = new VerticalLayout();
		div.setWidth("100%");
		div.getStyle().set("color", "#FC0");
		div.getStyle().set("background-color", "#08F");
		div.setAlignItems(Alignment.CENTER);
		div.setPadding(false);
		Label titleLabel = new Label(titleText);
		div.add(titleLabel);
		add(div);
		add(new NavPane());
	}

	private static class NavPane extends Tabs {
		NavPane() {
			add(new Tab("one"));
			add(new Tab("two"));
		}
	}

//	@Route(value = "page1", layout = Root.class)
//	public static class Page1 extends Div implements RouterLayout {
//		public Page1() {
//			add(new Button("很好！"));
//		}
//	}

}
