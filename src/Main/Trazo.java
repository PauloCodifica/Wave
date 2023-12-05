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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class Trazo extends ObjetoJuego
{
    private float alpha = 1;
    private float vida;
    
    private Manejador manejador;
    private Color color;
    
    private int ancho, altura;
    
    
    public Trazo( float x, float y, ID id, Color color, int ancho, int altura, float vida, Manejador manejador )
    {
        super( x, y, id );
        this.manejador = manejador;
        this.color = color;
        this.ancho = ancho;
        this.altura = altura;
        this.vida = vida;
    }
    
    
    public void tick()
    {
        if( alpha > vida )
            alpha -= ( vida - 0.0001f );
        else
            manejador.borrarObjeto( this );
    }

    public void render(Graphics g)
    {
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setComposite( hacerTransparente( alpha ) );
        
        g.setColor( color );
        g.fillRect( (int) x, (int) y, ancho, altura );
        
        g2d.setComposite( hacerTransparente( 1 ) );
    }
    
    private AlphaComposite hacerTransparente( float alpha )
    {
        int tipo = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance( tipo, alpha );
    }

    public Rectangle obtenerLimite()
    {
        return null;
    }
    
}
