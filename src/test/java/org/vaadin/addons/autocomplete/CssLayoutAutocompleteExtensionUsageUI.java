package org.vaadin.addons.autocomplete;

import java.util.List;
import java.util.stream.Collectors;

import org.vaadin.addonhelpers.AbstractTest;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CssLayoutAutocompleteExtensionUsageUI extends AbstractTest {

    @Override
    public Component getTestComponent() {

        CssLayout layout = new CssLayout();

        TextField textField = new TextField();
        new AutocompleteExtension<String>(textField).setSuggestionGenerator(this::getSuggestions);

        Button button = new Button("Button");

        layout.addComponents(textField, button);
        layout.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        return layout;
//        Layout layout = new VerticalLayout();
//
//        FormLayout formLayout = new FormLayout();
//
//        TextField textField = new TextField();
//        new AutocompleteExtension<String>(textField)
//                .setSuggestionGenerator(this::getSuggestions);
//
//        formLayout.addComponent(new Label("label1"));
//        formLayout.addComponent(new Label("label2"));
//        formLayout.addComponent(textField);
//        formLayout.addComponent(new Label("label3"));
//        formLayout.addComponent(new Label("label4"));
//        formLayout.addComponent(new Label("label5"));
//
//        Panel panel = new Panel();
//        panel.setHeight(200, Unit.PIXELS);
//        panel.setContent(formLayout);
//
//        layout.addComponent(panel);
//
//        return layout;
    }

    /**
     * Returns planets containing the query string.
     */
    private List<String> getSuggestions(String query, int maxCount) {
        return DataSource.getPlanets().stream()
                .filter(s -> s.toLowerCase().contains(query.toLowerCase()))
                .limit(maxCount).collect(Collectors.toList());
    }
}
