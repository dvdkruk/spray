package org.eclipselabs.spray.generator.graphiti.templates.features;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.NamingExtensions;
import org.eclipselabs.spray.generator.graphiti.util.mm.MetaReferenceExtensions;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.MetaReference;

@SuppressWarnings("all")
public class CreateReferenceAsConnectionFeature extends FileGenerator {
  @Inject
  private NamingExtensions _namingExtensions;
  
  @Inject
  private MetaReferenceExtensions _metaReferenceExtensions;
  
  public CharSequence generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    CharSequence _mainFile = this.mainFile(((MetaReference) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public CharSequence generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    CharSequence _mainExtensionPointFile = this.mainExtensionPointFile(((MetaReference) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public CharSequence mainExtensionPointFile(final MetaReference metaReference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    CharSequence _extensionHeader = this.extensionHeader(this);
    _builder.append(_extensionHeader, " ");
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
    _builder.append("//    /**");
    _builder.newLine();
    _builder.append("//     * {@inheritDoc}");
    _builder.newLine();
    _builder.append("//     */");
    _builder.newLine();
    _builder.append("//    @Override");
    _builder.newLine();
    _builder.append("//    public String getCreateImageId() {");
    _builder.newLine();
    _builder.append("//        return ");
    Diagram _diagram = this._metaReferenceExtensions.getDiagram(metaReference);
    String _imageProviderSimpleClassName = this._namingExtensions.getImageProviderSimpleClassName(_diagram);
    _builder.append(_imageProviderSimpleClassName, "");
    _builder.append(".");
    Diagram _diagram_1 = this._metaReferenceExtensions.getDiagram(metaReference);
    String _name = _diagram_1.getName();
    String _upperCase = _name.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("__MYIMAGEID;");
    _builder.newLineIfNotEmpty();
    _builder.append("//    }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence mainFile(final MetaReference reference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    MetaClass _metaClass = reference.getMetaClass();
    Diagram _diagram = _metaClass.getDiagram();
    String _name = _diagram.getName();
    final String diagramName = _name;
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
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.ICreateConnectionContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.impl.AddConnectionContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Anchor;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Connection;");
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;");
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.runtime.graphiti.features.AbstractCreateConnectionFeature;");
    _builder.newLine();
    _builder.append("// MARKER_IMPORT");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractCreateConnectionFeature {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_additionalFields = this.generate_additionalFields(reference);
    _builder.append(_generate_additionalFields, "    ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    CharSequence _generate_constructor = this.generate_constructor(reference, className);
    _builder.append(_generate_constructor, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_canCreate = this.generate_canCreate(reference);
    _builder.append(_generate_canCreate, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_canStartConnection = this.generate_canStartConnection(reference);
    _builder.append(_generate_canStartConnection, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_create = this.generate_create(reference);
    _builder.append(_generate_create, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_getMetaClassForReference = this.generate_getMetaClassForReference(reference);
    _builder.append(_generate_getMetaClassForReference, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_getReferenceTargetAnchor = this.generate_getReferenceTargetAnchor(reference);
    _builder.append(_generate_getReferenceTargetAnchor, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_createTargetType = this.generate_createTargetType(reference);
    _builder.append(_generate_createTargetType, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generate_additionalFields_1 = this.generate_additionalFields(reference);
    _builder.append(_generate_additionalFields_1, "    ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_constructor(final MetaReference reference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    _builder.append("public ");
    _builder.append(className, "");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("// set name and description of the creation feature");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this(fp, \"");
    String _name = target.getName();
    _builder.append(_name, "    ");
    _builder.append("\", \"Create ");
    String _name_1 = target.getName();
    _builder.append(_name_1, "    ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.append("protected ");
    _builder.append(className, "");
    _builder.append("(IFeatureProvider fp, String name, String description) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("// provide name and description for the UI, e.g. the palette");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("super(fp, name, description);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_canCreate(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    CharSequence _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean canCreate(ICreateConnectionContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// return true if both anchors belong to an EClass");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// and those EClasses are not identical");
    _builder.newLine();
    _builder.append("    ");
    MetaClass _metaClass = reference.getMetaClass();
    String _javaInterfaceName = this._namingExtensions.getJavaInterfaceName(_metaClass);
    String _shortName = this._namingExtensions.shortName(_javaInterfaceName);
    _builder.append(_shortName, "    ");
    _builder.append(" source = get");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name, "    ");
    _builder.append("(context.getSourceAnchor());");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    EClass _eReferenceType = target.getEReferenceType();
    String _javaInterfaceName_1 = this._namingExtensions.getJavaInterfaceName(_eReferenceType);
    String _shortName_1 = this._namingExtensions.shortName(_javaInterfaceName_1);
    _builder.append(_shortName_1, "    ");
    _builder.append(" target = get");
    String _name_1 = target.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "    ");
    _builder.append("(context.getTargetAnchor());");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("if ( (source != null) && (target != null) && (source != target) ) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_canStartConnection(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    CharSequence _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean canStartConnection(ICreateConnectionContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// return true if start anchor belongs to a EClass");
    _builder.newLine();
    _builder.append("    ");
    MetaClass _metaClass = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass);
    _builder.append(_name, "    ");
    _builder.append(" ");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_1);
    String _firstLower = StringExtensions.toFirstLower(_name_1);
    _builder.append(_firstLower, "    ");
    _builder.append(" = (");
    MetaClass _metaClass_2 = reference.getMetaClass();
    String _name_2 = this._namingExtensions.getName(_metaClass_2);
    _builder.append(_name_2, "    ");
    _builder.append(") get");
    MetaClass _metaClass_3 = reference.getMetaClass();
    String _name_3 = this._namingExtensions.getName(_metaClass_3);
    _builder.append(_name_3, "    ");
    _builder.append("(context.getSourceAnchor());");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("if (");
    MetaClass _metaClass_4 = reference.getMetaClass();
    String _name_4 = this._namingExtensions.getName(_metaClass_4);
    String _firstLower_1 = StringExtensions.toFirstLower(_name_4);
    _builder.append(_firstLower_1, "    ");
    _builder.append(" == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _operator_and = false;
      boolean _isMany = target.isMany();
      if (!_isMany) {
        _operator_and = false;
      } else {
        int _upperBound = target.getUpperBound();
        boolean _operator_greaterEqualsThan = IntegerExtensions.operator_greaterEqualsThan(_upperBound, 0);
        _operator_and = BooleanExtensions.operator_and(_isMany, _operator_greaterEqualsThan);
      }
      if (_operator_and) {
        _builder.append("    ");
        _builder.append("// multi-valued reference with fixed upper bound. can only be started if maximum size is not reached yet");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("final int maxSize = ");
        int _upperBound_1 = target.getUpperBound();
        _builder.append(_upperBound_1, "    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("return ");
        MetaClass _metaClass_5 = reference.getMetaClass();
        String _name_5 = this._namingExtensions.getName(_metaClass_5);
        String _firstLower_2 = StringExtensions.toFirstLower(_name_5);
        _builder.append(_firstLower_2, "    ");
        _builder.append(".get");
        String _name_6 = target.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_6);
        _builder.append(_firstUpper, "    ");
        _builder.append("().size() < maxSize;");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _isMany_1 = target.isMany();
        boolean _operator_not = BooleanExtensions.operator_not(_isMany_1);
        if (_operator_not) {
          _builder.append("    ");
          _builder.append("// single valued reference. can only be started if the reference is not set yet.");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("return ");
          MetaClass _metaClass_6 = reference.getMetaClass();
          String _name_7 = this._namingExtensions.getName(_metaClass_6);
          String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
          _builder.append(_firstLower_3, "    ");
          _builder.append(".get");
          String _name_8 = target.getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_8);
          _builder.append(_firstUpper_1, "    ");
          _builder.append("() == null;");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_create(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("    ");
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("public Connection create(ICreateConnectionContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Connection newConnection = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// get EClasses which should be connected");
    _builder.newLine();
    _builder.append("        ");
    MetaClass _metaClass = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass);
    _builder.append(_name, "        ");
    _builder.append(" source = get");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name_1, "        ");
    _builder.append("(context.getSourceAnchor());");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    EClass _eReferenceType = target.getEReferenceType();
    String _name_2 = _eReferenceType.getName();
    _builder.append(_name_2, "        ");
    _builder.append(" target = get");
    String _name_3 = target.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper, "        ");
    _builder.append("(context.getTargetAnchor());");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (source != null && target != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("// create new business object");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("set");
    String _name_4 = target.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper_1, "            ");
    _builder.append("(source, target);");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("// add connection for business object");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("AddConnectionContext addContext = new AddConnectionContext( context.getSourceAnchor(), context.getTargetAnchor());");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("addContext.setNewObject(source);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("addContext.putProperty(ISprayConstants.PROPERTY_REFERENCE, ");
    String _literalConstant = this._namingExtensions.getLiteralConstant(reference);
    _builder.append(_literalConstant, "            ");
    _builder.append(".getName());");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("// TODO: assume that the target object has a Name property");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//        addContext.putProperty(\"TARGETOBJECT\", target.getName());");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return newConnection;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_getMetaClassForReference(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Returns the ");
    MetaClass _metaClass = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass);
    _builder.append(_name, " ");
    _builder.append(" belonging to the anchor, or <code>null</code> if not available.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected ");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name_1, "");
    _builder.append(" get");
    MetaClass _metaClass_2 = reference.getMetaClass();
    String _name_2 = this._namingExtensions.getName(_metaClass_2);
    _builder.append(_name_2, "");
    _builder.append("(Anchor anchor) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("if (anchor != null) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object object = getBusinessObjectForPictogramElement(anchor.getParent());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (object instanceof ");
    MetaClass _metaClass_3 = reference.getMetaClass();
    String _name_3 = this._namingExtensions.getName(_metaClass_3);
    _builder.append(_name_3, "        ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("return (");
    MetaClass _metaClass_4 = reference.getMetaClass();
    String _name_4 = this._namingExtensions.getName(_metaClass_4);
    _builder.append(_name_4, "            ");
    _builder.append(") object;");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_getReferenceTargetAnchor(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    {
      MetaClass _metaClass = reference.getMetaClass();
      String _name = this._namingExtensions.getName(_metaClass);
      String _name_1 = target.getName();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, _name_1);
      if (_operator_notEquals) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Returns the ");
        String _name_2 = target.getName();
        _builder.append(_name_2, " ");
        _builder.append(" belonging to the anchor, or <code>null</code> if not available.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected ");
        EClass _eReferenceType = target.getEReferenceType();
        String _name_3 = _eReferenceType.getName();
        _builder.append(_name_3, "");
        _builder.append(" get");
        String _name_4 = target.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper, "");
        _builder.append("(Anchor anchor) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("if (anchor != null) {");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("Object object = getBusinessObjectForPictogramElement(anchor.getParent());");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("if (object instanceof ");
        EClass _eReferenceType_1 = target.getEReferenceType();
        String _name_5 = _eReferenceType_1.getName();
        _builder.append(_name_5, "        ");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("            ");
        _builder.append("return (");
        EClass _eReferenceType_2 = target.getEReferenceType();
        String _name_6 = _eReferenceType_2.getName();
        _builder.append(_name_6, "            ");
        _builder.append(") object;");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence generate_createTargetType(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Creates a ");
    String _name = target.getName();
    _builder.append(_name, " ");
    _builder.append(" .");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void set");
    String _name_1 = target.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    MetaClass _metaClass = reference.getMetaClass();
    String _name_2 = this._namingExtensions.getName(_metaClass);
    _builder.append(_name_2, "");
    _builder.append(" source, ");
    EClass _eReferenceType = target.getEReferenceType();
    String _name_3 = _eReferenceType.getName();
    _builder.append(_name_3, "");
    _builder.append(" target) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _isMany = target.isMany();
      boolean _operator_not = BooleanExtensions.operator_not(_isMany);
      if (_operator_not) {
        _builder.append("    ");
        _builder.append("source.set");
        String _name_4 = target.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper_1, "    ");
        _builder.append("(target);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("    ");
        _builder.append("source.get");
        String _name_5 = target.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_2, "    ");
        _builder.append("().add(target);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
