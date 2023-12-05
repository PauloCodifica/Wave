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


public class Jugador extends ObjetoJuego
{
    Random r = new Random();
    Manejador manejador;
    
    private BufferedImage[] skinsJugador;
    private int skinSeleccionada;
    
    
    public Jugador( int x, int y, ID id, Manejador manejador )
    {
        super( x, y, id );
        this.manejador = manejador;
        
        skinsJugador = new BufferedImage[ 10 ];
        
        SpriteSheet ss = new SpriteSheet( Juego.sprite_sheet );
        
        skinsJugador[ 0 ] = ss.agarrarImagen( 1, 1, 32, 32 );
        skinsJugador[ 1 ] = ss.agarrarImagen( 1, 2, 32, 32 );
        skinsJugador[ 2 ] = ss.agarrarImagen( 1, 3, 32, 32 );
        skinsJugador[ 3 ] = ss.agarrarImagen( 1, 4, 32, 32 );
        skinsJugador[ 4 ] = ss.agarrarImagen( 2, 1, 32, 32 );
        skinsJugador[ 5 ] = ss.agarrarImagen( 2, 2, 32, 32 );
        skinsJugador[ 6 ] = ss.agarrarImagen( 2, 3, 32, 32 );
        skinsJugador[ 7 ] = ss.agarrarImagen( 2, 4, 32, 32 );
        skinsJugador[ 8 ] = ss.agarrarImagen( 3, 1, 32, 32 );
        skinsJugador[ 9 ] = ss.agarrarImagen( 3, 2, 32, 32 );
        
        skinSeleccionada = 0;
    }
    
    public Rectangle obtenerLimite()
    {
        return new Rectangle( (int) x, (int) y, 32, 32 );
    }
    
    public void tick()
    {
        x += velocidadX;
        y += velocidadY;
        
        x = Juego.clamp( x, 0, Juego.ANCHO - 37 );
        y = Juego.clamp( y, 0, Juego.ALTURA - 60 );
        
        switch( skinSeleccionada )
        {
            case 0:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.WHITE, 32, 32, 0.05f, manejador ) );
                break;
            case 1:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.GREEN, 32, 32, 0.05f, manejador ) );
                break;
            case 2:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.RED, 32, 32, 0.05f, manejador ) );
                break;
            case 3:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.YELLOW, 32, 32, 0.05f, manejador ) );
                break;
            case 4:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.BLUE, 32, 32, 0.05f, manejador ) );
                break;
            case 5:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.MAGENTA, 32, 32, 0.05f, manejador ) );
                break;
            case 6:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, new Color( 128, 0, 128 ), 32, 32, 0.05f, manejador ) );
                break;
            case 7:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.ORANGE, 32, 32, 0.05f, manejador ) );
                break;
            case 8:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, Color.CYAN, 32, 32, 0.05f, manejador ) );
                break;
            case 9:
                manejador.agregarObjeto( new Trazo( x, y, ID.Trazo, new Color( r.nextInt( 255 ), r.nextInt( 255 ), r.nextInt( 255 ), 170 ), 32, 32, 0.05f, manejador ) );
                break;
        }
        
        colision();
    }
    
    public void colision()
    {
        for( int i = 0; i < manejador.objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = manejador.objeto.get( i );
            
            if( tempObjeto.getID() == ID.BasicEnemy || tempObjeto.getID() == ID.FastEnemy || tempObjeto.getID() == ID.SmartEnemy || tempObjeto.getID() == ID.HardEnemy )
            {
                if( obtenerLimite().intersects( tempObjeto.obtenerLimite() ) )
                {
                    // Colisión con enemigo.
                    HUD.VIDA -= 2;
                }
            } else if( tempObjeto.getID() == ID.EnemyBoss )
                {
                    if( obtenerLimite().intersects( tempObjeto.obtenerLimite() ) )
                    {
                        // Colisión con Jefe final.
                        HUD.VIDA -= 4;
                    }
                }
        }
    }
    
    public void render( Graphics g )
    {
        g.drawImage( skinsJugador[ skinSeleccionada ], (int) x, (int) y, null );
    }
    
    public void setSkinSeleccionada( int numeroSkin )
    {
        skinSeleccionada = numeroSkin;
    }
    
    public int getSkinSeleccionada()
    {
        return skinSeleccionada;
    }
}
