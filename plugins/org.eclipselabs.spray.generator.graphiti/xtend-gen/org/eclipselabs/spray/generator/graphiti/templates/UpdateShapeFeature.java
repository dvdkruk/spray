package org.eclipselabs.spray.generator.graphiti.templates;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.MetaModel;
import org.eclipselabs.spray.mm.spray.Container;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.SprayElement;
import org.eclipselabs.spray.mm.spray.Text;
import org.eclipselabs.spray.mm.spray.extensions.SprayExtensions;

@SuppressWarnings("all")
public class UpdateShapeFeature extends FileGenerator {
  
  @Inject
  private SprayExtensions e1;
  
  @Inject
  private IQualifiedNameProvider qnProvider;
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((Container) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((Container) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final Container container, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _extensionHeader = this.extensionHeader(this);
    _builder.append(_extensionHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends ");
    _builder.append(className, "");
    _builder.append("Base {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation mainFile(final Container container, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    MetaClass _represents = container.getRepresents();
    Diagram _diagram = _represents.getDiagram();
    String _name = _diagram.getName();
    String diagramName = _name;
    _builder.newLineIfNotEmpty();
    MetaClass _represents_1 = container.getRepresents();
    EClass _type = _represents_1.getType();
    EPackage _ePackage = _type.getEPackage();
    String _name_1 = _ePackage.getName();
    String pack = _name_1;
    _builder.newLineIfNotEmpty();
    MetaClass _represents_2 = container.getRepresents();
    EClass _type_1 = _represents_2.getType();
    String _fullPackageName = MetaModel.fullPackageName(_type_1);
    String fullPackage = _fullPackageName;
    _builder.newLineIfNotEmpty();
    String _constainerClass = GeneratorUtil.constainerClass(container);
    String containerType = _constainerClass;
    _builder.newLineIfNotEmpty();
    String labelName = "name";
    _builder.newLineIfNotEmpty();
    StringConcatenation _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IReason;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IUpdateContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.impl.Reason;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Text;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.ContainerShape;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Diagram;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Shape;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.Graphiti;");
    _builder.newLine();
    _builder.append("import ");
    String _util_package = GeneratorUtil.util_package();
    _builder.append(_util_package, "");
    _builder.append(".SprayContainerService;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(fullPackage, "");
    _builder.append(".");
    MetaClass _represents_3 = container.getRepresents();
    String _name_2 = this.e1.getName(_represents_3);
    _builder.append(_name_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractUpdateFeature {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Map<String, String> values = null; ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public  ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean canUpdate(IUpdateContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// return true, if linked business object is a EClass");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object bo =  getBusinessObjectForPictogramElement(context.getPictogramElement());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("PictogramElement pictogramElement = context.getPictogramElement();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (bo instanceof ");
    MetaClass _represents_4 = container.getRepresents();
    String _name_3 = this.e1.getName(_represents_4);
    _builder.append(_name_3, "        ");
    _builder.append(")&& (!(pictogramElement instanceof Diagram));");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public IReason updateNeeded(IUpdateContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("PictogramElement pictogramElement = context.getPictogramElement();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object bo = getBusinessObjectForPictogramElement(pictogramElement);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ( ! (bo instanceof ");
    MetaClass _represents_5 = container.getRepresents();
    String _name_4 = this.e1.getName(_represents_5);
    _builder.append(_name_4, "        ");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("return Reason.createFalseReason(); ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    MetaClass _represents_6 = container.getRepresents();
    String _name_5 = this.e1.getName(_represents_6);
    _builder.append(_name_5, "           ");
    _builder.append(" eClass = (");
    MetaClass _represents_7 = container.getRepresents();
    String _name_6 = this.e1.getName(_represents_7);
    _builder.append(_name_6, "           ");
    _builder.append(") bo;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// retrieve name from pictogram model");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (pictogramElement instanceof ContainerShape) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ContainerShape cs = (ContainerShape) pictogramElement;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ContainerShape textBox = SprayContainerService.findTextShape(cs);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("for (Shape shape : textBox.getChildren()) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (shape.getGraphicsAlgorithm() instanceof Text) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("Text text = (Text) shape.getGraphicsAlgorithm();");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("String type = Graphiti.getPeService().getPropertyValue(shape, \"MODEL_TYPE\");");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("String value = getValues(eClass).get(type);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if( value != null){");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("String pictogramName = text.getValue();");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("// update needed, if names are different");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("boolean updateNameNeeded =((pictogramName == null && value != null) || (pictogramName != null && !pictogramName.equals(value)));");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("if (updateNameNeeded) {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("return Reason.createTrueReason(\"Name [\" + pictogramName + \"] is out of date\");");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Reason.createFalseReason();");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean update(IUpdateContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("PictogramElement pictogramElement = context.getPictogramElement();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object bo = getBusinessObjectForPictogramElement(pictogramElement);");
    _builder.newLine();
    _builder.append("          ");
    MetaClass _represents_8 = container.getRepresents();
    String _name_7 = this.e1.getName(_represents_8);
    _builder.append(_name_7, "          ");
    _builder.append(" eClass = (");
    MetaClass _represents_9 = container.getRepresents();
    String _name_8 = this.e1.getName(_represents_9);
    _builder.append(_name_8, "          ");
    _builder.append(") bo;");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return SprayContainerService.update(pictogramElement, getValues(eClass));");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected Map<String, String> getValues(");
    MetaClass _represents_10 = container.getRepresents();
    String _name_9 = this.e1.getName(_represents_10);
    _builder.append(_name_9, "    ");
    _builder.append(" eClass) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("if (values == null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("values = new HashMap<String, String>();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("fillValues(eClass);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return values;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected void fillValues(");
    MetaClass _represents_11 = container.getRepresents();
    String _name_10 = this.e1.getName(_represents_11);
    _builder.append(_name_10, "    ");
    _builder.append(" eClass) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("String type, value;");
    _builder.newLine();
    {
      SprayElement[] _parts = container.getParts();
      for(final SprayElement part : _parts) {
        {
          if ((part instanceof org.eclipselabs.spray.mm.spray.Text)) {
            _builder.append("    ");
            _builder.append("    ");
            Text text = ((Text) part);
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("type = \"");
            QualifiedName _fullyQualifiedName = this.qnProvider.getFullyQualifiedName(text);
            _builder.append(_fullyQualifiedName, "    ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("value = getValue(type, eClass);");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("values.put(type, value);");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private String getValue (String type, ");
    MetaClass _represents_12 = container.getRepresents();
    String _name_11 = this.e1.getName(_represents_12);
    _builder.append(_name_11, "    ");
    _builder.append(" eClass) {");
    _builder.newLineIfNotEmpty();
    {
      SprayElement[] _parts_1 = container.getParts();
      for(final SprayElement part_1 : _parts_1) {
        {
          if ((part_1 instanceof org.eclipselabs.spray.mm.spray.Text)) {
            _builder.append("    ");
            Text text_1 = ((Text) part_1);
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("if (\"");
            QualifiedName _fullyQualifiedName_1 = this.qnProvider.getFullyQualifiedName(text_1);
            _builder.append(_fullyQualifiedName_1, "    ");
            _builder.append("\".equals(type)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("    ");
            StringConcatenation _valueGenerator = this.valueGenerator(text_1, "eClass");
            _builder.append(_valueGenerator, "        ");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("        ");
    _builder.append("throw new IllegalArgumentException(type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean hasDoneChanges() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean canUndo(IContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}