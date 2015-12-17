/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.Logisim.XmlParser.*;
import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Ebubekir
 */
public class CircParser {

    private String fileName;
    private XmlCircProject project;

    public String GetCircNames() {
        String[] strs = fileName.replace("\\", "/").split("/");
        return strs[strs.length - 1];
    }

    private HashMap<String, Circuit> Circuits;

    private XmlCircuit FindCircuit(String name) {
        for (XmlCircuit Circuit : project.Circuits) {
            if (Circuit.name == null ? name == null : Circuit.name.equals(name)) {
                return Circuit;
            }
        }

        return null;
    }

    public Circuit GetCircuitWithName(String name) throws Exception {
        XmlCircuit c = FindCircuit(name);
        if (c == null) {
            throw new Exception("Circuit not Found!");
        }
        Circuit circ=Circuits.get(name);
        
        if (circ == null) {
            circ = new Circuit();
            PropertyParser p = new PropertyParser(c.Properties);
            circ.setCircuitName(c.name);
            circ.setSharedLabel(new ElementLabel(p.get("clabel"), p.get("clabelfont"), CircuitFactory.GetLabelLocation(p.get("clabelup"))));
            if(c.Components==null)
            c.Components= new XmlCircComponent[0];
            CircuitElement ce;
            for (XmlCircComponent Component : c.Components) {
                ce=CircuitFactory.ElementFactory(Component);
                circ.addComponent(ce);
                circ.addConnectors(ce.getConnectors());
            }
            XmlCircWire[] wires= c.Wires;
            if (wires==null) {
                wires= new XmlCircWire[0];
            }
            for (XmlCircWire wire : wires) {
                circ.addWire(CircuitFactory.WireFactory(wire));
            }
        }
        return circ;
    }

    public CircParser(String fileName) throws JAXBException {
        this.fileName = fileName;
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlCircProject.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        project = (XmlCircProject) jaxbUnmarshaller.unmarshal(new File(fileName));
        this.Circuits = new HashMap<String, Circuit>();

    }

    public String GetProjectVersion() {
        return project.version;
    }

    public String GetProjectSource() {
        return project.source;
    }

    public String GetMainCircuitName() {
        return project.mainProject.Name;
    }

    public String[] GetCircuitNames() {
        String[] names = new String[project.Circuits.length];

        for (int i = 0; i < names.length; i++) {
            names[i] = project.Circuits[i].name;
        }
        return names;
    }
}
