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
import java.awt.image.BufferedImage;


public class Tienda extends MouseAdapter
{
    private Juego juego;
    private Manejador manejador;
    
    private HUD hud;
    private Jugador jugador;
    
    private int mejora1 = 1500;
    private int mejora2 = 1500;
    private int mejora3 = 2000;
    
    private Color colorMejora1 = Color.WHITE;
    private Color colorMejora2 = Color.WHITE;
    private Color colorMejora3 = Color.WHITE;
    
    private BufferedImage[] skins;
    private int[] costoSkins;
    private boolean[] skinEstaDesbloqueada;
    private Color[] skinColorRecuadro;
    
    private boolean mouseEstaEncimaSkins;
    
    
    public Tienda( Juego juego, Manejador manejador, HUD hud )
    {
        this.juego = juego;
        this.manejador = manejador;
        this.hud = hud;
        
        skins = new BufferedImage[ 10 ];
        costoSkins = new int[ 10 ];
        skinEstaDesbloqueada = new boolean[ 10 ];
        skinColorRecuadro = new Color[ 10 ];
        
        SpriteSheet ss = new SpriteSheet( Juego.sprite_sheet );
        
        skins[ 0 ] = ss.agarrarImagen( 1, 1, 32, 32 );
        skins[ 1 ] = ss.agarrarImagen( 1, 2, 32, 32 );
        skins[ 2 ] = ss.agarrarImagen( 1, 3, 32, 32 );
        skins[ 3 ] = ss.agarrarImagen( 1, 4, 32, 32 );
        skins[ 4 ] = ss.agarrarImagen( 2, 1, 32, 32 );
        skins[ 5 ] = ss.agarrarImagen( 2, 2, 32, 32 );
        skins[ 6 ] = ss.agarrarImagen( 2, 3, 32, 32 );
        skins[ 7 ] = ss.agarrarImagen( 2, 4, 32, 32 );
        skins[ 8 ] = ss.agarrarImagen( 3, 1, 32, 32 );
        skins[ 9 ] = ss.agarrarImagen( 3, 2, 32, 32 );
        
        
        skinEstaDesbloqueada[0] = true;
        skinColorRecuadro[0] = Color.BLUE;
        
        for( int i = 1; i < 10; i++ )
        {
            costoSkins[ i ] = (i * 1000) + 1000;
            
            skinEstaDesbloqueada[ i ] = false;
            
            skinColorRecuadro[ i ] = Color.WHITE;
        }
        
    }
    
    public void tick()
    {
        
    }
    
    public void render( Graphics g )
    {
        for( int i = 0; i < this.manejador.objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = this.manejador.objeto.get( i );
            
            if( tempObjeto.id == ID.Player )
            {
                jugador = (Jugador) tempObjeto;
            }
        }
        
        for( int i = 0; i < 10; i++ )
        {
            if( ! mouseEstaEncimaSkins )
                skinColorRecuadro[ i ] = Color.WHITE;
        }
        
        skinColorRecuadro[ jugador.getSkinSeleccionada() ] = Color.BLUE;
        
        
        g.setColor( Color.WHITE );
        g.setFont( new Font( "arial", 0, 48 ) );
        g.drawString( "TIENDA", Juego.ANCHO / 2 - 100, 50 );
        
        // Mejora 1
        g.setFont( new Font( "arial", 0, 12 ) );
        g.drawString( "Mejorar Vida", 110, 120 );
        g.drawString( "Costo:", 110, 140 );
        if( hud.getPuntuacion() >= mejora1 ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + mejora1, 110, 160 );
        g.setColor( colorMejora1 );
        g.drawRect( 100, 100, 100, 80 );
        g.setColor( Color.WHITE );
        
        // Mejora 2
        g.drawString( "Mejorar Velocidad", 252, 120 );
        g.drawString( "Costo:", 260, 140 );
        if( hud.getPuntuacion() >= mejora2 ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + mejora2, 260, 160 );
        g.setColor( colorMejora2 );
        g.drawRect( 250, 100, 100, 80 );
        g.setColor( Color.WHITE );
        
        // Mejora 3
        g.drawString( "Rellenar Vida", 410, 120 );
        g.drawString( "Costo:", 410, 140 );
        if( hud.getPuntuacion() >= mejora3 ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + mejora3, 410, 160 );
        g.setColor( colorMejora3 );
        g.drawRect( 400, 100, 100, 80 );
        g.setColor( Color.WHITE );
        
        
        g.drawImage( skins[ 0 ], 30, 350, null );
        g.setColor( Color.GREEN );
        g.drawString( "$0", 27, 400 );
        g.setColor( skinColorRecuadro[ 0 ] );
        g.drawRect( 20, 340, 50, 70 );
        
        g.drawImage( skins[ 1 ], 90, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 1 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 1 ], 87, 400 );
        g.setColor( skinColorRecuadro[ 1 ] );
        g.drawRect( 80, 340, 50, 70 );
        
        g.drawImage( skins[ 2 ], 150, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 2 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 2 ], 147, 400 );
        g.setColor( skinColorRecuadro[ 2 ] );
        g.drawRect( 140, 340, 50, 70 );
        
        g.drawImage( skins[ 3 ], 210, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 3 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 3 ], 207, 400 );
        g.setColor( skinColorRecuadro[ 3 ] );
        g.drawRect( 200, 340, 50, 70 );
        
        g.drawImage( skins[ 4 ], 270, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 4 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 4 ], 267, 400 );
        g.setColor( skinColorRecuadro[ 4 ] );
        g.drawRect( 260, 340, 50, 70 );
        
        g.drawImage( skins[ 5 ], 330, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 5 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 5 ], 327, 400 );
        g.setColor( skinColorRecuadro[ 5 ] );
        g.drawRect( 320, 340, 50, 70 );
        
        g.drawImage( skins[ 6 ], 390, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 6 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 6 ], 387, 400 );
        g.setColor( skinColorRecuadro[ 6 ] );
        g.drawRect( 380, 340, 50, 70 );
        
        g.drawImage( skins[ 7 ], 450, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 7 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 7 ], 447, 400 );
        g.setColor( skinColorRecuadro[ 7 ] );
        g.drawRect( 440, 340, 50, 70 );
        
        g.drawImage( skins[ 8 ], 510, 350, null );
        if( hud.getPuntuacion() >= costoSkins[ 8 ] ) g.setColor( Color.GREEN );
        else g.setColor( Color.RED );
        g.drawString( "$" + costoSkins[ 8 ], 507, 400 );
        g.setColor( skinColorRecuadro[ 8 ] );
        g.drawRect( 500, 340, 50, 70 );
        
        
        if( skinEstaDesbloqueada[ 9 ] )
        {
            g.drawImage( skins[ 9 ], 570, 350, null );
            g.setColor( Color.GREEN );
            g.drawString( "$0", 567, 400 );
            g.setColor( skinColorRecuadro[ 9 ] );
            g.drawRect( 560, 340, 50, 70 );
        }
        
        g.setColor( Color.WHITE );
        g.drawString( "PUNTUACIÓN:", 100, 240 );
        g.setColor( Color.YELLOW );
        g.drawString( Integer.toString( hud.getPuntuacion() ), 220, 240 );
        g.setColor( Color.WHITE );
        g.drawString( "Pulsa Espacio para volver", 100, 260 );
    }
    
    public void mousePressed( MouseEvent e )
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        for( int i = 0; i < this.manejador.objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = this.manejador.objeto.get( i );
            
            if( tempObjeto.id == ID.Player )
            {
                jugador = (Jugador) tempObjeto;
            }
        }
        
        if( juego.estadoJuego == Juego.ESTADO.Shop )
        {
            // Mejora 1
            if( mouseX >= 100 && mouseX <= 200 )
            {
                if( mouseY >= 100 && mouseY <= 180 )
                {
                    if( hud.getPuntuacion() >= mejora1 )
                    {
                        hud.setPuntuacion( hud.getPuntuacion() - mejora1 );
                        mejora1 += 500;
                        hud.limites += 20;
                        hud.VIDA = 100 + ( hud.limites / 2 );
                    }
                }
            }

            // Mejora 2
            if( mouseX >= 250 && mouseX <= 350 )
            {
                if( mouseY >= 100 && mouseY <= 180 )
                {
                    if( hud.getPuntuacion() >= mejora2 )
                    {
                        hud.setPuntuacion( hud.getPuntuacion() - mejora2 );
                        mejora2 += 500;
                        manejador.velocidad++;
                    }
                }
            }

            // Mejora 3
            if( mouseX >= 400 && mouseX <= 500 )
            {
                if( mouseY >= 100 && mouseY <= 180 )
                {
                    if( hud.getPuntuacion() >= mejora3 )
                    {
                        hud.setPuntuacion( hud.getPuntuacion() - mejora3 );
                        hud.VIDA = 100 + ( hud.limites / 2 );
                    }
                }
            }
            
            // *** SKINS ***
            
            // Seleccionar Skin 0
            if( mouseX >= 20 && mouseX <= 70 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    jugador.setSkinSeleccionada( 0 );
                }
            }
            
            // Seleccionar Skin 1
            if( mouseX >= 80 && mouseX <= 130 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 1 ] )
                        jugador.setSkinSeleccionada( 1 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 1 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 1 ] );
                            costoSkins[ 1 ] = 0;
                            skinEstaDesbloqueada[ 1 ] = true;
                            jugador.setSkinSeleccionada( 1 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 2
            if( mouseX >= 140 && mouseX <= 190 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 2 ] )
                        jugador.setSkinSeleccionada( 2 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 2 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 2 ] );
                            costoSkins[ 2 ] = 0;
                            skinEstaDesbloqueada[ 2 ] = true;
                            jugador.setSkinSeleccionada( 2 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 3
            if( mouseX >= 200 && mouseX <= 250 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 3 ] )
                        jugador.setSkinSeleccionada( 3 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 3 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 3 ] );
                            costoSkins[ 3 ] = 0;
                            skinEstaDesbloqueada[ 3 ] = true;
                            jugador.setSkinSeleccionada( 3 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 4
            if( mouseX >= 260 && mouseX <= 310 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 4 ] )
                        jugador.setSkinSeleccionada( 4 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 4 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 4 ] );
                            costoSkins[ 4 ] = 0;
                            skinEstaDesbloqueada[ 4 ] = true;
                            jugador.setSkinSeleccionada( 4 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 5
            if( mouseX >= 320 && mouseX <= 370 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 5 ] )
                        jugador.setSkinSeleccionada( 5 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 5 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 5 ] );
                            costoSkins[ 5 ] = 0;
                            skinEstaDesbloqueada[ 5 ] = true;
                            jugador.setSkinSeleccionada( 5 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 6
            if( mouseX >= 380 && mouseX <= 430 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 6 ] )
                        jugador.setSkinSeleccionada( 6 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 6 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 6 ] );
                            costoSkins[ 6 ] = 0;
                            skinEstaDesbloqueada[ 6 ] = true;
                            jugador.setSkinSeleccionada( 6 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 7
            if( mouseX >= 440 && mouseX <= 490 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 7 ] )
                        jugador.setSkinSeleccionada( 7 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 7 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 7 ] );
                            costoSkins[ 7 ] = 0;
                            skinEstaDesbloqueada[ 7 ] = true;
                            jugador.setSkinSeleccionada( 7 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 8
            if( mouseX >= 500 && mouseX <= 550 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 8 ] )
                        jugador.setSkinSeleccionada( 8 );
                    else
                    {
                        if( hud.getPuntuacion() >= costoSkins[ 8 ] )
                        {
                            hud.setPuntuacion( hud.getPuntuacion() - costoSkins[ 8 ] );
                            costoSkins[ 8 ] = 0;
                            skinEstaDesbloqueada[ 8 ] = true;
                            jugador.setSkinSeleccionada( 8 );
                        }
                    }
                }
            }
            
            // Seleccionar Skin 9
            if( mouseX >= 560 && mouseX <= 610 )
            {
                if( mouseY >= 340 && mouseY <= 410 )
                {
                    if( skinEstaDesbloqueada[ 9 ] )
                        jugador.setSkinSeleccionada( 9 );
                }
            }
        }
    }
    
    public void mouseMoved( MouseEvent e )
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // Botones de la Tienda.
        if( juego.estadoJuego == Juego.ESTADO.Shop )
        {
            // Botón de mejora 1.
            if( mouseEstaEncima( mouseX, mouseY, 100, 100, 100, 80 ) )
                colorMejora1 = Color.BLUE;
            else
                colorMejora1 = Color.WHITE;

            // Botón de mejora 2.
            if( mouseEstaEncima( mouseX, mouseY, 250, 100, 100, 80 ) )
                colorMejora2 = Color.BLUE;
            else
                colorMejora2 = Color.WHITE;

            // Botón de mejora 3.
            if( mouseEstaEncima( mouseX, mouseY, 400, 100, 100, 80 ) )
                colorMejora3 = Color.BLUE;
            else
                colorMejora3 = Color.WHITE;
            
            
            // *** SKINS ***

            // Skin 0.
            if( mouseEstaEncima( mouseX, mouseY, 20, 340, 50, 70 ) )
                skinColorRecuadro[ 0 ] = Color.BLUE;
            
            // Skin 1.
            if( mouseEstaEncima( mouseX, mouseY, 80, 340, 50, 70 ) )
                skinColorRecuadro[ 1 ] = Color.BLUE;
            
            // Skin 2.
            if( mouseEstaEncima( mouseX, mouseY, 140, 340, 50, 70 ) )
                skinColorRecuadro[ 2 ] = Color.BLUE;
            
            // Skin 3.
            if( mouseEstaEncima( mouseX, mouseY, 200, 340, 50, 70 ) )
                skinColorRecuadro[ 3 ] = Color.BLUE;
            
            // Skin 4.
            if( mouseEstaEncima( mouseX, mouseY, 260, 340, 50, 70 ) )
                skinColorRecuadro[ 4 ] = Color.BLUE;
            
            // Skin 5.
            if( mouseEstaEncima( mouseX, mouseY, 320, 340, 50, 70 ) )
                skinColorRecuadro[ 5 ] = Color.BLUE;
            
            // Skin 6.
            if( mouseEstaEncima( mouseX, mouseY, 380, 340, 50, 70 ) )
                skinColorRecuadro[ 6 ] = Color.BLUE;
            
            // Skin 7.
            if( mouseEstaEncima( mouseX, mouseY, 440, 340, 50, 70 ) )
                skinColorRecuadro[ 7 ] = Color.BLUE;
            
            // Skin 8.
            if( mouseEstaEncima( mouseX, mouseY, 500, 340, 50, 70 ) )
                skinColorRecuadro[ 8 ] = Color.BLUE;
            
            // Skin 9.
            if( mouseEstaEncima( mouseX, mouseY, 560, 340, 50, 70 ) )
                skinColorRecuadro[ 9 ] = Color.BLUE;
            
            
                
            if( mouseEstaEncima( mouseX, mouseY, 20, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 80, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 140, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 200, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 260, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 320, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 380, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 440, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 500, 340, 50, 70 ) || mouseEstaEncima( mouseX, mouseY, 560, 340, 50, 70 ) )
                mouseEstaEncimaSkins = true;
            else
                mouseEstaEncimaSkins = false;
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
    
    public void desbloquearSkinEspecial()
    {
        skinEstaDesbloqueada[ 9 ] = true;
    }
    
    public boolean skinEspecialEstaDesbloqueada()
    {
        return skinEstaDesbloqueada[ 9 ];
    }
}
