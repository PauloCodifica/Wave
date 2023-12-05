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


import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class ObjetoJuego
{
    
    protected float x, y;
    protected ID id;
    protected float velocidadX, velocidadY;
    
    public ObjetoJuego( float x, float y, ID id )
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick();
    public abstract void render( Graphics g );
    public abstract Rectangle obtenerLimite();
    
    public void setX( float x )
    {
        this.x = x;
    }
    
    public void setY( float y )
    {
        this.y = y;
    }
    
    public float getX()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public void setID( ID id )
    {
        this.id = id;
    }
    
    public ID getID()
    {
        return id;
    }
    
    public void setVelocidadX( float velocidadX )
    {
        this.velocidadX = velocidadX;
    }
    
    public void setVelocidadY( float velocidadY )
    {
        this.velocidadY = velocidadY;
    }
    
    public float getVelocidadX()
    {
        return velocidadX;
    }
    
    public float getVelocidadY()
    {
        return velocidadY;
    }
    
}
