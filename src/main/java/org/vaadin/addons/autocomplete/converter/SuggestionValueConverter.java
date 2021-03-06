package org.vaadin.addons.autocomplete.converter;

import java.util.function.Function;

import org.vaadin.addons.autocomplete.generator.SuggestionGenerator;

/**
 * Converter function to convert suggestion data into text value to be set for
 * the text field when the suggestion is selected.
 *
 * @param <T>
 *         Type of the suggestion data, e.g. a Java Bean.
 * @see SuggestionGenerator
 * @see SuggestionCaptionConverter
 */
public interface SuggestionValueConverter<T> extends Function<T, String> {

    /**
     * Converter method that receives the suggestion data and converts it into a
     * text that would be set as value for the text field when the suggestion is
     * selected.
     *
     * @param suggestion
     *         Suggestion data object of type {@code T}.
     * @return Text that will be set as value for the text field when the
     * suggestion is selected.
     */
    @Override
    String apply(T suggestion);
}
