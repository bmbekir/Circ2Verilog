/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

/**
 *
 * @author Ebubekir
 */
public class ElementLabel {
    private String Text;
    private String Font;
    private Direction Facing;

    public ElementLabel(String Text, String Font, Direction Facing) {
        this.Text = Text;
        this.Font = Font;
        this.Facing = Facing;
    }

    public String getText() {
        return Text;
    }

    public String getFont() {
        return Font;
    }

    public Direction getFacing() {
        return Facing;
    }
    
}
