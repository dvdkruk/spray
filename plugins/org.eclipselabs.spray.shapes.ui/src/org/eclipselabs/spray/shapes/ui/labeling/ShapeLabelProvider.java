/*
 * generated by Xtext
 */
package org.eclipselabs.spray.shapes.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipselabs.spray.shapes.ConnectionDefinition;
import org.eclipselabs.spray.shapes.Shape;
import org.eclipselabs.spray.shapes.ShapeContainer;

import javax.inject.Inject;

/**
 * Provides labels for a EObjects.
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ShapeLabelProvider extends DefaultEObjectLabelProvider {

    @Inject
    public ShapeLabelProvider(AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }

    public String image(ConnectionDefinition element) {
        return "connection16.gif";
    }

    public String image(ShapeContainer element) {
        return "Diagram.gif";
    }

    public String text(Shape shape) {
        return shape.eClass().getName();
    }

}
