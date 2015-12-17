/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.XmlParser;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Ebubekir
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class XmlCircWire {
    
    public int ToX;    
    public int ToY;
    public int FromX;
    public int FromY;

    
    @XmlAttribute(name="from")
    public void setFrom(String s)
    {
        String[] values=s.replace("(", "").replace(")", "").trim().split(",");
        
        FromX=Integer.parseInt(values[0]);        
        FromY=Integer.parseInt(values[1]);

    }
    
     @XmlAttribute(name="to")
    public void setTo(String s)
    {
       String[] values=s.replace("(", "").replace(")", "").trim().split(",");
        
        ToX=Integer.parseInt(values[0]);        
        ToY=Integer.parseInt(values[1]); 
    }
    
//    
//    @XmlAttribute(name="To")
//    public String To;
}
