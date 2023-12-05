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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter
{
    private Juego juego;
    private Manejador manejador;
    private HUD hud;
    private Tienda tienda;
    private Random r = new Random();
    
    private Color botonMenu1 = Color.WHITE;
    private Color botonMenu2 = Color.WHITE;
    private Color botonMenu3 = Color.WHITE;
    
    private Color botonDificultad1 = Color.WHITE;
    private Color botonDificultad2 = Color.WHITE;
    private Color botonDificultad3 = Color.WHITE;
    
    private Color botonVolverAyuda = Color.WHITE;
    private Color botonVolverFin = Color.WHITE;
    
    private int boton1X = 210;
    private int boton1W = 200;
    
    private int boton2X = 210;
    private int boton2W = 200;
    
    private int boton3X = 210;
    private int boton3W = 200;
    
    public Menu( Juego juego, Manejador manejador, HUD hud, Tienda tienda )
    {
        this.juego = juego;
        this.manejador = manejador;
        this.hud = hud;
        this.tienda = tienda;
    }
    
    public void mousePressed( MouseEvent e )
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // Menú principal.
        if( juego.estadoJuego == Juego.ESTADO.Menu )
        {
            // Botón de JUGAR.
            if( mouseEstaEncima( mouseX, mouseY, 210, 150, 200, 64 ) ) // Usar coordenadas del rectángulo (botón) dibujado en render.
            {
                juego.estadoJuego = Juego.ESTADO.Select;
                return;
            }

            // Botón de AYUDA.
            if( mouseEstaEncima( mouseX, mouseY, 210, 250, 200, 64 ) )
            {
                juego.estadoJuego = Juego.ESTADO.Help;
            }

            // Botón de SALIR.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
            {
                System.exit( 0 );
            }
        }
        
        // Menú selección de dificultad.
        if( juego.estadoJuego == Juego.ESTADO.Select )
        {
            // Botón de dificultad NORMAL.
            if( mouseEstaEncima( mouseX, mouseY, 210, 150, 200, 64 ) ) // Usar coordenadas del rectángulo (botón) dibujado en render.
            {
                juego.estadoJuego = Juego.ESTADO.Game;
                manejador.agregarObjeto( new Jugador( Juego.ANCHO / 2 - 32, Juego.ALTURA / 2 - 32, ID.Player, manejador ) );
                manejador.borrarEnemigos();
                manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                
                juego.dificultad = 0;
            }

            // Botón de dificultad DIFICIL.
            if( mouseEstaEncima( mouseX, mouseY, 210, 250, 200, 64 ) )
            {
                juego.estadoJuego = Juego.ESTADO.Game;
                manejador.agregarObjeto( new Jugador( Juego.ANCHO / 2 - 32, Juego.ALTURA / 2 - 32, ID.Player, manejador ) );
                manejador.borrarEnemigos();
                manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                
                juego.dificultad = 1;
            }

            // Botón de REGRESAR en dificultad.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
            {
                juego.estadoJuego = Juego.ESTADO.Menu;
            }
        }
        
        
        // Menú de ayuda.
        if( juego.estadoJuego == Juego.ESTADO.Help )
        {
            // Botón de REGRESAR en ayuda.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
            {
                juego.estadoJuego = Juego.ESTADO.Menu;
            }
        }
        
        // Pantalla de fin del juego.
        if( juego.estadoJuego == Juego.ESTADO.End || juego.estadoJuego == Juego.ESTADO.Win )
        {
            // Botón de REGRESAR en fin del juego.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
            {
                if( juego.estadoJuego == Juego.ESTADO.Win )
                    tienda.desbloquearSkinEspecial();
                
                juego.estadoJuego = Juego.ESTADO.Menu;
                hud.setNivel( 1 );
                hud.setPuntuacion( 0 );
            }
        }
    }
    
    public void mouseReleased( MouseEvent e )
    {
        
    }
    
    public void mouseMoved( MouseEvent e )
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // Menú principal.
        if( juego.estadoJuego == Juego.ESTADO.Menu )
        {
            // Botón de JUGAR.
            if( mouseEstaEncima( mouseX, mouseY, 210, 150, 200, 64 ) )
                botonMenu1 = Color.BLUE;
            else
                botonMenu1 = Color.WHITE;

            // Botón de AYUDA.
            if( mouseEstaEncima( mouseX, mouseY, 210, 250, 200, 64 ) )
                botonMenu2 = Color.BLUE;
            else
                botonMenu2 = Color.WHITE;

            // Botón de SALIR.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
                botonMenu3 = Color.BLUE;
            else
                botonMenu3 = Color.WHITE;
        }
        
        // Menú de selección de dificultad.
        if( juego.estadoJuego == Juego.ESTADO.Select )
        {
            // Botón de dificultad NORMAL.
            if( mouseEstaEncima( mouseX, mouseY, 210, 150, 200, 64 ) )
                botonDificultad1 = Color.GREEN;
            else
                botonDificultad1 = Color.WHITE;

            // Botón de dificultad DIFICIL.
            if( mouseEstaEncima( mouseX, mouseY, 210, 250, 200, 64 ) )
                botonDificultad2 = Color.RED;
            else
                botonDificultad2 = Color.WHITE;

            // Botón de REGRESAR en dificultad.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
                botonDificultad3 = Color.BLUE;
            else
                botonDificultad3 = Color.WHITE;
        }
        
        // Menú de ayuda.
        if( juego.estadoJuego == Juego.ESTADO.Help )
        {
            // Botón de REGRESAR en ayuda.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
                botonVolverAyuda = Color.BLUE;
            else
                botonVolverAyuda = Color.WHITE;
        }
        
        // Pantalla de fin del juego.
        if( juego.estadoJuego == Juego.ESTADO.End || juego.estadoJuego == Juego.ESTADO.Win )
        {
            // Botón de REGRESAR en fin del juego.
            if( mouseEstaEncima( mouseX, mouseY, 210, 350, 200, 64 ) )
                botonVolverFin = Color.BLUE;
            else
                botonVolverFin = Color.WHITE;
        }
    }
    
    private boolean mouseEstaEncima( int mouseX, int mouseY, int x, int y, int ancho, int altura )
    {
        if( mouseX > x && mouseX < x + ancho )
        {
            if( mouseY > y && mouseY < y + altura )
                return true;
            else
                return false;
        } else
            return false;
    }
    
    
    public void tick()
    {
        if( botonMenu1 == Color.WHITE )
        {
            boton1X += ( 230 - boton1X ) * 0.05;
            boton1W += ( 200 - boton1W ) * 0.05;
        } else
            {
                boton1X += ( 110 - boton1X ) * 0.05; //210
                boton1W += ( 400 - boton1W ) * 0.05; //200
            }
        
        if( botonMenu2 == Color.WHITE )
        {
            boton2X += ( 230 - boton2X ) * 0.05;
            boton2W += ( 200 - boton2W ) * 0.05;
        } else
            {
                boton2X += ( 110 - boton2X ) * 0.05; //210
                boton2W += ( 400 - boton2W ) * 0.05; //200
            }
        
        if( botonMenu3 == Color.WHITE )
        {
            boton3X += ( 230 - boton3X ) * 0.05;
            boton3W += ( 200 - boton3W ) * 0.05;
        } else
            {
                boton3X += ( 110 - boton3X ) * 0.05; //210
                boton3W += ( 400 - boton3W ) * 0.05; //200
            }
    }
    
    public void render( Graphics g )
    {
        if( juego.estadoJuego == Juego.ESTADO.Menu )
        {
            Font fnt = new Font( "arial", 1, 50 );
            Font fnt2 = new Font( "arial", 1, 30 );

            g.setFont( fnt );
            g.setColor( Color.WHITE );
            g.drawString( "WAVE", 236, 70 );


            g.setFont( fnt2 );
            g.setColor( botonMenu1 );
            g.drawRect( boton1X, 150, boton1W, 64 );
            g.drawString( "Jugar", 270, 190 );
            g.setColor( Color.WHITE );


            g.setColor( botonMenu2 );
            g.drawRect( boton2X, 250, boton2W, 64 );
            g.drawString( "Ayuda", 270, 290 );
            g.setColor( Color.WHITE );

            g.setColor( botonMenu3 );
            g.drawRect( boton3X, 350, boton3W, 64 );
            g.drawString( "Salir", 280, 390 );
            g.setColor( Color.WHITE );
        } else if( juego.estadoJuego == Juego.ESTADO.Help )
            {
                Font fnt = new Font( "arial", 1, 50 );
                Font fnt2 = new Font( "arial", 1, 30 );
                Font fnt3 = new Font( "arial", 1, 20 );

                g.setFont( fnt );
                g.setColor( Color.WHITE );
                g.drawString( "Ayuda", 240, 70 );
                
                g.setFont( fnt3 );
                g.drawString( "Utiliza las teclas W,A,S,D para moverte y esquivar enemigos.", 30, 160 );
                g.drawString( "P : Pausar partida.", 30, 190 );
                g.drawString( "Barra Espaciadora : Visitar Tienda.", 30, 220 );
                g.drawString( "Visita la tienda para comprar mejoras y aspectos para tu", 30, 270 );
                g.drawString( "personaje.", 30, 300 );
                
                g.setFont( fnt2 );
                g.setColor( botonVolverAyuda );
                g.drawRect( 210, 350, 200, 64 );
                g.drawString( "Regresar", 245, 390 );
                g.setColor( Color.WHITE );
            } else if( juego.estadoJuego == Juego.ESTADO.End )
                {
                    Font fnt = new Font( "arial", 1, 50 );
                    Font fnt2 = new Font( "arial", 1, 30 );
                    Font fnt3 = new Font( "arial", 1, 20 );

                    g.setFont( fnt );
                    g.setColor( Color.WHITE );
                    g.drawString( "Fin Del Juego", 145, 70 );

                    g.setFont( fnt3 );
                    g.drawString( "Tu puntuación final es:    " + hud.getPuntuacion(), 170, 200 );

                    g.setFont( fnt2 );
                    g.setColor( botonVolverFin );
                    g.drawRect( 210, 350, 200, 64 );
                    g.drawString( "Regresar", 245, 390 );
                    g.setColor( Color.WHITE );
                } else if( juego.estadoJuego == Juego.ESTADO.Select )
                    {
                        Font fnt = new Font( "arial", 1, 50 );
                        Font fnt2 = new Font( "arial", 1, 30 );

                        g.setFont( fnt );
                        g.setColor( Color.WHITE );
                        g.drawString( "Dificultad", 195, 70 );


                        g.setFont( fnt2 );
                        g.setColor( botonDificultad1 );
                        g.drawRect( 210, 150, 200, 64 );
                        g.drawString( "Normal", 260, 190 );


                        g.setColor( botonDificultad2 );
                        g.drawRect( 210, 250, 200, 64 );
                        g.drawString( "Difícil", 270, 290 );

                        g.setColor( botonDificultad3 );
                        g.drawRect( 210, 350, 200, 64 );
                        g.drawString( "Regresar", 245, 390 );
                        g.setColor( Color.WHITE );
                    } else if( juego.estadoJuego == Juego.ESTADO.Win )
                        {
                            Font fnt = new Font( "arial", 1, 50 );
                            Font fnt2 = new Font( "arial", 1, 30 );
                            Font fnt3 = new Font( "arial", 1, 20 );

                            g.setFont( fnt );
                            g.setColor( Color.WHITE );
                            g.drawString( "¡Ganaste!", 195, 70 );

                            if( ! tienda.skinEspecialEstaDesbloqueada() )
                            {
                                g.setFont( fnt3 );
                                g.drawString( "¡Has desbloqueado un nuevo aspecto!", 120, 140 );
                                g.drawString( "Visita la tienda para usarlo.", 180, 170 );
                            }
                            
                            g.setFont( fnt2 );
                            g.drawString( "Créditos:", 245, 240 );
                            g.setFont( fnt3 );
                            g.drawString( "Autor Original:      RealTutsGML", 180, 280 );
                            g.drawString( "Versión creada por:     Paulo U", 140, 310 );

                            g.setFont( fnt2 );
                            g.setColor( botonVolverFin );
                            g.drawRect( 210, 350, 200, 64 );
                            g.drawString( "Regresar", 245, 390 );
                            g.setColor( Color.WHITE );
                        }
    }
}
