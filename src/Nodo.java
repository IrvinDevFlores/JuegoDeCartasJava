public class Nodo
{
    Object Info;
    Nodo Siguiente;

    public Nodo(Object info)
    {
        Info = info;
        Siguiente = null;
    }

    public String ToString()
    {
        return (String) Info;
    }
}
