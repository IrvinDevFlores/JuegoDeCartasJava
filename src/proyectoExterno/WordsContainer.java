import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;

public class WordsContainer
{
    Cola ColaDeLetras;
    final char[] Abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                                 'm', 'n','ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public WordsContainer()
    {

    }

    void CrearPilaDeLetras()
    {
        ColaDeLetras = new Cola();
        for(int i = 0; i < Abecedario.length; i ++)
        {
            ColaDeLetras.Encolar(new Cola());
        }
        JOptionPane.showMessageDialog(null,"La pial se creo correctamente");
    }
    final int nums[] = {0,1,2,3,4,5,6,7,8,9};
    void IngresaUnaPalabraAlDiccionario()
    {
        String palabra = JOptionPane.showInputDialog(null,"Ingrese una palabra");
        char PrimerLetra = WordTool.ExtraerPrimerLetra(palabra);
        int Indice = 0;
        for(int i = 0; i < Abecedario.length; i++)
        {
            char letraEnAbecedario = Abecedario[i];

            String l1 = Character.toString(PrimerLetra);
            String l2 = Character.toString(letraEnAbecedario);
            if(l1.equalsIgnoreCase(l2))
            {
                Indice = i;
                Cola PalabrasConLetraEncontrada = (Cola) (ColaDeLetras.arr[Indice]);
                PalabrasConLetraEncontrada.Encolar(palabra);

                ColaDeLetras.arr[Indice] = PalabrasConLetraEncontrada;
                JOptionPane.showMessageDialog(null,"Palabra agregada correctamente");
            }
        }
    }

    Cola BuscarListaDePalabrasPorLetra()
    {
        String letra = JOptionPane.showInputDialog(null,"Ingrese una letra");
        char PrimerLetra = letra.charAt(0);
        int Indice = 0;
        Cola cola = new Cola();
        for(int i = 0; i < Abecedario.length; i++)
        {
            char letraEnAbecedario = Abecedario[i];
            String l1 = Character.toString(PrimerLetra);
            String l2 = Character.toString(letraEnAbecedario);
            if(l1.equalsIgnoreCase(l2))
            {
                Indice = i;
                cola = (Cola) ColaDeLetras.arr[Indice];
                JOptionPane.showMessageDialog(null,"Letra encontrada "+l2);
            }
        }
        return cola;
    }

    String BuscarPalabra()
    {
        String palabra = JOptionPane.showInputDialog(null,"Ingrese la palabra a buscar :");
        char PrimerLetra = WordTool.ExtraerPrimerLetra(palabra);
        int Indice = 0;
        String palabraEncontrada = "";
        for(int i = 0; i < Abecedario.length; i++)
        {
            char letraEnAbecedario = Abecedario[i];

            String l1 = Character.toString(PrimerLetra);
            String l2 = Character.toString(letraEnAbecedario);
            if(l1.equalsIgnoreCase(l2))
            {
                Indice = i;
                Cola PalabrasConLetraEncontrada = (Cola) (ColaDeLetras.arr[Indice]);

                for(int j = 0; j < PalabrasConLetraEncontrada.arr.length; j++)
                {
                    String palabraEnCola = PalabrasConLetraEncontrada.arr[Indice].toString();
                    if(palabraEnCola.equalsIgnoreCase(palabra))
                    {
                        palabraEncontrada = PalabrasConLetraEncontrada.arr[Indice].toString();
                    }

                }

            }
        }

        return palabraEncontrada;
    }

}
