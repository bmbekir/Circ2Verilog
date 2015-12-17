/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.XmlParser;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ebubekir
 */
public class XmlCircProperty {

    @XmlAttribute(name = "name")
    public String Name;
    
    @XmlAttribute(name = "val")
    public String Value;
    
}
