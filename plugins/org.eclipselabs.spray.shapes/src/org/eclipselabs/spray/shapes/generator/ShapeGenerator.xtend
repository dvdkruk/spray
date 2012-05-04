/*
 * generated by Xtext
 */
package org.eclipselabs.spray.shapes.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipselabs.spray.shapes.shapes.ConnectionDefinition
import org.eclipselabs.spray.shapes.shapes.ShapeDefinition

class ShapeGenerator implements IGenerator {

	@Inject GeneratorShapeDefinition shapeDefinition
    @Inject GeneratorConnectionDefinition connectionDefinition 
    @Inject GeneratorSVGDefinition svgDefinition 
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		for(shape : resource.allContents.toIterable.filter(typeof(ShapeDefinition))) {
    		// create the Shapes
            fsa.generateFile(shapeDefinition.filepath(shape), shapeDefinition.compile(shape))
            fsa.generateFile(svgDefinition.filepath(shape), svgDefinition.compile(shape))
   		}
   		for(connection : resource.allContents.toIterable.filter(typeof(ConnectionDefinition))) {
      		// create the connections
   			fsa.generateFile(connectionDefinition.filepath(connection), connectionDefinition.compile(connection))
            fsa.generateFile(svgDefinition.filepath(connection), svgDefinition.compile(connection))
   		}
	}
	
}
