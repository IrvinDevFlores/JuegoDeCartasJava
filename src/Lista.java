public class Lista
{
    Nodo primero, ultimo;
    int Length;

    public Lista()
    {
        Length = 0;
        primero = ultimo = null;
    }

    public void InsertarNodoEnPosicion(int pos, Nodo Nodo)
    {
        if(EstaVacio())
        {
            InsertarInicio(Nodo);
        }else if(Length == 1)
        {
            if((int) Nodo.Info < (int) primero.Info)
            {
                InsertarInicio(Nodo);
            }else{
                InsertarFinal(Nodo);
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

                Nodo.Siguiente = actual;
                anterior.Siguiente = Nodo;
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
    }

    public void InsertarNodoAsc(Nodo n)
    {
        Nodo temp = primero;
        if(EstaVacio())
        {
            InsertarInicio(n);
        }else if(Length == 1)
        {
            Carta cartaEnNodo = (Carta)temp.Info;
            Carta numeroDeCarta = ((Carta)n.Info);

            if( cartaEnNodo.Numero < numeroDeCarta.Numero)
            {
                InsertarFinal(n);
            }else
            {
                InsertarInicio(n);
            }
        }
        else{
            Carta carta = (Carta) n.Info;
            Carta numeroCarta = (Carta) primero.Info;

            int numeroEnCarta = carta.Numero;
            int numeroNodo = numeroCarta.Numero;

            Carta ultima = (Carta) ultimo.Info;
            int ultim = ultima.Numero;
            if (numeroEnCarta < numeroNodo ) {
                InsertarInicio(n);

            } else if (ultim <= numeroEnCarta) {
                InsertarFinal(n);
            }
            else
            {
                Nodo actual = primero;

                int x = 0;
                Carta ac = null;
                while (actual.Siguiente != null &&  ac.Numero < numeroEnCarta) {
                    actual = actual.Siguiente;
                     ac = (Carta) actual.Siguiente.Info;
                }
                n.Siguiente = actual.Siguiente;
                actual.Siguiente = n;
                Length++;
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
            Length++;
        }


    }

    public int contar(Nodo Nodo)
    {
        int cont = 0;
        Nodo temp = primero;
        while(temp != null)
        {
            if(Nodo.equals(temp.Info))
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
