/*
 * generated by Xtext
 */
package org.eclipselabs.spray.generator.graphiti

import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class SprayGenerator implements IGenerator {
    @Inject
    SprayGraphitiGenerator graphitiGenerator
//    @Inject
//    JvmModelGenerator jvmModelGenerator

    override void doGenerate(Resource resource, IFileSystemAccess fsa) {  
        // jvmModelGenerator.doGenerate(resource, fsa)
        graphitiGenerator.doGenerate(resource, fsa)
    }


}
