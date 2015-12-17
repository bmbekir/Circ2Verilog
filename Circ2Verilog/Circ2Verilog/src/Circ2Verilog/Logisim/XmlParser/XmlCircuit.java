/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.XmlParser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Ebubekir
 */
public class XmlCircuit {
    
    @XmlAttribute
    public String name;
    
    @XmlElement(name="a")
    public XmlCircProperty[] Properties;
    
    @XmlElement(name="comp")
    public XmlCircComponent[] Components;
    
    @XmlElement(name="wire")
    public XmlCircWire[] Wires;
    
}
