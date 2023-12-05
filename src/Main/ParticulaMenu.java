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
import java.util.Random;



public class ParticulaMenu extends ObjetoJuego
{

    private Manejador manejador;
    private Random r = new Random();
    
    private Color col;
    
    public ParticulaMenu( int x, int y, ID id, Manejador manejador )
    {
        super( x, y, id );
        
        this.manejador = manejador;
        
        velocidadX = r.nextInt( 7 - -7 ) + -7;
        velocidadY = r.nextInt( 7 - -7 ) + -7;
        
        if( velocidadX == 0 ) velocidadX = 1;
        if( velocidadY == 0 ) velocidadY = 1;
        
        col = new Color( r.nextInt( 255 ), r.nextInt( 255 ), r.nextInt( 255 ), 80 );
    }
    
    public Rectangle obtenerLimite()
    {
        return new Rectangle( (int) x, (int) y, 16, 16 );
    }

    public void tick()
    {
        x += velocidadX;
        y += velocidadY;
        
        
        if( x <= 0 || x >= Juego.ANCHO - 16 )
            velocidadX *= -1;
        if( y <= 0 || y >= Juego.ALTURA - 32 )
            velocidadY *= -1;
        
        manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, col, 16, 16, 0.05f, manejador ) );
    }

    public void render(Graphics g)
    {
        g.setColor( col );
        g.fillRect( (int) x, (int) y, 16, 16 );
    }
    
}