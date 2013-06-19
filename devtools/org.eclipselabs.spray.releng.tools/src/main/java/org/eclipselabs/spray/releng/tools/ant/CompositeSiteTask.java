package org.eclipselabs.spray.releng.tools.ant;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class CompositeSiteTask extends Task {
    private File   repositoryPath;
    private File   compositeArtifactsXml;
    private File   compositeContentXml;
    private String versionToAdd;

    public void setRepositoryPath(File repositoryPath) {
        this.repositoryPath = repositoryPath;
    }
    
    public void setCompositeArtifactsXml(File compositeArtifactsXml) {
        this.compositeArtifactsXml = compositeArtifactsXml;
    }

    public void setCompositeContentXml(File compositeContentXml) {
        this.compositeContentXml = compositeContentXml;
    }
    
    public void setVersionToAdd(String versionToAdd) {
        this.versionToAdd = versionToAdd;
    }

    @Override
    public void execute() throws BuildException {
        if (compositeArtifactsXml==null && compositeContentXml == null && repositoryPath == null) {
            throw new BuildException("repositoryPath attribute is required, when compositeArtifactsXml and compositeContentXml are not set", getLocation());
        }
        if (versionToAdd == null) {
            throw new BuildException("versionToAdd attribute is required", getLocation());
        }
        
        modifyRepositoryDescriptorFile(compositeArtifactsXml);
        modifyRepositoryDescriptorFile(compositeContentXml);
    }

    protected void modifyRepositoryDescriptorFile(File compositeXmlFile) {
        if (compositeXmlFile == null)
            return;
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(compositeXmlFile);
            
            Element nodeTimestamp = (Element) doc.selectSingleNode("//property[@name='p2.timestamp']");
            if (nodeTimestamp==null) {
                throw new IllegalStateException("Property p2.timestamp not found");
            }
            nodeTimestamp.addAttribute("value", Long.toString(new Date().getTime()));
            
            Element nodeChildren = (Element) doc.selectSingleNode("/repository/children");
            if (nodeTimestamp==null) {
                throw new IllegalStateException("Element 'children' not found");
            }
            List children = nodeChildren.elements("child");
            int size = children.size();
            
            Element child = nodeChildren.addElement("child");
            child.addAttribute("location", versionToAdd);
            nodeChildren.addAttribute("size", Integer.toString(size+1));
            
            FileWriter fw = new FileWriter(compositeXmlFile);
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fw, format);
            writer.write(doc);
            fw.close();
        } catch (Exception e) {
            throw new BuildException(e);
        }
    }
}