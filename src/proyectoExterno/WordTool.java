public class WordTool
{
    static char ExtraerPrimerLetra(String palabra)
    {
        return palabra.charAt(0);
    }

    static boolean EsEntero(String num)
    {
        boolean desicion = false;
        try {
            int n = Integer.parseInt(num);

            Integer.parseInt(num);
            desicion = true;

        }catch (Exception e)
        {

        }
        return desicion;
    }
}
