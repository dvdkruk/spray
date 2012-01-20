package org.eclipselabs.spray.shapes.generator;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.spray.shapes.generator.connections.ConnectionPlacingGenerator;
import org.eclipselabs.spray.shapes.generator.connections.ConnectionStyleGenerator;
import org.eclipselabs.spray.shapes.shapes.ConnectionDefinition;
import org.eclipselabs.spray.shapes.shapes.ConnectionStyle;
import org.eclipselabs.spray.shapes.shapes.PlacingDefinition;
import org.eclipselabs.spray.shapes.shapes.ShapestyleLayout;

@SuppressWarnings("all")
public class GeneratorConnectionDefinition {
  @Inject
  private ConnectionStyleGenerator styleGenerator;
  
  @Inject
  private ConnectionPlacingGenerator placingGenerator;
  
  public String packageName() {
    return "org.eclipselabs.spray.shapes";
  }
  
  public String packagePath() {
    return "org/eclipselabs/spray/shapes/";
  }
  
  public String filepath(final ConnectionDefinition c) {
    String _packagePath = this.packagePath();
    String _className = this.className(c);
    String _operator_plus = StringExtensions.operator_plus(_packagePath, _className);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".java");
    return _operator_plus_1;
  }
  
  public String className(final ConnectionDefinition c) {
    String _name = c.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public CharSequence compile(final ConnectionDefinition c) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _head = this.head(c);
    _builder.append(_head, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _body = this.body(c);
    _builder.append(_body, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence head(final ConnectionDefinition c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is a generated Shape for Spray");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package org.eclipselabs.spray.shapes;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.styles.Point;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.styles.Style;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.Graphiti;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IGaService;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IPeCreateService;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.util.IColorConstant;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.styles.ISprayStyle;");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence body(final ConnectionDefinition c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _className = this.className(c);
    _builder.append(_className, "");
    _builder.append(" extends DefaultSprayConnection {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IGaService gaService = Graphiti.getGaService();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IPeCreateService peCreateService = Graphiti.getPeCreateService();");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Connection getConnection(Diagram diagram, ISprayStyle iSprayStyle, Anchor startAnchor, Anchor endAnchor) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Style sprayStyle = iSprayStyle.getStyle(diagram);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      ConnectionStyle _connectionStyle = c.getConnectionStyle();
      boolean _operator_equals = ObjectExtensions.operator_equals(_connectionStyle, null);
      if (_operator_equals) {
        _builder.append("\t\t");
        _builder.append("Connection newConnection = peCreateService.createFreeFormConnection(diagram);");
        _builder.newLine();
      } else {
        {
          ConnectionStyle _connectionStyle_1 = c.getConnectionStyle();
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(_connectionStyle_1, ConnectionStyle.FREEFORM);
          if (_operator_equals_1) {
            _builder.append("\t\t");
            _builder.append("Connection newConnection = peCreateService.createFreeFormConnection(diagram);");
            _builder.newLine();
          } else {
            ConnectionStyle _connectionStyle_2 = c.getConnectionStyle();
            boolean _operator_equals_2 = ObjectExtensions.operator_equals(_connectionStyle_2, ConnectionStyle.MANHATTEN);
            if (_operator_equals_2) {
              _builder.append("\t\t");
              _builder.append("Connection newConnection = peCreateService.createManhattanConnection(diagram);");
              _builder.newLine();
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("newConnection.setStart(startAnchor);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newConnection.setEnd(endAnchor);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Polyline polyline = gaService.createPolyline(newConnection);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("polyline.setStyle(sprayStyle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Define general layout of connection");
    _builder.newLine();
    _builder.append("\t\t");
    ShapestyleLayout _layout = c.getLayout();
    CharSequence _generateStyleForConnection = this.styleGenerator.generateStyleForConnection("polyline", _layout);
    _builder.append(_generateStyleForConnection, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Set the Placings of the connection");
    _builder.newLine();
    {
      EList<PlacingDefinition> _placing = c.getPlacing();
      for(final PlacingDefinition place : _placing) {
        _builder.append("\t\t");
        CharSequence _generatePlacing = this.placingGenerator.generatePlacing(place);
        _builder.append(_generatePlacing, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return newConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}