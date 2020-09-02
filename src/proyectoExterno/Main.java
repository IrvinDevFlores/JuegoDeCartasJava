import javax.swing.*;

public class Main
{
    public static  void main(String args[])
    {
        WordsContainer wordsContainer = new WordsContainer();
        while (true)
        {
            String mensaje = "1. Crear cola \n 2. Ingresar palabra \n 3. Buscar lista de palabras por letra \n 4. Buscar palabra \n";
            String op = JOptionPane.showInputDialog(null,mensaje);
            boolean NoEsEntero = WordTool.EsEntero(op) ? false : true;
            if(NoEsEntero)
            {
                JOptionPane.showMessageDialog(null,"El numero no es entero");
                continue;
            }
            int opcion = Integer.parseInt(op);
            switch (opcion)
            {
                case 1:
                    wordsContainer.CrearPilaDeLetras();
                    break;
                case 2:
                    wordsContainer.IngresaUnaPalabraAlDiccionario();
                    break;
                case 3:
                    Cola cola = wordsContainer.BuscarListaDePalabrasPorLetra();

                    String men = cola.Imprimir("Las palabras encontradas son");
                    JOptionPane.showMessageDialog(null,men);
                    break;
                case 4:
                   String m = wordsContainer.BuscarPalabra();
                    if(m.equals(""))
                    {
                        m = "No existe";
                    }
                   JOptionPane.showMessageDialog(null,m);
                    break;
                case 5:
                    break;
            }
        }
    }
}
