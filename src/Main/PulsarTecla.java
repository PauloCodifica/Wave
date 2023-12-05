/*
            **************** 
           ****** WAVE ******
            ****************
  [ESPAÑOL]
       ( Versión de PauloCodifica )
  Creado originalmente por RealTutsGML.
  Por favor no redistribuyas este juego sin mi permiso.
  ¡Puedes descargarlo totalmente gratis desde mi repositorio de GitHub!
  Para más información sobre mis juegos o si quieres aprender programación,
  visita mi página web: https://paulocodifica.github.io/
  [ENGLISH]
       ( PauloCodifica's Version )
  Originally created by RealTutsGML.
  Please do not redistribute this game without my permission.
  You can download it totally free from my GitHub repository!
  For more information about my games or if you want to learn about programming,
  visit my website: https://paulocodifica.github.io/
*/

package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PulsarTecla extends KeyAdapter
{
    private Manejador manejador;
    private boolean[] teclaPulsada = new boolean [ 4 ];
    
    Juego juego;
    
    
    public PulsarTecla( Manejador manejador, Juego juego )
    {
        this.manejador = manejador;
        
        this.juego = juego;
        
        for( int i = 0; i < teclaPulsada.length; i++ )
        {
            teclaPulsada[ i ] = false;
        }
    }
    
    
    public void keyPressed( KeyEvent e )
    {
        int tecla = e.getKeyCode();
        
        for( int i = 0; i < manejador.objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = manejador.objeto.get( i );
            
            if( tempObjeto.getID() == ID.Player )
            {
                // Eventos de pulsado de teclas para jugador 1.
                
                if( tecla == KeyEvent.VK_W )
                {
                    tempObjeto.setVelocidadY( - manejador.velocidad );
                    teclaPulsada[ 0 ] = true;
                }
                if( tecla == KeyEvent.VK_S )
                {
                    tempObjeto.setVelocidadY( manejador.velocidad );
                    teclaPulsada[ 1 ] = true;
                }
                if( tecla == KeyEvent.VK_A )
                {
                    tempObjeto.setVelocidadX( - manejador.velocidad );
                    teclaPulsada[ 2 ] = true;
                }
                if( tecla == KeyEvent.VK_D )
                {
                    tempObjeto.setVelocidadX( manejador.velocidad );
                    teclaPulsada[ 3 ] = true;
                }
            }
        }
        
        if( tecla == KeyEvent.VK_P )
        {
            if( juego.estadoJuego == Juego.ESTADO.Game )
            {
                if( Juego.pausado )
                    Juego.pausado = false;
                else
                    Juego.pausado = true;
            }
        }
        
        if( tecla == KeyEvent.VK_ESCAPE )
            System.exit(0);
        
        if( tecla == KeyEvent.VK_SPACE )
        {
            if( ! Juego.pausado )
            {
                if( juego.estadoJuego == Juego.ESTADO.Game )
                    juego.estadoJuego = Juego.ESTADO.Shop;
                else if( juego.estadoJuego == Juego.ESTADO.Shop )
                    juego.estadoJuego = Juego.ESTADO.Game;
            }
        }
    }
    
    public void keyReleased( KeyEvent e )
    {
        int tecla = e.getKeyCode();
        
        for( int i = 0; i < manejador.objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = manejador.objeto.get( i );
            
            if( tempObjeto.getID() == ID.Player )
            {
                // Eventos de pulsado de teclas para jugador 1.
                
                if( tecla == KeyEvent.VK_W )
                {
                    teclaPulsada[ 0 ] = false;
                    if( teclaPulsada[ 1 ] )
                        tempObjeto.setVelocidadY( 5 );
                    else
                        tempObjeto.setVelocidadY( 0 );
                }
                if( tecla == KeyEvent.VK_S )
                {
                    teclaPulsada[ 1 ] = false;
                    if( teclaPulsada[ 0 ] )
                        tempObjeto.setVelocidadY( -5 );
                    else
                        tempObjeto.setVelocidadY( 0 );
                }
                if( tecla == KeyEvent.VK_A )
                {
                    teclaPulsada[ 2 ] = false;
                    if( teclaPulsada[ 3 ] )
                        tempObjeto.setVelocidadX( 5 );
                    else
                        tempObjeto.setVelocidadX( 0 );
                }
                if( tecla == KeyEvent.VK_D )
                {
                    teclaPulsada[ 3 ] = false;
                    if( teclaPulsada[ 2 ] )
                        tempObjeto.setVelocidadX( -5 );
                    else
                        tempObjeto.setVelocidadX( 0 );
                }
                
                
                // Sistema con errores.
                // Movimiento vertical
                //if( ! teclaPulsada[ 0 ] && ! teclaPulsada[ 1 ] )
                    //tempObjeto.setVelocidadY( 0 );
                // Movimiento horizontal
                //if( ! teclaPulsada[ 2 ] && ! teclaPulsada[ 3 ] )
                    //tempObjeto.setVelocidadX( 0 );
            }
        }
    }
}
