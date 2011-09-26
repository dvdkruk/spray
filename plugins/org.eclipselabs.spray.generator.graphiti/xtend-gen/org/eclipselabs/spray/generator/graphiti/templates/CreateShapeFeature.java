package org.eclipselabs.spray.generator.graphiti.templates;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.MetaModel;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.extensions.SprayExtensions;

@SuppressWarnings("all")
public class CreateShapeFeature extends FileGenerator {
  
  @Inject
  private SprayExtensions e1;
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((MetaClass) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((MetaClass) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final MetaClass metaClass, final String className) {
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
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation mainFile(final MetaClass metaClass, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    Diagram _diagram = metaClass.getDiagram();
    String _name = _diagram.getName();
    String diagramName = _name;
    _builder.newLineIfNotEmpty();
    EClass _type = metaClass.getType();
    EPackage _ePackage = _type.getEPackage();
    String _name_1 = _ePackage.getName();
    String pack = _name_1;
    _builder.newLineIfNotEmpty();
    EClass _type_1 = metaClass.getType();
    String _fullPackageName = MetaModel.fullPackageName(_type_1);
    String fullPackage = _fullPackageName;
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
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import ");
    _builder.append(fullPackage, "");
    _builder.append(".");
    String _name_2 = this.e1.getName(metaClass);
    _builder.append(_name_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(fullPackage, "");
    _builder.append(".");
    String _firstUpper = StringExtensions.toFirstUpper(pack);
    _builder.append(_firstUpper, "");
    _builder.append("Factory;");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.ICreateContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.impl.AbstractCreateFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Diagram;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.Graphiti;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.CoreException;");
    _builder.newLine();
    _builder.append("import ");
    String _util_package = GeneratorUtil.util_package();
    _builder.append(_util_package, "");
    _builder.append(".SampleUtil;");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.ContainerShape;");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractCreateFeature {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private static final String TITLE = \"Create ");
    String _visibleName = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName, "    ");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("private static final String USER_QUESTION = \"Enter new ");
    String _visibleName_1 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_1, "    ");
    _builder.append(" name\";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("public final static String typeOrAliasName = \"");
    String _visibleName_2 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_2, "    ");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("// set name and description of the creation feature");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(fp, \"");
    String _visibleName_3 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_3, "        ");
    _builder.append("\", \"Create ");
    String _visibleName_4 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_4, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean canCreate(ICreateContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return context.getTargetContainer() instanceof Diagram;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected ");
    String _name_3 = this.e1.getName(metaClass);
    _builder.append(_name_3, "    ");
    _builder.append(" newClass = null;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public Object[] create(final ICreateContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("newClass = create");
    String _visibleName_5 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_5, "        ");
    _builder.append("(context);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (newClass == null ) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return EMPTY;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// do the add");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("addGraphicalRepresentation(context, newClass);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// return newly created business object(s)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new Object[] { newClass };");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected ");
    String _name_4 = this.e1.getName(metaClass);
    _builder.append(_name_4, "    ");
    _builder.append(" create");
    String _visibleName_6 = GeneratorUtil.visibleName(metaClass);
    _builder.append(_visibleName_6, "    ");
    _builder.append("(ICreateContext context) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("// ask user for ");
    _builder.append(className, "        ");
    _builder.append(" name");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("String newName = SampleUtil.askString(TITLE, USER_QUESTION, \"\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (newName == null || newName.trim().length() == 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("// create ");
    String _name_5 = this.e1.getName(metaClass);
    _builder.append(_name_5, "         ");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    String _name_6 = this.e1.getName(metaClass);
    _builder.append(_name_6, "        ");
    _builder.append(" newClass = ");
    String _firstUpper_1 = StringExtensions.toFirstUpper(pack);
    _builder.append(_firstUpper_1, "        ");
    _builder.append("Factory.eINSTANCE.create");
    String _name_7 = this.e1.getName(metaClass);
    _builder.append(_name_7, "        ");
    _builder.append("();    ");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("newClass.setName(newName);     ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//  default is to add it to a file resource, which is created if it does not exist.");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("SampleUtil.saveToModelFile(newClass, getDiagram(), \"");
    Diagram _diagram_1 = metaClass.getDiagram();
    String _modelfileExtension = _diagram_1.getModelfileExtension();
    String _lowerCase = _modelfileExtension.toLowerCase();
    _builder.append(_lowerCase, "            ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("} catch (CoreException e) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return newClass;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      boolean _operator_and = false;
      String _icon = metaClass.getIcon();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_icon, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        String _icon_1 = metaClass.getIcon();
        boolean _equalsIgnoreCase = _icon_1.equalsIgnoreCase("");
        boolean _operator_not = BooleanExtensions.operator_not(_equalsIgnoreCase);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_not);
      }
      if (_operator_and) {
        _builder.append("    ");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("public String getCreateImageId() {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("    ");
        _builder.append("return ");
        Diagram _diagram_2 = metaClass.getDiagram();
        String _name_8 = _diagram_2.getName();
        _builder.append(_name_8, "        ");
        _builder.append("ImageProvider.");
        Diagram _diagram_3 = metaClass.getDiagram();
        String _name_9 = _diagram_3.getName();
        _builder.append(_name_9, "        ");
        _builder.append("_");
        String _icon_2 = metaClass.getIcon();
        String _base = GeneratorUtil.base(_icon_2);
        _builder.append(_base, "        ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
    _builder.append("    ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}