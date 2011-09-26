package org.eclipselabs.spray.generator.graphiti.templates;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.MetaModel;
import org.eclipselabs.spray.mm.spray.MetaReference;
import org.eclipselabs.spray.mm.spray.extensions.SprayExtensions;

@SuppressWarnings("all")
public class UpdateReferenceAsListFeature extends FileGenerator {
  
  @Inject
  private SprayExtensions e1;
  
  private EClass target;
  
  public EClass setTarget(final EClass m) {
    EClass _target = this.target = m;
    return _target;
  }
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((MetaReference) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((MetaReference) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final MetaReference metaReference, final String className) {
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
  
  public StringConcatenation mainFile(final MetaReference reference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    String _fullPackageName = MetaModel.fullPackageName(this.target);
    String fullPackage = _fullPackageName;
    _builder.newLineIfNotEmpty();
    StringConcatenation _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append("; ");
    _builder.newLineIfNotEmpty();
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
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Shape;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(fullPackage, "");
    _builder.append(".");
    String _name = this.target.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractUpdateFeature {");
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
    _builder.append("return (bo instanceof ");
    String _name_1 = this.target.getName();
    _builder.append(_name_1, "        ");
    _builder.append(");");
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
    _builder.append("// retrieve name from pictogram model");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String pictogramName = null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("PictogramElement pictogramElement = context.getPictogramElement();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (pictogramElement instanceof Shape) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("Shape cs = (Shape) pictogramElement;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (cs.getGraphicsAlgorithm() instanceof Text) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("Text text = (Text) cs.getGraphicsAlgorithm();");
    _builder.newLine();
    _builder.append("//                  Graphiti.getPeService().getPropertyValue(shape, \"REFERENCE\");");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if( pictogramName == null ){");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("pictogramName = text.getValue();");
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
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// retrieve name from business model");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String businessName = null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object bo = getBusinessObjectForPictogramElement(pictogramElement);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (bo instanceof ");
    String _name_2 = this.target.getName();
    _builder.append(_name_2, "        ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    String _name_3 = this.target.getName();
    _builder.append(_name_3, "            ");
    _builder.append(" reference = (");
    String _name_4 = this.target.getName();
    _builder.append(_name_4, "            ");
    _builder.append(") bo;");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("businessName = reference.get");
    String _labelPropertyName = this.e1.getLabelPropertyName(reference);
    String _firstUpper = StringExtensions.toFirstUpper(_labelPropertyName);
    _builder.append(_firstUpper, "            ");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// update needed, if names are different");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("boolean updateNameNeeded =");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("((pictogramName == null && businessName != null) ||");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("(pictogramName != null && !pictogramName.equals(businessName)));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (updateNameNeeded) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return Reason.createTrueReason(\"Property Name is out of date\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return Reason.createFalseReason();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean update(IUpdateContext context) {");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("// retrieve name from business model");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String businessName = null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("PictogramElement pictogramElement = context.getPictogramElement();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object bo = getBusinessObjectForPictogramElement(pictogramElement);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (bo instanceof ");
    String _name_5 = this.target.getName();
    _builder.append(_name_5, "        ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    String _name_6 = this.target.getName();
    _builder.append(_name_6, "            ");
    _builder.append(" eClass = (");
    String _name_7 = this.target.getName();
    _builder.append(_name_7, "            ");
    _builder.append(") bo;");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("businessName = eClass.get");
    String _labelPropertyName_1 = this.e1.getLabelPropertyName(reference);
    String _firstUpper_1 = StringExtensions.toFirstUpper(_labelPropertyName_1);
    _builder.append(_firstUpper_1, "            ");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// Set name in pictogram model");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (pictogramElement instanceof Shape) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("Shape cs = (Shape) pictogramElement;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (cs.getGraphicsAlgorithm() instanceof Text) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("Text text = (Text) cs.getGraphicsAlgorithm();");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("text.setValue(businessName);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("layoutPictogramElement(cs.getContainer().getContainer());");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
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
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}