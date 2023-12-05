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


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Juego extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1550691097823471818L;
    
    public static final int ANCHO = 640;
    public static final int ALTURA = ANCHO / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    
    public static boolean pausado = false;
    public int dificultad = 0; // 0 = normal;
                               // 1 = difícil;
    
    private Random r;
    private Manejador manejador;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private Tienda tienda;
    
    public enum ESTADO
    {
        Menu,
        Select,
        Help,
        Shop,
        Game,
        End,
        Win;
    }
    
    public static ESTADO estadoJuego = ESTADO.Menu;
    
    public static BufferedImage sprite_sheet;
    public static BufferedImage enemy_sheet;
    
    public Juego()
    {
        BufferedImageLoader loader = new BufferedImageLoader();
        
        sprite_sheet = loader.cargarImagen( "/sprite_sheet.png" );
        enemy_sheet = loader.cargarImagen( "/enemyBoss_sheet.png" );
        
        
        this.setFocusable( true );
        
        manejador = new Manejador();
        hud = new HUD();
        tienda = new Tienda( this, manejador, hud );
        menu = new Menu( this, manejador, hud, tienda );
        this.addKeyListener( new PulsarTecla( manejador, this ) );
        this.addMouseListener( menu );
        this.addMouseMotionListener( menu );
        this.addMouseListener( tienda );
        this.addMouseMotionListener( tienda );
        
        spawner = new Spawn( manejador, hud, this );
        
        
        new Ventana( ANCHO, ALTURA, "WAVE", this );
        
        
        r = new Random();
        
        if( estadoJuego == ESTADO.Game )
        {
            manejador.agregarObjeto( new Jugador( ANCHO / 2 - 32, ALTURA / 2 - 32, ID.Player, manejador ) );
            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
        } else
            {
                for( int i = 0; i < 15; i++ )
                {
                    manejador.agregarObjeto( new ParticulaMenu( r.nextInt( Juego.ANCHO ), r.nextInt( Juego.ALTURA ), ID.MenuParticle, manejador ) );
                }
            }
    }
    
    
    public synchronized void iniciar()
    {
        thread = new Thread( this );
        thread.start();
        running = true;
    }
    
    public synchronized void detener()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch( Exception exception )
        {
            exception.printStackTrace();
        }
    }
    
    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while( running )
        {
            long now = System.nanoTime();
            delta += ( now - lastTime ) / ns;
            lastTime = now;
            while( delta >= 1 )
            {
                tick();
                delta--;
            }
            
            if( running )
                render();
            frames++;
            
            if( System.currentTimeMillis() - timer > 1000 )
            {
                timer += 1000;
                
                /*System.out.println( "FPS: " + frames );*/ // Mostrar Frames per Second.
                
                frames = 0;
            }
        }
        
        detener();
    }
    
    
    private void tick()
    {
        if( estadoJuego == ESTADO.Game )
        {
            if( !pausado )
            {
                hud.tick();
                spawner.tick();
                manejador.tick();

                if( HUD.VIDA <= 0 )
                {
                    HUD.VIDA = 100 + ( hud.limites / 2 );
                    estadoJuego = ESTADO.End;
                    spawner.puntuacionNivel = 0;
                    manejador.borrarEnemigos();
                    for( int i = 0; i < 15; i++ )
                    {
                        manejador.agregarObjeto( new ParticulaMenu( r.nextInt( Juego.ANCHO ), r.nextInt( Juego.ALTURA ), ID.MenuParticle, manejador ) );
                    }
                }
            }
        } else if( estadoJuego == ESTADO.Menu || estadoJuego == ESTADO.Help || estadoJuego == ESTADO.End || estadoJuego == ESTADO.Select || estadoJuego == ESTADO.Win )
            {
                menu.tick();
                manejador.tick();
            }
    }
    
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        
        if( bs == null )
        {
            this.createBufferStrategy( 3 );
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor( Color.BLACK );
        g.fillRect( 0, 0, ANCHO, ALTURA );
        
        
        if( pausado )
        {
            g.setColor( Color.WHITE );
            g.drawString( "PAUSA", ANCHO / 2 - 32, ALTURA / 2 - 32 );
        }
        
        if( estadoJuego == ESTADO.Game )
        {
            hud.render( g );
            manejador.render( g );
            for( int i = 0; i < manejador.objeto.size(); i++ )
            {
                ObjetoJuego tempObjeto = manejador.objeto.get( i );

                if( tempObjeto.getID() == ID.Player )
                    tempObjeto.render( g );
            }
        } else if( estadoJuego == ESTADO.Shop )
            {
                tienda.render( g );
            } else if( estadoJuego == ESTADO.Menu || estadoJuego == ESTADO.Help || estadoJuego == ESTADO.End || estadoJuego == ESTADO.Select || estadoJuego == ESTADO.Win )
                {
                    menu.render( g );
                    manejador.render( g );
                }
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp( float var, float min, float max )
    {
        if( var >= max )
            return max;
        else if( var <= min )
            return min;
        else
            return var;
    }
    
    
    public static void main(String[] args)
    {
        new Juego();
    }
    
}
