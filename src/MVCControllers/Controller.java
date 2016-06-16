/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

/**
 *
 * @author Minh Nhat
 */
public interface Controller {
    void setParent (Controller parent);
    void setParentVisiableFalse();
    void setParentVisiableTrue();
}
