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



public class HUD
{
    
    public int limites = 0;
    public static float VIDA = 100;
    private float greenValue = 255;
    
    private int puntuacion = 0;
    private int nivel = 1;
    
    public void tick()
    {
        VIDA = Juego.clamp( VIDA, 0, 100 + ( limites / 2 ) );
        
        greenValue = VIDA * 2;
        greenValue = Juego.clamp( greenValue, 0, 255 );
        
        puntuacion++;
        
    }
    
    public void render( Graphics g )
    {
        g.setColor( Color.GRAY );
        g.fillRect( 15, 15, 200 + limites, 32 );
        g.setColor(new Color( 75, (int) greenValue, 0 ) );
        g.fillRect( 15, 15, (int) VIDA * 2, 32 );
        g.setColor( Color.WHITE );
        g.drawRect( 15, 15, 200 + limites, 32 );
        
        g.drawString( "Puntuación: " + puntuacion, 15, 64 );
        g.drawString( "Nivel: " + nivel, 15, 80 );
        g.drawString( "Espacio para ir a la tienda", 15, 94 );
    }
    
    public void setPuntuacion( int puntuacion )
    {
        this.puntuacion = puntuacion;
    }
    
    public int getPuntuacion()
    {
        return puntuacion;
    }
    
    public void setNivel( int nivel )
    {
        this.nivel = nivel;
    }
    
    public int getNivel()
    {
        return nivel;
    }
}
