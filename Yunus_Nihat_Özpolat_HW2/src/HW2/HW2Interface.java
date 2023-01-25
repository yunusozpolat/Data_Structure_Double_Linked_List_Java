/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HW2;

/**
 *
 * @author PC
 */
public interface HW2Interface {
    public void Insert(int newElement, int pos) throws Exception;
    public int Delete(int pos) throws Exception;
    public void LinkReverse();
    public void SacuraL();
    public void OpacuraL();
    public void Output();
    public void ReverseOutput();
    @Override
    public String toString();
    public Exception LinkedListException();
}
