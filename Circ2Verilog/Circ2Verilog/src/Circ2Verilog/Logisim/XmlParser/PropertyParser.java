/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.XmlParser;

import java.util.HashMap;

/**
 *
 * @author Ebubekir
 */
public class PropertyParser {
    private final HashMap<String, String> properties;

    public PropertyParser(XmlCircProperty[] properties) {
        this.properties= new HashMap<String,String>();
        for (XmlCircProperty property : properties) {
            this.properties.put(property.Name, property.Value);
        }
    }
    
    public String get(String name)
    {
        return this.properties.get(name);
    }
    
}
