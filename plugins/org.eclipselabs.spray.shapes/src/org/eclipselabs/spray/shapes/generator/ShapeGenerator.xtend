/*
 * generated by Xtext
 */
package org.eclipselabs.spray.shapes.generator

import com.google.inject.Inject
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipselabs.spray.shapes.ConnectionDefinition
import org.eclipselabs.spray.shapes.ShapeContainerElement
import org.eclipselabs.spray.shapes.ShapeDefinition

import static org.eclipselabs.spray.shapes.generator.ImageConstants.*
import static org.eclipselabs.spray.shapes.generator.ShapeGenerator.*
import org.eclipselabs.spray.generator.common.ProjectProperties

class ShapeGenerator implements IGenerator {

	@Inject GeneratorShapeDefinition shapeDefinition
    @Inject GeneratorConnectionDefinition connectionDefinition 
    @Inject GeneratorSVGDefinition svgDefinition 
    private static Log   LOGGER       = LogFactory::getLog("ShapeGenerator");
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        LOGGER.info("Spray generating shapes for model " + resource.URI)
        ProjectProperties::setModelUri(resource.URI)
        if( ! resource.loaded ){
            resource.load(null);
        }
   		val svgOutputConfName = "svgOutputConf"
   		fsa.addSVGOutputConfiguration(svgOutputConfName)
        for(shapeContainerElement : resource.allContents.toIterable.filter(typeof(ShapeContainerElement))) {
            fsa.generateJava(shapeContainerElement)
        }
        for(shapeContainerElement : resource.allContents.toIterable.filter(typeof(ShapeContainerElement))) {
            val svgContent = svgDefinition.compile(shapeContainerElement)
            fsa.generateFile(svgDefinition.filepath(shapeContainerElement), svgOutputConfName, svgContent)
        }
	}
	
	def private dispatch generateJava(IFileSystemAccess fsa, ShapeDefinition shape) {
           fsa.generateFile(shapeDefinition.filepath(shape), shapeDefinition.compile(shape))
	}
	
	def private dispatch generateJava(IFileSystemAccess fsa, ConnectionDefinition connection) {
		fsa.generateFile(connectionDefinition.filepath(connection), connectionDefinition.compile(connection))
	}	
	
	def private addSVGOutputConfiguration(IFileSystemAccess fsa, String svgOutputConfName) {
   		fsa.addImageOutputConfiguration(svgOutputConfName, SVG_PATH)
	}	
	
	def private addImageOutputConfiguration(IFileSystemAccess fsa, String outputConfName, String path) {
   		if(fsa instanceof AbstractFileSystemAccess) {
   			val aFsa = fsa as AbstractFileSystemAccess
   			if(!aFsa.outputConfigurations.containsKey(outputConfName)) {
	   			val outputConfigurations = <String, OutputConfiguration> newHashMap
	   			outputConfigurations.putAll(aFsa.outputConfigurations)
	   			val imageOutputConfiguration = new OutputConfiguration(outputConfName)
	   			imageOutputConfiguration.outputDirectory = path
	   			imageOutputConfiguration.createOutputDirectory = true
	   			imageOutputConfiguration.overrideExistingResources = true
	   			imageOutputConfiguration.setDerivedProperty = true
	   			outputConfigurations.put(outputConfName, imageOutputConfiguration) 
	   			aFsa.setOutputConfigurations(outputConfigurations)
   			}
   		}
	}	
}
