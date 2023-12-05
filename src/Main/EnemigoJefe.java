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
import java.awt.image.BufferedImage;
import java.util.Random;



public class EnemigoJefe extends ObjetoJuego
{

    private Manejador manejador;
    private Random r = new Random();
    
    private BufferedImage[] skinJefe;
    
    public boolean derrotado = false;
    public boolean jefeMuere = false;
    
    private int temporizador = 70;
    private int temporizador2 = 90;
    private int temporizador3 = 200;
    private int temporizador4 = 100;
    
    public EnemigoJefe( int x, int y, ID id, Manejador manejador )
    {
        super( x, y, id );
        
        this.manejador = manejador;
        
        skinJefe = new BufferedImage[ 3 ];
        
        SpriteSheet ss = new SpriteSheet( Juego.enemy_sheet );
        
        skinJefe[ 0 ] = ss.agarrarImagen96x96( 1, 1, 96, 96 );
        skinJefe[ 1 ] = ss.agarrarImagen96x96( 1, 2, 96, 96 );
        skinJefe[ 2 ] = ss.agarrarImagen96x96( 2, 1, 96, 96 );
        
        velocidadX = 0;
        velocidadY = 2;
    }
    
    public Rectangle obtenerLimite()
    {
        return new Rectangle( (int) x, (int) y, 96, 96 );
    }

    public void tick()
    {
        x += velocidadX;
        y += velocidadY;
        
        if( temporizador <= 0 )
            velocidadY = 0;
        else
            temporizador--;
        
        if( temporizador <= 0 )
            temporizador2--;
        if( temporizador2 <= 0 && derrotado == false )
        {
            if( velocidadX == 0 )
                velocidadX = 2;
            
            if( velocidadX > 0 )
                velocidadX += 0.005f;
            else if( velocidadX < 0 )
                velocidadX -= 0.005f;
            
            velocidadX = Juego.clamp( velocidadX, -10, 10 );
            
            int spawn = r.nextInt( 10 );
            if( spawn == 0 )
                manejador.agregarObjeto( new EnemigoJefeProyectil( (int) x + 48, (int) y + 80, ID.BasicEnemy, manejador ) );
        } else
            {
                if( derrotado )
                {
                    if( x > Juego.ANCHO / 2 )
                        velocidadX = -2;
                    else if( x < Juego.ANCHO / 2 - 30 )
                        velocidadX = 2;
                    else
                        velocidadX = 0;
                    
                    if( temporizador3 > 0 )
                        temporizador3--;
                    else if( temporizador3 <= 0 )
                        {
                            jefeMuere = true;
                            
                            int spawn = r.nextInt( 6 );
                            if( spawn == 0 )
                                manejador.agregarObjeto( new EnemigoJefeParticula( (int) x + 48, (int) y + 80, ID.BasicEnemy, manejador ) );
                            
                            if( temporizador4 > 0 )
                                temporizador4--;
                            else if( temporizador4 <= 0 )
                                velocidadY = -1;
                        }
                }
            }
        
        if( x <= 0 || x >= Juego.ANCHO - 96 )
            velocidadX *= -1;
    }

    public void render(Graphics g)
    {
        if( ! derrotado )
            g.drawImage( skinJefe[ 0 ], (int) x, (int) y, null );
        else
            {
                if( ! jefeMuere )
                    g.drawImage( skinJefe[ 1 ], (int) x, (int) y, null );
                else
                    g.drawImage( skinJefe[ 2 ], (int) x, (int) y, null );
            }
    }
    
}
