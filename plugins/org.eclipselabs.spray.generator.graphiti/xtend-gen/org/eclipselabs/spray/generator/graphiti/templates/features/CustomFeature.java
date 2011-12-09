package org.eclipselabs.spray.generator.graphiti.templates.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.mm.spray.CustomBehavior;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.MetaClass;

@SuppressWarnings("all")
public class CustomFeature extends FileGenerator {
  public CharSequence generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    CharSequence _mainFile = this.mainFile(((CustomBehavior) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public CharSequence generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    CharSequence _mainExtensionPointFile = this.mainExtensionPointFile(((CustomBehavior) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public CharSequence mainExtensionPointFile(final CustomBehavior metaClass, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _extensionHeader = this.extensionHeader(this);
    _builder.append(_extensionHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.ICustomContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends ");
    _builder.append(className, "");
    _builder.append("Base {");
    _builder.newLineIfNotEmpty();
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
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void execute(ICustomContext context, EObject object) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// TODO add code here.");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence mainFile(final CustomBehavior behavior, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    MetaClass _metaClass = behavior.getMetaClass();
    Diagram _diagram = _metaClass.getDiagram();
    String _name = _diagram.getName();
    String diagramName = _name;
    _builder.newLineIfNotEmpty();
    CharSequence _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.ICustomContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.runtime.graphiti.features.AbstractCustomFeature;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractCustomFeature {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_additionalFields = this.generate_additionalFields(behavior);
    _builder.append(_generate_additionalFields, "    ");
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
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \"");
    String _label = behavior.getLabel();
    _builder.append(_label, "        ");
    _builder.append("\"; //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getDescription() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \"");
    String _label_1 = behavior.getLabel();
    _builder.append(_label_1, "        ");
    _builder.append(" description\"; //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    CharSequence _generate_canExecute = this.generate_canExecute(behavior);
    _builder.append(_generate_canExecute, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_execute = this.generate_execute(behavior);
    _builder.append(_generate_execute, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_additionalFields_1 = this.generate_additionalFields(behavior);
    _builder.append(_generate_additionalFields_1, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_canExecute(final CustomBehavior behavior) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean canExecute(ICustomContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// allow rename if exactly one pictogram element");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// representing an EClass is selected");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean ret = true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PictogramElement[] pes = context.getPictogramElements();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (pes != null && pes.length == 1) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("EObject bo = (EObject) getBusinessObjectForPictogramElement(pes[0]);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ret = canExecute (context, bo);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return ret;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("protected boolean canExecute(ICustomContext context, EObject bo) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_execute(final CustomBehavior behavior) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void execute(ICustomContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("PictogramElement[] pes = context.getPictogramElements();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (pes != null && pes.length == 1) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("EObject bo = (EObject) getBusinessObjectForPictogramElement(pes[0]);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("execute(context, bo);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract void execute(ICustomContext context, EObject object);");
    _builder.newLine();
    return _builder;
  }
}
