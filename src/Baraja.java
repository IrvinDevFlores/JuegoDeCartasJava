public class Baraja {

    public  Lista barajaCartas;

    public Baraja()
    {
        barajaCartas = new Lista();
        GenerarCartas();
    }

    public void GenerarCartas()
    {
        for(int i = 0; i < 53; i++)
        {
            if(i >= 0 && i < 13)
            {
                String carpeta = "src/Img/";
                int numero = i + 1;
                String palabra = "cor.png" ;
                String ruta = carpeta + numero + palabra;
                Carta carta = new Carta(ruta,0,0);

                carta.Numero = numero;
                carta.Tipo = 'C';
                barajaCartas.InsertarFinal(new Nodo(carta));
            }

            if(i >= 13 && i < 26)
            {
                String carpeta = "src/Img/";
                int numero = i + 1 - (13);
                String palabra = "corN.png" ;
                String ruta = carpeta + numero + palabra;

                Carta carta = new Carta(ruta,0,0);
                carta.Numero = numero;
                carta.Tipo = 'N';
                barajaCartas.InsertarFinal(new Nodo(carta));
            }

            if(i >= 26 && i < 39)
            {
                String carpeta = "src/Img/";
                int numero = i + 1 - (26);
                String palabra = "dia.png" ;
                String ruta = carpeta + numero + palabra;

                Carta carta = new Carta(ruta,0,0);
                carta.Numero = numero;
                carta.Tipo = 'D';
                barajaCartas.InsertarFinal(new Nodo(carta));
            }

            if(i >= 39 && i < 52)
            {
                String carpeta = "src/Img/";
                int numero = i + 1 - (39);
                String palabra = "tre.png" ;
                String ruta = carpeta + numero + palabra;

                Carta carta = new Carta(ruta,0,0);
                carta.Numero = numero;
                carta.Tipo = 'T';
                barajaCartas.InsertarFinal(new Nodo(carta));
            }
        }
    }
}
