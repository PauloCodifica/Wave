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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class EnemigoInteligente extends ObjetoJuego
{

    private Manejador manejador;
    private ObjetoJuego jugador;
    
    public EnemigoInteligente( int x, int y, ID id, Manejador manejador )
    {
        super( x, y, id );
        
        this.manejador = manejador;
        
        for( int i = 0; i < manejador.objeto.size(); i++ )
        {
            if( manejador.objeto.get( i ).getID() == ID.Player )
                jugador = manejador.objeto.get( i );
        }
    }
    
    public Rectangle obtenerLimite()
    {
        return new Rectangle( (int) x, (int) y, 16, 16 );
    }

    public void tick()
    {
        x += velocidadX;
        y += velocidadY;
        
        float difX = x - jugador.getX() - 8;
        float difY = y - jugador.getY() - 8;
        float distancia = ( float ) Math.sqrt( ( x - jugador.getX() ) * ( x - jugador.getX() ) + ( y - jugador.getY() ) * ( y - jugador.getY() ) );
        
        velocidadX = ( float ) ( ( -1.0 / distancia ) * difX ) ;
        velocidadY = ( float ) ( ( -1.0 / distancia ) * difY ) ;
        
        
        if( x <= 0 || x >= Juego.ANCHO - 16 )
            velocidadX *= -1;
        if( y <= 0 || y >= Juego.ALTURA - 32 )
            velocidadY *= -1;
        
        manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.GREEN, 16, 16, 0.02f, manejador ) );
    }

    public void render(Graphics g)
    {
        g.setColor( Color.GREEN );
        g.fillRect( (int) x, (int) y, 16, 16 );
    }
    
}
