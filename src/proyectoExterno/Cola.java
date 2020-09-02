import javax.swing.*;

public class Cola
{

    public static void main(String args[])
    {
        Cola cola = new Cola();
        cola.Encolar("1");
        cola.Encolar("2");
        cola.Encolar("3");
        cola.Encolar("4");
        cola.Encolar("5");

        String DatosEnCola = cola.Imprimir("Array oringial: ");
        JOptionPane.showMessageDialog(null,DatosEnCola);

        String DatosNuevosEnCola = cola.Imprimir("Array oringial: ");
        JOptionPane.showMessageDialog(null,DatosEnCola);
    }
    Object[] arr;
    public Cola()
    {
        arr = new Object[0];
    }

    void Encolar(Object obj){
        Object[] arrTemp = new Object[arr.length + 1];
        for(int i = 0; i < arr.length; i++)
        {
            arrTemp[i] = arr[i];
        }

        arr = arrTemp;
        arr[arr.length - 1] = obj;
    }

    void Desencolar()
    {
        Object[] ArrTemp = arr;
        Object[] NuevoArreglo = new Object[arr.length - 1];
        for(int i = 0; i < NuevoArreglo.length; i++)
        {
            NuevoArreglo[i] = ArrTemp[i + 1];
        }
        arr = NuevoArreglo;
    }

    Object Primero()
    {
        return arr[0];
    }

    boolean EstaVacia(){
        return (arr.length == 0) ? true:false;
    }

    String Imprimir(String mensajeParaImprimir)
    {
        String StringAImprimir = "";
        for(Object dato : arr)
        {
            StringAImprimir += dato.toString() + "\n";
        }

        return String.format("%s\n%s",mensajeParaImprimir,StringAImprimir);
    }


}
