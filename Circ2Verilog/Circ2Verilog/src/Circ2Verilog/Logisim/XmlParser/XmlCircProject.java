/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.XmlParser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ebubekir
 */
@XmlRootElement(name="project")
public class XmlCircProject {
    @XmlAttribute(name="source")
    public String source;
    
    @XmlAttribute(name="version")
    public String version;
    
    @XmlElement(name="main")
    public XmlCircProperty mainProject;
    
    @XmlElement(name="circuit")
    public XmlCircuit[] Circuits;
}
