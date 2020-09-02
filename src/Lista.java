import javax.swing.*;

public class Lista
{
    Nodo primero, ultimo;
    int Length;

    public Lista()
    {
        Length = 0;
        primero = ultimo = null;
    }

    public void InsertarNodoEnPosicion(int pos, Nodo nodo)
    {
        Nodo temp = primero;
        if(EstaVacio())
        {
            InsertarInicio(nodo);
        }else if(Length == 1)
        {
            if((int) nodo.Info < (int) primero.Info)
            {
                InsertarInicio(nodo);
            }else{
                InsertarFinal(nodo);
            }
        }
        else{

            int i = 0;
            Nodo actual = primero;
            Nodo anterior = null;
            while ( i < pos)
            {
                anterior = actual;
                actual = actual.Siguiente;

                if(actual == null)
                {
                    break;
                }

                nodo.Siguiente = actual;
                anterior.Siguiente = nodo;
                i++;
            }
        }

    }

    public void EliminarPosicion(int pos)
    {
        Nodo temp = primero;
        if(pos == 0)
        {
            primero = temp.Siguiente;
            Length--;

            return;
        }

        for(int i = 0; temp != null && i < pos - 1; i++)
        {
            temp = temp.Siguiente;
        }

        if(temp == null || temp.Siguiente == null)
        {
            return;
        }
        Nodo siguiente = temp.Siguiente.Siguiente;
        temp.Siguiente = siguiente;
        Length--;
    }


    public void InsertarNodoAsc(Nodo n)
    {
        Nodo temp = primero;
        if(EstaVacio())
        {
            InsertarInicio(n);
        }else if(Length == 1)
        {

        }
        else{

            int i = 0, j = 0;

            int keyDelNodo = (int) n.Info;
            if( keyDelNodo < (int)primero.Info )
            {
                InsertarInicio(n);

            }
            else if((int) ultimo.Info <= keyDelNodo)
            {
                InsertarFinal(n);
            }
            else
            {
                Nodo actual = primero;

                while (actual.Siguiente != null  && (int) actual.Siguiente.Info < keyDelNodo)
                {
                    actual = actual.Siguiente;
                }
                n.Siguiente = actual.Siguiente;
                actual.Siguiente = n;
            }

        }

    }

    public void InsertarNodoDesc(Nodo n)
    {
        int key = (int)n.Info;
        int ultimoNumero =(int) ultimo.Info;
        if(EstaVacio())
        {
            InsertarInicio(n);
        }
        else if( key > (int)primero.Info)
        {
            InsertarInicio(n);
        }else {
            Nodo actual = primero;

            while (actual.Siguiente != null  && (int) actual.Siguiente.Info > key)
            {
                actual = actual.Siguiente;
            }
            n.Siguiente = actual.Siguiente;
            actual.Siguiente = n;
        }


    }

//Metodos listos}

    public int contar(Nodo nodo)
    {
        int cont = 0;
        Nodo temp = primero;
        while(temp != null)
        {
            if(nodo.equals(temp.Info))
            {
                cont++;
            }
        }
        return cont;
    }

    int RetornarPosicion(Object n)
    {

        int posicion = 0 ;
        int cont = 0;
        Nodo temp = primero;
        while(temp != null)
        {
            cont++;
            if(temp.equals(n))
            {
                posicion = cont;
            }else{
                posicion = 0;
            }
            temp = temp.Siguiente;
        }
        return posicion;
    }

    void InsertarInicio(Nodo nuevoNodo)
    {
        if(EstaVacio())
        {
            primero = (ultimo = nuevoNodo);
            Length++;

        }else{
            nuevoNodo.Siguiente = primero;
            primero = nuevoNodo;
            Length++;
        }

    }

    void InsertarFinal(Nodo ultimoDato)
    {
        if(EstaVacio()){
            InsertarInicio(ultimoDato);
        }else{
            ultimo.Siguiente = ultimoDato;
            ultimo = ultimoDato;
            Length++;
        }

    }

    public void LimpiarLista()
    {
        primero = null;
        ultimo = null;
    }

    public String Imprimir()
    {
        String cadena = "Informacion \n";
        Nodo nodoTemp = primero;

        while (nodoTemp != null)
        {
            cadena += nodoTemp.ToString() + "\n";
            nodoTemp = nodoTemp.Siguiente;
        }
        return cadena;
    }

    String Invertir()
    {
        String invertido = "Informacion: \n";

        for(int i = Length; i >= 0; i--)
        {
            invertido += ObtenerNodoPorIndice(i).ToString() +"\n";
        }
        return invertido;
    }

    public Object ObtenerDatoDelNodoPorIndice(int index)
    {
        int cont = 0;
        Nodo tmp = primero;

        while (cont < index)
        {
            tmp = tmp.Siguiente;
            cont++;
        }
        return tmp.Info;
    }

    Nodo ObtenerNodoPorIndice(int posicion)
    {
        int cont = 0;
        Nodo tmp = primero;

        while (cont < posicion)
        {
            tmp = tmp.Siguiente;
            cont++;
        }
        return tmp;
    }

    int Length(){
        return Length;
    }

    boolean EstaVacio(){
        return (ultimo==null && primero ==null) ? true: false;
    }
}



