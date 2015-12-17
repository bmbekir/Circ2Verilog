/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.Logisim.Components.Wiring.Wire;
import Circ2Verilog.Logisim.Components.Gates.*;
import Circ2Verilog.Logisim.Components.Wiring.OutputPin;
import Circ2Verilog.Logisim.Components.Wiring.InputPin;
import Circ2Verilog.Logisim.XmlParser.PropertyParser;
import Circ2Verilog.Logisim.XmlParser.XmlCircComponent;
import Circ2Verilog.Logisim.XmlParser.XmlCircProperty;
import Circ2Verilog.Logisim.XmlParser.XmlCircWire;
import java.util.Locale;

/**
 *
 * @author Ebubekir
 */
public final class CircuitFactory {

    private CircuitFactory() {

    }

    public static Direction GetDirection(String name) {
        switch (name.toUpperCase()) {
            case "EAST":
                return Direction.East;
            case "WEST":
                return Direction.West;
            case "NORTH":
                return Direction.North;
            case "SOUTH":
                return Direction.South;
            default:
                throw new ExceptionInInitializerError("No DirectionType");
        }
    }

    public static Direction GetFacing(String name) {
        switch (name.toUpperCase()) {
            case "EAST":
                return Direction.East;
            case "WEST":
                return Direction.West;
            case "NORTH":
                return Direction.North;
            case "SOUTH":
                return Direction.South;
            default:
                return Direction.East;
        }
    }
    
    public static Direction GetElementDirection(String name) {
        if(name==null)
            name="";
        switch (name.toUpperCase()) {
            case "EAST":
                return Direction.East;
            case "WEST":
                return Direction.West;
            case "NORTH":
                return Direction.North;
            case "SOUTH":
                return Direction.South;
            default:
                return Direction.East;
        }
    }

    public static Direction GetLabelLocation(String name) {
        switch (name.toUpperCase()) {
            case "EARTH":
                return Direction.East;
            case "WEST":
                return Direction.West;
            case "NORTH":
                return Direction.North;
            case "SOUTH":
                return Direction.South;
            default:
                return Direction.West;
        }
    }

    public static CircuitElement ElementFactory(XmlCircComponent comp) {

        if (comp.Properties == null) {
            comp.Properties = new XmlCircProperty[0];
        }
        PropertyParser p = new PropertyParser(comp.Properties);
        CircuitElement element = null;
        int x = comp.GetPositionX();
        int y = comp.GetPositionY();
        int width = 1;

        ElementLabel label = new ElementLabel(p.get("label"), p.get("labelfont"), CircuitFactory.GetLabelLocation("labelloc"));

        String withValue = p.get("width");
        if (withValue != null) {
            width = Integer.parseInt(withValue);
        }
        int size = CircuitFactory.SizeFactory(p.get("size"));
        int len = CircuitFactory.MultiInputFactory(p.get("inputs"));
        Direction direction = CircuitFactory.GetElementDirection(p.get("facing"));

        switch (comp.Name.toUpperCase(Locale.US)) {
            case "PIN": {
                if ("true".equals(p.get("output"))) {

                    element = new OutputPin(width, x, y, label,direction);
                } else {
                    element = new InputPin(width, x, y, label,direction);
                }
            }
            break;
            case "AND GATE":
                element = new GateAnd(width, x, y, label,direction, size, len);
                break;
            case "OR GATE":
                element = new GateOr(width, x, y, label,direction, size, len);
                break;
            case "NOT GATE":
                element = new GateNot(width, x, y, label,direction, size==50?30:size);
                break;
            default:
                element = new CircuitElement(x, y, label,direction ,comp.Name);
                break;
        }

        return element;
    }

    public static Wire WireFactory(XmlCircWire w) {
        Wire w2 = new Wire(w.ToX, w.ToY, w.FromX, w.FromY);
        return w2;
    }

    public static int SizeFactory(String size) {
        if (size == null) {
            return 50;
        }
        return Integer.parseInt(size);
    }

    public static int MultiInputFactory(String length) {
        if (length == null) {
            return 5;
        }
        return Integer.parseInt(length);
    }
    
    
    
    
    
    

}
