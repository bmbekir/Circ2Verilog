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
public class XmlCircComponent {
    
    @XmlAttribute(name="name")
    public String Name;
    @XmlAttribute(name="loc")
    public String loc;
    @XmlElement(name="a")
    public XmlCircProperty[] Properties;
    
    public int GetPositionX()
    {
        return Integer.parseInt( loc.split(",")[0].replace("(", ""));
    }
    
    public int GetPositionY()
    {
        return Integer.parseInt( loc.split(",")[1].replace(")", ""));
    }
}
