package org.eclipselabs.spray.generator.graphiti.templates

import javax.inject.Inject
import org.eclipselabs.spray.generator.graphiti.util.NamingExtensions
import org.eclipselabs.spray.mm.spray.Diagram
import org.eclipselabs.spray.xtext.generator.FileGenerator

import static org.eclipselabs.spray.generator.common.GeneratorUtil.*

class ExecutableExtensionFactory extends FileGenerator<Diagram>  {
    @Inject extension NamingExtensions
    
    override CharSequence generateBaseFile(Diagram modelElement) {
        mainFile( modelElement, javaGenFile.className)
    }

    def mainFile(Diagram diagram, String className) '''
        «header(this)»
        package «javaGenFile.packageName»;

        import com.google.inject.Injector;
        import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
        import org.osgi.framework.Bundle;
        import «main_package()».Activator;
        public class «className» extends AbstractGuiceAwareExecutableExtensionFactory {
        
            «overrideHeader»
            protected Bundle getBundle() {
                return «diagram.activatorSimpleClassName».getDefault().getBundle();
            }
        
            «overrideHeader»
            protected Injector getInjector() {
                return «diagram.activatorSimpleClassName».getDefault().getInjector();
            }
        
        }

   '''
}
